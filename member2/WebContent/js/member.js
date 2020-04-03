/**
 * 
 */

var regcheck = function(){
	//이름값
		vname =$('#name').val().trim();
		namelen = vname.length;
	//이름길이
		
		if(namelen <2 || namelen>5){
			alert("이름 2~5사이 입니다.");
			return false;
		}
	//이름 정규식
		namereg= /^[가-힣]+$/;
			if(!(namereg.test(vname))){
			alert("이름 형식오류");
			return false;		
		}
	
	
	// 생년월일 : 숫자4자리-숫자2자리-숫자2자리
	vbir = $('#bir').val().trim();
	birlen = vbir.length;
	
	// 생년월일 길이
	if(birlen <= 0){
		alert("생년월일 입력");
		return false;
	}
	
	// 생년월일 형식 : 숫자4자리-숫자2자리-숫자2자리
	birreg = /^\d{4}\.\d{2}\.\d{2}$/;
	if(!(birreg.test(vbir))){
		alert("생년월일 형식오류");
		return false;
	}
	
	
	
	
	//비밀번호-------------------------------
		vpass=$('#pass').val().trim();
		passlen=vpass.length;
			
	//비밀번호길이
			if(passlen <4 || passlen>10){
				alert("영문이나 숫자로 4~10사이");
				return false;
			}
	//비밀번호 정규식
		passreg= /^[a-zA-Z0-9]+$/;
		if(!(passreg.test(vpass))){
			alert("비밀번호 형식 오류");
			return false;
		}
		
		
	//휴대폰번호------------------------------------
		vphone=$('#hp').val().trim();
		ptelen = vphone.length;
		
	// 휴대폰번호 길이
		if(ptelen<=0){
			alert("전화번호 입력");
			return false;
		}
		
	//휴대폰번호 형식
		ptelreg = /^\d{3}-\d{4}-\d{4}$/;
		if(!(ptelreg).test(vphone)){
			alert("휴대폰번호 형식 오류");
			return false;
		}
		
		

	//이메일-----------------------------------------
		vemail= $('#mail').val().trim();
		maillen = vemail.length;
		
		if(maillen == 0){
			alert("이메일 입력");
			return false;
		}
		
	//이메일정규식
		
		emailreg = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9]+){1,2}$/;
		if(!(emailreg).test(vemail)){
			alert("이메일 형식 오류");
			return false;

		}

		return true;
}