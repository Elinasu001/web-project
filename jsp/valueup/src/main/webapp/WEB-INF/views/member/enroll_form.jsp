<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF\views\include\head.jsp"/>
<title>로그인</title>
</head>

<body>
<div id="wrap" class="join">
	<jsp:include page="/WEB-INF/views/include/inc_header.jsp"/>
 	<div class="contentWrap">
        <div class="contArea">
            <div class="loginArea">
                <form action="join">
                    <div class="form-wrap">
                        <h3><img src="${pageContext.request.contextPath}/assets/images/Icon.png" class="upicon">회원가입</h3>
                        <div class="form-group"><!-- user-invalid -->
                            <label for="userId">아이디</label>
                            <input id="userId" type="text" name="userId" maxlength="14" required class="form-control" placeholder="아이디">
                            <p class="feedback">아이디를 입력해주세요</p>
                        </div>
                        <div class="form-group"><!-- user-invalid -->
                            <label for="userPwd">비밀번호</label>
                            <input id="userPwd" type="password" name="userPwd" size="17" maxlength="30" class="form-control" placeholder="비밀번호">
                            <p class="feedback">비밀번호를 입력해주세요</p>
                        </div>
                        <div class="form-group"><!-- user-invalid -->
                            <label for="userPwdChk">비밀번호 재확인</label>
                            <input id="userPwdChk" type="password" size="17" maxlength="30" required  class="form-control" placeholder="비밀번호 재확인">
                            <p class="feedback">비밀번호 재확인해주세요</p>
                        </div>
                        <div class="form-group"><!-- user-invalid -->
                            <label for="userName">이름</label>
                            <input id="userName" type="text" name="userName" required class="form-control" placeholder="이름">
                            <p class="feedback">이름를 입력해주세요</p>
                        </div>
                        <div class="form-group"><!-- user-invalid -->
                            <label for="userEmail">이메일</label>
                            <input id="userEmail" type="email" name="email" required class="form-control" placeholder="이메일">
                            <p class="feedback">이메일를 입력해주세요</p>
                        </div>
                        
                    </div>
                    <div class="btn-area mt30">
                        <button type="submit" class="btn btn-primary">회원가입</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    
	<jsp:include page="/WEB-INF/views/include/inc_footer.jsp"/>
</div>
</body>
</html>

