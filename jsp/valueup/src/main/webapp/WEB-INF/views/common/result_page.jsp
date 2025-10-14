<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF\views\include\head.jsp"/>
<title>실패</title>
</head>
<body>
<div id="wrap">
	<jsp:include page="/WEB-INF/views/include/inc_header.jsp"/>
 	<div class="contentWrap">
           <div class="contArea">
           		<h1>${ msg }</h1>
           </div>
       </div>
	<jsp:include page="/WEB-INF/views/include/inc_footer.jsp"/>
</div>
</body>
</html>

