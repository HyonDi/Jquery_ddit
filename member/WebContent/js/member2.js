/**
 * 
 */



var idcheck = function(){
	
	idvalue = $('#id').val().trim();
	idlen = idvalue.length;
	
	// 공백체크
	if(idlen <= 0){
		alert("아이디를 입력하세요.");
		return false;
	}
	
	// 길이 체크
	if(idlen < 4 || idlen >12){
		alert('id 4~12사이로 입력');
		 return false;
	}
	
	//데이터 형식 체크(정규식)
	idreg = /^[a-z][a-zA-Z0-9]{3,11}$/;
	if(!(idreg.test(idvalue))){
		alert("아이디형식오류");
		return false;
	} 
	count++;
	return true;
};

var passcheck = function(){
//비밀번호-------------------------------
	vpass=$('#pass').val().trim();
	passlen=vpass.length;
		
//비밀번호길이
		if(passlen <4 || passlen>10){
			alert("비밀번호 4~10사이");
			return false;
		}
//비밀번호 정규식 영문대소문자특수문자숫자 반드시 1개이상씩 조합
		passreg= /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*-]).{4,10}$/;
	if(!(passreg.test(vpass))){
		alert("비밀번호 형식 오류");
		return false;
	}
	count++;
	return true;
};

var pass2check = function(){
	vpass = $('#pass').val().trim();
	vpass2 = $('#pass2').val().trim();
	
	pass2len = vpass2.length;
	
	if(pass2len <= 0){
		// 입력이 안된것.
		return false;
	}
	
	if(vpass != vpass2){
		// 비밀번호랑 비밀번호 확인이 같지 않음.
		return false;
	}
	count++;
	return true; // 마지막은 return true 줘야함.
};


var telcheck = function(){
	vtel = $('#hp').val().trim();
	vtellen = vtel.length;
	
	if(vtellen <= 0){
		return false;
	}

//휴대폰번호 형식
	ptelreg = /^\d{3}-\d{4}-\d{4}$/;
	if(!(ptelreg).test(vtel)){
		alert("휴대폰번호 형식 오류");
		return false;
	}
	count++;
	return true;
};

var mailcheck = function(){
	vmail = $('#mail').val().trim();
	
	vmaillen = vmail.length;
	
	if(vmaillen <= 0){
		return false;
	}
	
	//이메일정규식
	
	emailreg = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9]+){1,2}$/;
	if(!(emailreg).test(vmail)){
		alert("이메일 형식 오류");
		return false;

	}
	count++;
	return true;
};

var bircheck = function(){
	vbir = $('#bir').val().trim();
	
	vbirlen = vbir.length;
	
	if(vbirlen <= 0){
		return false;
	}
	count++;
	return true;
	
};

var namecheck = function(){
	
	vname =$('#name').val().trim();
	namelen = vname.length;
	
	// 공백
	if(namelen <= 0){
		alert("이름 입력");
		return false;
	}
	
	// 정규식-한글 또는 영문
	namereg = /^[가-힣]+$|^[a-zA-Z]+$/;
	
	// 길이체크는 정규식체크 이후에 한다.
	if(namereg.test(vname)){
		// 둘중하나가 맞으면 이 안으로 들어옴.
		regkor = /^[가-힣]+$/; // 2~5
		regeng = /^[a-zA-Z]+$/; //5~10
		
		if(regkor.test(vname)){
			// 여기들온건 한글이름
			if(namelen < 2 || namelen > 5){
				alert("한글 2~5사이");
				return false;
			}
		}else {
			// 여긴 영문이름
			if(namelen < 5 || namelen > 10){
				alert("영문 5~10사이");
				return false;
			}
		}
	}else{
		// 영문-영문, 한글-한글 아님.(이름형식오류)
		alert("이름 형식 오류");
		return false;
	}
	count++;
	return true;
}

