<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<spring:message code='title.Home' var="title" />
<jsp:include page="head.jsp">
    <jsp:param name="pageTitle" value="${title}" />
</jsp:include>
<body>
    <jsp:include page="header.jsp">
        <jsp:param name="headerTitle" value="${title}" />
    </jsp:include>
    <jsp:include page="nav.jsp" />
    <main>
        <section>
            <h2>
                <spring:message code="info.HelloWorld" />
            </h2>
        </section>
    </main>
    <jsp:include page="footer.jsp" />
</body>
</html>