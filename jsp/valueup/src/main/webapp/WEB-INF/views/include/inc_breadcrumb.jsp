<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="breadcrumb">
  <div class="inner">
    <a href="${pageContext.request.contextPath}/" class="home ir">홈</a>
    <c:forEach var="item" items="${breadcrumbs}"> >
      <c:choose>
        <c:when test="${not empty item.url}">
          <a href="${pageContext.request.contextPath}${item.url}">
            ${item.name}
          </a> 
        </c:when>
        <c:otherwise>
          <span>${item.name}</span>
        </c:otherwise>
      </c:choose>
    </c:forEach>
  </div>
</div>
