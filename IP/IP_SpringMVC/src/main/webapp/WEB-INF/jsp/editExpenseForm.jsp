<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<spring:message code='title.EditExpense' var="title" />
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
            <spring:message code="info.EditingExpense" arguments="${model.expense.name},${model.category.name}" />
        </p>
        <c:url var="formUrl" value="/categories/${model.category.id}/expenses/${model.expense.id}/edit.htm" />
        <form:form id="editExpenseForm" method="POST" action="${formUrl}" modelAttribute="expense">
            <form:errors path="name" cssClass="error" />
            <form:label path="name"><spring:message code="label.Name" /></form:label>
            <form:input path="name" id="name" />
            <form:errors path="amount" cssClass="error" />
            <form:label path="amount"><spring:message code="label.Price" /></form:label>
            <form:input path="amount" id="amount" />
            <form:errors path="priority" cssClass="error" />
            <form:label path="priority"><spring:message code="label.Priority" /></form:label>
            <form:select path="priority" id="priority">
                <form:options />
            </form:select>
            <input type="submit" value="<spring:message code="button.Add" />">
            <a class="button regularButton" href="<c:url value='/categories.htm' />">
                <spring:message code="button.Cancel" />
            </a>
        </form:form>
    </main>
    <jsp:include page="footer.jsp" />
</body>
</html>