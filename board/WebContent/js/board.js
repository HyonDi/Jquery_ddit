/**
 * 
 */



// <<댓글 출력>> 해당 글을 클릭했을 때 글의 댓글 출력.
var replyList = function(bonum, action){
	console.log(bonum);
	
	$(action).parents('.panel').find('.rep').remove();
	
	$.ajax({
		url : '/board/ReplyList',
		type : 'post',
		data : { 'bonum' : bonum },
		dataType : 'json',
		success : function(res){
			rep = "";
			$.each(res, function(i, v){
				rep += '<div class="panel-body rep">';
				
				rep += '<p style="float:left; width:80%;">';
				rep += '<span>' + v.name + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				rep += v.date + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				rep += '</span><br>';
				rep += '<span class="cont">' + v.cont + '</span>';
				rep += '</p>';

				rep += '<p style="float:right;">';
				rep += '<button idx="' + v.renum + '" type="button" name="r_modify" class="action">댓글수정</button>';
				rep += '<button idx="' + v.renum + '" type="button" name="r_delete" class="action">댓글삭제</button>';
				rep += '</p>';
				
				rep += '</div>';
			});

			$(action).parents('.panel').find('.pbody').append(rep);
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		}
	
	});
};


// <<댓글 저장>> 저장 후 (등록버튼에서 bonum을 가져와서) 해당 글의 댓글 출력
var replySave = function(bonum, action){
	
	$.ajax({
		url : '/board/ReplySave',
		data : reply, // bonum, name, cont
		type : 'post',
		dataType : 'json',
		success : function(res){
			// 성공/실패 출력.
			alert(res.sw);
			// 댓글리스트 출력.
			replyList(bonum, action);
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		}
		
	});
};



// << 게시글 페이지 리스트>> readServer

// <<게시글 리스트>> readServer
// 호출시 : readServer(2) : 2페이지 리스트를 가져와라.
var readServer = function(cpage){
	
	$.ajax({
		/*url : '/board/BoardList',*/ //boardList 는 src>controller 속에 있는 서블릿 이름임.
		url : '/board/ListPage',
		data : { "page" : cpage},
		type : 'get', //get일때는 생략해도 된다.
		dataType : 'json',
		
		success : function(res){
			// res = 서블릿에서 수행. jsp 수행. 이후 값
			code = '<div class="panel-group" id="accordion">';
			$.each(res.data, function(i,v){
				// acc파일에있는글이 필요하다.
				code += '<div class="panel panel-default">';
			    code += '  <div class="panel-heading">';
			    code += '    <h4 class="panel-title">';
			    code += '      <a idx="' + v.seq + '" class="action" name="list" data-toggle="collapse" data-parent="#accordion" href="#collapse' + v.seq + '">' + v.subject + '</a>';
			    code += '    </h4>';
			    code += '  </div>';
			    code += '  <div id="collapse' + v.seq  + '" class="panel-collapse collapse">';
			    code += '    <div class="panel-body pbody">';
			    
				code += '		<p style="float:left; width:80%;">';
				code += '		작성자 : ' + v.writer + '&nbsp&nbsp&nbsp&nbsp&nbsp';
				code += '		이메일 : ' + v.mail + '<br> 작성일 : ' + v.date + '&nbsp&nbsp&nbsp&nbsp&nbsp조회수 : ' + v.hit ;
				code += '		</p>';

				code += '		<p style="float:right;">';		
				code += '		<button idx="' + v.seq + '" type="button" name="modify" class="action">수정</button>';
				code += '		<button idx="' + v.seq + '" type="button" name="delete" class="action">삭제</button>';
				code += '		</p>';
				code += '		<hr/>';
					
				
				code += '		<p> ';
				code += 		'내용출력 <br>내용출력 <br>';
				code += 		v.content;
				code += '		</p>';
				code += '		<p><textarea Class="area" cols="60">';
				code += 		'댓글 쓰기';
				code += '		</textarea> ';
				code += '		<button style="height:45px; vertical-align:top" idx="'+ v.seq + '" type="button" name="reply" class = "action">등록</button>';
				code += '		</p>';
			    code += '    </div>';
			    code += '  </div>';
			    code += '</div>';

			});
			
			code += '</div>';
			$('#boardlist').html(code);
			
			// 이전버튼
			/*$('<button></button>')*/
			if(1 < res.startpage){
				pager = "<a class='prev' href='#'>이전</a>";
			}else{
				pager = "";
			}
			$('#boardlist').append(pager);
			
			
			
			// 페이지 번호버튼
			for(i = res.startpage; i <= res.endpage; i ++ ){
				
				$('<button></button>', {
					'class' : 'paging active',
					'text' : i
				}).appendTo('#boardlist');
			}
			// 다음버튼
			if(res.totalpage > res.endpage){
				pager = "<a class='next' href='#'>다음</a>";
			}else{
				pager = "";
			}
			$('#boardlist').append(pager);
			
		}, error : function(xhr) {
			alert("상태 : " + xhr.status);
		}
		// 여기에쓰면 페이지새롴고침할때 1번실행됨. 우린 자주써야해서 함수로, 외부스크립트로 빼놓자.(js폴더>board.js)
	});
};