/**
 * 정규식을 이용한 데이터 검증.
 * 방법 1 
 *  비교문자값.match('정규식')	: 문자열이 정규식에 맞는가? 리턴방법 : true : 비교문자값. / false : null
 * 방법 2 
 *  정규식.test(비교문자값) : 비교문자값이 정규식에 맞는가? 리턴방법 : boolean(true /false) 
 */

function sendProc(){
	
	f = document.ff;
	// 아이디부분!!!
	//아이디는 영문자로 시작하고 숫자를 조합해서 8~12사이로 한다.
	
	idvalue = f.id.value; // id에 적은 값.
	idlen = idvalue.trim().length; // 적은 id의 길이.
	
	if(idlen == 0) {
		alert("아이디를 입력해주세요. ");
		return false;
	}
	if(idlen < 8 || idlen > 15){
		alert("아이디는 8~15글자로 작성해주세요.");
		return false;
	}
	
	
	idreg = /^[a-zA-Z][0-9a-zA-Z]{7,14}$/;
	// 영문자로 시작하고, 그 뒤에 숫자혹은 영문자로 채워서 8~15글자로 아이디를 만들어라.
	
	if(!(idreg.test(idvalue))){ // 정규식이 맞지 않으면
		alert("아이디 형식 오류");
		return false;
	}
	//======================================================================
	// 이름부분!!!
	namevalue = f.name.value;
	namelen = namevalue.trim().length;
	if(namelen == 0) {
		alert("이름을 입력해주세요.");
		return false;
	}
	
	namereg = /^[가-힣]+|^[a-zA-Z]+/;//한글또는 영문으로 시작했는가?
	if(namereg.test(namevalue)){
		rkor = /^[가-힣]+$/; // 한글로만 작성되었는가?
		reng = /^[a-zA-Z]+$/; // 영문으로만 작성되었는가?
		
		// 한글일때, 영문일때 길이를 다르게 주기위함.
		if(rkor.test(namevalue)){// 한글일때 길이
			if(namelen<2 || namelen>5){
				alert("한글이름은 2~5글자로 작성해주세요.");
				return false;
			}
		}else if(reng.test(namevalue)){ // 영문일때 길이
			if(namelen<5 || namelen>20){
				alert("영문이름은 5~20글자로 작성해주세요.");
				return false;
			}
		}else{
			// 영문으로 시작해서 영문으로 안끝난경우,
			// 한글로 시작해서 한글로 안끝난경우.
			alert("이름 형식 오류.(한글, 영문중 하나로 작성되어야함)");
			return false;
		}
		
	} else{
		// 한글로 시작, 영문으로시작 둘다 안했다.
		alert("이름 형식 오류.(한글, 영문중 하나로 시작해야함.)");
		return false;
	}
	
	//======================================================================
	// 비밀번호 부분!!!!
	// 비밀번호 - 영문 숫자 특수문자중 하나로 시작하고, 영문 숫자 특수문자가 반드시
	// 한 글자 이상 씩 포함되어야 한다.(8~15글자)
	
	//전방탐색
	// \w+(?=찾는문자열) --> 찾는문자열을 찾아서, 찾는 문자열을 기준으로
	// 					앞에 한 번 이상 나온 문자/숫자인 \w를 찾아라.
	
	// \w*(?=str) --> str을 기준으로 \w가 한번나왔을 수도, 안나왔을수도 있음.
	//					안나왔으면 str로 시작하는것.
	passvalue = f.pass.value;
	passlen = passvalue.trim().length;
	
	pass2 = f.pass2.value;
	if(passvalue != pass2){
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	
	if(passlen == 0) {
		alert("비밀번호를 입력해주세요. ");
		return false;
	}
	if(passlen < 8 || passlen > 15){
		alert("비밀번호는 8~15글자로 작성해주세요.");
		return false;
	}
	passreg=/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*-]).{8,15}$/;
	if(!(passreg.test(passvalue))){
		alert("비밀번호 형식 오류.\n영문 소문자와 대문자, 숫자, 특수문자를 모두 사용해주세요.");
		return false;
	}
	//======================================================================
	// 휴대폰번호 부분!!
	//
	telvalue = f.tel.value;
	tellen = telvalue.trim().length;
	
	// 얘는 길이체크X
	
	if(tellen == 0){
		alert("전화번호를 입력해주세요.");
		return false;
	}
	telreg = /^\d{3}-\d{4}-\d{4}$|^\d{3}-\d{3}-\d{4}$/;
	if(!(telreg.test(telvalue))){
		alert("전화번호 형식 오류");
		return false;
	}
	//======================================================================
	//이메일
	mailvalue = f.mail.value;
	maillen = mailvalue.trim().length;
	
	if(maillen == 0){
		alert("이메일 입력");
		return false;
	}
	
	// 길이체크 X
	mailreg=/^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9]+){1,2}$/;
	if(!(mailreg.test(mailvalue))){
		alert("이메일 형식 오류");
		return false;
	}
	
	return true;
	
}