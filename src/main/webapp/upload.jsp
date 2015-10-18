<%@ page language="java" contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <%--<script>--%>
        <%--$(document).ready(function() {--%>
            <%--$("#uploadForm").submit(function(e) {--%>
                <%--var data = new FormData(this);--%>
                <%--$.ajax({--%>
                    <%--url: "upload",--%>
                    <%--type: "POST",--%>
                    <%--data: data,--%>
                    <%--contentType: false,--%>
                    <%--processData: false,--%>
                    <%--success: function(msg) {--%>
                        <%--$("#block").html('<img height="100" width="100" src="data:image/jpg;base64,' + msg + '" />');--%>
                    <%--}--%>
                <%--});--%>
                <%--e.preventDefault();--%>
            <%--});--%>
            <%--$("$uploadForm").submit();--%>
        <%--});--%>
    <%--</script>--%>
</head>
<body>
    <c:forEach items="${images}" var="item">
        <c:out value="${item}" />
    </c:forEach>
</body>
</html>
