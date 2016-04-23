<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<spring:message code='title.EditCategory' var="title" />
<jsp:include page="head.jsp">
    <jsp:param name="pageTitle" value="${title}" />
</jsp:include>
<body>
    <jsp:include page="header.jsp">
        <jsp:param name="headerTitle" value="${title}" />
    </jsp:include>
    <jsp:include page="nav.jsp" />
    <main>
        <p>
            <spring:message code="info.EditingCategory" arguments="${category.name}" />
        </p>
        <c:url var="formUrl" value="/categories/${category.id}/edit.htm" />
        <form:form id="editCategoryForm" method="POST" action="${formUrl}" modelAttribute="category">
            <form:errors path="name" cssClass="error" />
            <form:label path="name"><spring:message code='label.Name' /></form:label>
            <form:input path="name" id="name" value="" />
            <input type="submit" value="<spring:message code='button.Save' />" />
            <a class="button regularButton" href="<c:url value='/categories.htm' />">
                <spring:message code="button.Cancel" />
            </a>
        </form:form>
    </main>
    <jsp:include page="footer.jsp" />
</body>
</html>