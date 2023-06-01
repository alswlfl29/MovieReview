<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/auth.css" type="text/css" />
<link rel="stylesheet" href="../resources/common.css" type="text/css" />
<title>로그인</title>
<script>
	function checkPw(){
		console.log(document.getElementById('pw').value);
		console.log(document.getElementById('rePw').value);
		console.log(document.getElementById('pw').value != document.getElementById('rePw').value)
	   if(document.getElementById('pw').value !='' && document.getElementById('rePw').value!=''){
             if(document.getElementById('pw').value != document.getElementById('rePw').value){
            	 document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
            	 document.querySelector('#send').disabled=true;
            	 document.querySelector('#send').style.backgroundColor="#ccc";
            	 document.querySelector('#send').style.cursor="not-allowed";
             }else{
            	 document.getElementById('check').innerHTML='';
               	 document.querySelector('#send').disabled=false;
            	 document.querySelector('#send').style.backgroundColor="#736E66";
            	 document.querySelector('#send').style.cursor="pointer";
             }
	    }
	}
</script>
</head>
<body>
	<%@ include file="../navbar.jsp"%>
	<div class="container">
		<div class="wrapper">
			<h2>회원가입</h2>
			<form method="post" action="http://localhost:8080/free/user/signup/" id="auth">
				<input type="text" name="email" placeholder="email" maxlength="20" required />
				<input type="text" name="nickname" placeholder="nickname" maxlength="20" required />
				<input type="password" id="pw" name="passwd" placeholder="password" maxlength="20" required onchange="checkPw()" />
				<input type="password" id="rePw" name="rePasswd" placeholder="re-password" maxlength="20" required onchange="checkPw()" />
				<div id="check" style="color:red"></div>
				<input type="submit" id="send" name="submit" value="회원가입" />
			</form>	
		</div>
	</div>
</body>
</html>