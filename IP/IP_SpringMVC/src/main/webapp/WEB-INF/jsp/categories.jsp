<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<spring:message code='title.Overview' var="title"/>
<jsp:include page="head.jsp">
    <jsp:param name="pageTitle" value="${title}" />
</jsp:include>
<body>
    <jsp:include page="header.jsp">
        <jsp:param name="headerTitle" value="${title}" />
    </jsp:include>
    <jsp:include page="nav.jsp" />
    <main>
        <a class="button specialButton" href="<c:url value='/categories/new.htm' />"><spring:message code='button.AddNewCategory' /></a>
        </form>
        <c:forEach var="category" items="${application.categories}">
            <section>
                <a href="<c:url value='/categories/${category.value.id}/delete.htm' />">
                    <img class="options" src="<c:url value='/images/delete.png' />" alt="<spring:message code='alt.Delete' />" />
                </a>
                <a href="<c:url value='/categories/${category.value.id}/edit.htm' />">
                    <img class="options" src="<c:url value='/images/edit.png' />" alt="<spring:message code='alt.Edit' />" />
                </a>
                <a href="<c:url value='/categories/${category.value.id}/expenses/new.htm' />">
                    <img class="options" src="<c:url value='/images/add.png' />" alt="<spring:message code='alt.Add' />" />
                </a>
                <a href="<c:url value='/categories/${category.value.id}.htm' />">
                    <img class="options" src="<c:url value='/images/view.png' />" alt="<spring:message code='alt.View' />" />
                </a>
                <img class="toggleable arrow" src="<c:url value='/images/arrow.png' />" alt="<spring:message code='alt.Arrow' />" />
                <h2 class="toggleable">
                    ${category.value.name}
                </h2>
                <c:if test="${not empty category.value.expenses}">
                    <dl>
                        <c:forEach var="expense" items="${category.value.expenses}">
                            <dt>${expense.name}</dt>
                            <dd>€${expense.amount}</dd>
                        </c:forEach>
                            <dt><spring:message code="info.CategoryTotal" /></dt>
                        <dd>€${category.value.total}</dd>
                    </dl>
                </c:if>
            </section>
        </c:forEach>
        <section>
            <dl>
                <dt><spring:message code="info.Total" /></dt>
                <dd>€<fmt:formatNumber value="${application.total}" maxFractionDigits="2"/></dd>
            </dl>
        </section>
    </main>
    <jsp:include page="footer.jsp" />
</body>
</html>