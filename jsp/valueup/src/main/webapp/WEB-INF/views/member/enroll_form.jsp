<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF\views\include\head.jsp"/>
<title>회원가입</title>
</head>

<body>
<div id="wrap" class="join">
	<jsp:include page="/WEB-INF/views/include/inc_header.jsp"/>
 	<div class="contentWrap">
        <div class="contArea">
            <div class="loginArea">
                <form action="signUp.mb" method="post">
                    <div class="form-wrap">
                        <h3><img src="${pageContext.request.contextPath}/assets/images/Icon.png" class="upicon">회원가입</h3>
                        <div class="form-group"><!-- user-valid / user-invalid -->
                            <label for="userId">아이디</label>
                            <input id="userId" type="text" name="userId" maxlength="14" required class="form-control" placeholder="숫자와 영어로 5-30자" onkeyup="idCheck();">
                            <p class="feedback" id="idChk"></p>
                        </div>
                        <div class="form-group"><!-- user-invalid -->
                            <label for="userPwd">비밀번호</label>
                            <input id="userPwd" type="password" name="userPwd" size="17" maxlength="30" class="form-control" placeholder="비밀번호">
                            <p class="feedback"></p>
                        </div>
                        <div class="form-group"><!-- user-invalid -->
                            <label for="userPwdChk">비밀번호 재확인</label>
                            <input id="userPwdChk" type="password" size="17" maxlength="30" required  class="form-control" placeholder="비밀번호 재확인">
                            <p class="feedback"></p>
                        </div>
                        <div class="form-group"><!-- user-invalid -->
                            <label for="userName">이름</label>
                            <input id="userName" type="text" name="userName" required class="form-control" placeholder="이름">
                            <p class="feedback"></p>
                        </div>
                        <div class="form-group"><!-- user-invalid -->
                            <label for="userEmail">이메일</label>
                            <input id="userEmail" type="email" name="email" required class="form-control" placeholder="이메일">
                            <p class="feedback"></p>
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

<script>
function idCheck() {
    const $userId = $('#userId');
    const idValue = $userId.val().trim();
    const $group = $userId.closest('.form-group'); //  아이디 입력란의 form-group만 선택
    const $feedback = $('#idChk'); // 아이디 피드백 문구 영역
    
    // 기존 상태 초기화
    $group.removeClass('user-valid user-invalid');
    
    if (idValue.length === 0) {
        $feedback.text('');
        return;
    }

    if (idValue.length < 5) {
        // 5자 미만 입력 시 피드백 표시
        $group.addClass('user-invalid');
        $feedback.text('아이디는 최소 5자 이상이어야 합니다.');
        return;
    }
    
    if (idValue.length >= 5) {
        $.ajax({
            url: 'checkId',
            type: 'get',
            data: { id: idValue },
            success: function(response) {
                console.log(response);

                if (response === 'NNNN') {
                    //이미 존재하는 아이디
                    $group.addClass('user-invalid');
                    $feedback.text('이미 존재하는 아이디입니다.');
                } else {
                    // 사용 가능한 아이디
                    $group.addClass('user-valid');
                    $feedback.text('사용 가능한 아이디입니다.');
                }
            },
            error: function() {
                console.log('AJAX 요청 실패');
            }
        });
    } 
}
</script>

</body>
</html>

