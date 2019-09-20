<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<%-- 입력값에 대한 검증 결과를 view에 출력한다.
	검증결과를 view가 forward될때 가지고 온다. 그 값을 사용하기 위해서는 스프링태그를 이용해서 처 
	1.<form>태그가 아니라 스프링에서 제공되는
	2.
	
	
	 --%>	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/kimsaemERP/common/css/font-awesome.css" rel="stylesheet" />
<!-- Custom styles for this template -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h4>
		<i class="fa fa-angle-right"></i> 게시글 작성하기
	</h4>
	<hr>
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">

				<form:form commandName="boardDTO" class="form-horizontal style-form"
					action="/kimsaemERP/board/user/insert.do" method="post" enctype="multipart/form-data">
					<div class="form-group" style="border: 1px solid #eff2f7;">

						<label class="col-sm-2 col-sm-2 control-label">작성자</label>
						<div class="col-sm-10">
							<input type="hidden" name="id" value="<se:authentication property="principal.id"/>">
							<p class="form-control-static">
								<se:authentication property="principal.name"/>
							</p>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">게시글 유형</label>

							<div class="col-sm-5">
								<select name="category" class="form-control">
									<option value="경조사">경조사</option>
									<option value="사내소식">사내소식</option>
									<option value="게시판">게시판</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">제목</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="title"> 
								<span class="help-block" style="color: red; font-weight: bold;"><form:errors path="title"/> </span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">내용</label>
							<div class="col-sm-8">
								<textarea id="content"
									style="width: 100%; border: 1; overflow: visible; text-overflow: ellipsis;"
									rows=15 name="content">글작성</textarea>
<span
									class="help-block" style="color: red; font-weight: bold;"><form:errors path="content"/> </span>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 text-right">
								<label for="files" class="control-label">파일1</label>
							</div>
							<div class="col-md-8">
								<input multiple type="file" class="form-control input-lg" name="files"
									id="files" placeholder="파일선택">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 text-right">
								<label for="title" class="control-label">파일2</label>
							</div>
							<div class="col-md-8">
								<input multiple type="file" class="form-control input-lg" name="files"
									id="title" placeholder="파일선택">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 text-right">
								<label for="files" class="control-label">파일3</label>
							</div>
							<div class="col-md-8">
								<input multiple type="file" class="form-control input-lg" name="files"
									id="files" placeholder="파일선택">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 text-right">
								<label for="files" class="control-label">파일4</label>
							</div>
							<div class="col-md-8">
								<input multiple type="file" class="form-control input-lg" name="files"
									id="files" placeholder="파일선택">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 text-right">
								<label for="title" class="control-label">파일5</label>
							</div>
							<div class="col-md-8">
								<input multiple type="file" class="form-control input-lg" name="files"
									id="title" placeholder="파일선택">
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-4 text-center"></div>
							<div class="col-lg-2 text-center">
								<button type="submit" class="btn btn-success"
									style="width: 100px; background-color: #0ea006">등록</button>
							</div>
							<div class="col-lg-2 text-center">
								<button type="reset" class="btn btn-default"
									style="width: 100px; background-color: #9a9a9a">취소</button>
							</div>

						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>