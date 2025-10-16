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
<div id="wrap">
	<jsp:include page="/WEB-INF/views/include/inc_header.jsp"/>
 	<div class="contentWrap">
	     <div class="contArea">
	         <div class="inner">
	             <h2 class="sec-tit"><img src="../../assets/images/Icon.png" class="upicon">자유 게시판</h2>
	             
	             <div class="form-group mt60 searchBd">
	                 <div class="flex-row gap5">
	                     <div class="col col-4">
	                         <div id="phn-first" class="se-select" data-stove="select" data-uicase="slide">
	                             <div class="e-hidden-title">TITLE</div>
	                             <select required="" title="">
	                                 <option value="" hidden="">안녕</option>
	                                 <option value="0">000</option>
	                                 <option value="1">111</option>
	                                 <option value="2">222</option>
	                                 <option value="3">333</option>
	                                 <option value="4">444</option>
	                             </select>
	                         </div>
	                     </div>
	                     <div class="col">
	                         <input id="search-input" type="text" class="form-control ipt-pd-r" placeholder="입력해주세요">
	                         <span class="ipt-right ico flex-row gap10"><button type="reset" class="btn btn-ipt-clear"><span class="sr-only">삭제버튼</span></button><button type="button" class="btn btn-ipt-search"><span class="sr-only">검색버튼</span></button></span>
	                     </div>
	                 </div>
	             </div>
	             
	             <div class="btn-sec mt30">
	                 <button class="btn-sm">글쓰기</button>
	             </div>
	             <div class="table-wrap">
	                 <div class="table-type1 ft-sticky">
	                     <table>
	                         <caption>자유 게시판- 번호, 카테고리, 작성자, 제목, 작성일, 조회수</caption>
	                         <colgroup>
	                             <col width="10%">
	                             <col width="20%">
	                             <col width="20%">
	                             <col width="30%">
	                             <col width="20%">
	                             <col width="10%">
	                         </colgroup>
	                         <thead>
	                             <tr>
	                                 <th scope="row">번호</th>
	                                 <th scope="row">카테고리</th>
	                                 <th scope="row">작성자</th>
	                                 <th scope="row">제목</th>
	                                 <th scope="row">작성일</th>
	                                 <th scope="row">조회수</th>
	                             </tr>
	                         </thead>
	                         <tbody>
	                             <tr>
	                                 <td>43</td>
	                                 <td>css</td>
	                                 <td>망아지3</td>
	                                 <td>가가가가가가가</td>
	                                 <td>2025-10-01</td>
	                                 <td>10</td>
	                             </tr>
	                             <tr>
	                                 <td>43</td>
	                                 <td>css</td>
	                                 <td>망아지3</td>
	                                 <td>가가가가가가가</td>
	                                 <td>2025-10-01</td>
	                                 <td>10</td>
	                             </tr>
	                             <tr>
	                                 <td>43</td>
	                                 <td>css</td>
	                                 <td>망아지3</td>
	                                 <td>가가가가가가가</td>
	                                 <td>2025-10-01</td>
	                                 <td>10</td>
	                             </tr>
	                             <tr>
	                                 <td>43</td>
	                                 <td>css</td>
	                                 <td>망아지3</td>
	                                 <td>가가가가가가가</td>
	                                 <td>2025-10-01</td>
	                                 <td>10</td>
	                             </tr>
	                             <tr>
	                                 <td>43</td>
	                                 <td>css</td>
	                                 <td>망아지3</td>
	                                 <td>가가가가가가가</td>
	                                 <td>2025-10-01</td>
	                                 <td>10</td>
	                             </tr>
	                             <tr>
	                                 <td>43</td>
	                                 <td>css</td>
	                                 <td>망아지3</td>
	                                 <td>가가가가가가가</td>
	                                 <td>2025-10-01</td>
	                                 <td>10</td>
	                             </tr>
	                             <tr>
	                                 <td>43</td>
	                                 <td>css</td>
	                                 <td>망아지3</td>
	                                 <td>가가가가가가가</td>
	                                 <td>2025-10-01</td>
	                                 <td>10</td>
	                             </tr>
	                             <tr>
	                                 <td>43</td>
	                                 <td>css</td>
	                                 <td>망아지3</td>
	                                 <td>가가가가가가가</td>
	                                 <td>2025-10-01</td>
	                                 <td>10</td>
	                             </tr>
	                         </tbody>
	                     </table>
	                 </div>
	             </div>
	             <div id="paging_div" class="pagination-wrap">
	                 <div class="pagination">
	                     <a class="btn-circle prevDb nb ir" href="javascript:pageFunc.selectNoticeList(1)">이전</a>
	                     <a class="btn-circle prev nb ir" href="javascript:pageFunc.selectNoticeList(1)">이전</a>
	                     <ul>
	                         <li><a href="#" onclick="pageFunc.selectNoticeList(1)" class="btn-circle nb">1</a></li>
	                         <li><a href="#" onclick="pageFunc.selectNoticeList(2)" class="btn-circle nb active" title="현재페이지">2</a></li>
	                     </ul>
	                     <a class="btn-circle next nb ir" href="javascript:pageFunc.selectNoticeList(3)">다음</a>
	                     <a class="btn-circle nextDb nb ir" href="javascript:pageFunc.selectNoticeList(3)">다음</a>
	                 </div>
	             </div>
	         </div>
	     </div>
	 </div>
	<jsp:include page="/WEB-INF/views/include/inc_footer.jsp"/>
</div>
</body>
</html>

