<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
<script type="text/javascript">
	  $(document).ready(function(){
			$("#sql").on("click",function(){
				$("#sqlform").toggle()
			});
	  });
	 
	
</script>
</head>
<body>
	<h1>��ť�� �ڵ� �׽�Ʈ</h1>
	<hr />
	
		<ul>
			<li id="sql" style="cursor: text;"><h2>SQL Injection �׽�Ʈ</h2></li>
		</ul>
	
	<div class="sql" id="sqlform" style="display:none">
		<font color="white" size="5" margin="1"
			style="background-color: green; font-weight: bold">
			&nbsp;&nbsp;&nbsp; SQL ������ &nbsp;&nbsp;&nbsp;</font>
		<hr />
		<form action="/kimsaemERP/test1.do" id="myform1" method="post">
			
			  1. SQL Injection(������ȸ)<br />
		      	���̵�: <input type="text" name="id" id="id_test1">
		      	  PASSWORD: <input
					type="password" name="pass" id="pass_test1">
					 <input
					type="submit" id="run1" value="����">  
		             
		 
		</form>

	
	</div>
	<div id="result" style="color:red">
		<h3>${result}</h3>
	</div>
</body>
</html>