/**
 * 
 */

function proc1(){
			namevalue = document.ff.name.value;
			idvalue = document.ff.id.value;
			namelen = namevalue.trim().length;
			idlen = idvalue.trim().length;
			
			if(namelen == 0){
				alert("이름을 입력하세요.");
				return false;
			}
			
			if(namelen <2 || namelen >5){
				alert("이름은 2~5글자 사이로 입력해주세요.");
				return false;
			}
	
			
			if(idlen == 0){
				alert("아이디를 입력하세요.");
				return false;
			}
			
			if(idlen <8 || idlen > 15){
				alert("아이디는 8~15글자 사이로 입력해주세요.");
				return false;
			}
			
			res = "이름 : " + namevalue + "<br>";
			res += "아이디 : " + idvalue + "<br>";
			res += "<span>환영합니다. </span><br>"; 
			document.getElementById("result2").innerHTML = res; 
			
		}