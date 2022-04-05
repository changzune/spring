<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var isMsg = true;
<c:if test="${!empty msg}">
	if(isMsg){
	alert("${msg}");
		isMsg = false;
	}
</c:if>

</script>



</head>
<body>
<h3>게시판 리스트</h3>
<a href="view.do?no=10">열심히 하겠습니다.</a><br>
<a href="write.do"><button>글쓰기</button></a>


</body>
</html>