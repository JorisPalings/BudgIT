<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="pageTitle" value="${category.name}" />
</jsp:include>
<body>
    <jsp:include page="header.jsp">
        <jsp:param name="headerTitle" value="${category.name}" />
    </jsp:include>
    <jsp:include page="nav.jsp" />
    <main>
        <a class="button regularButton" href="<c:url value='/categories.htm' />">
            <spring:message code="button.Back" />
        </a>
        <a class="button specialButton" href="<c:url value='/categories/${category.id}/expenses/new.htm' />">
            <spring:message code="button.AddNewExpense" />
        </a>
        <c:forEach var="expense" items="${category.expenses}">
            <section>
                <a href="<c:url value='/categories/${category.id}/expenses/${expense.id}/delete.htm' />">
                    <img class="options" src="<c:url value='/images/delete.png' />" alt="<spring:message code='alt.Delete' />" />
                </a>
                <a href="<c:url value='/categories/${category.id}/expenses/${expense.id}/edit.htm' />">
                    <img class="options" src="<c:url value='/images/edit.png' />" alt="<spring:message code='alt.Edit' />" />
                </a>
                <img class="toggleable arrow" src="<c:url value='/images/arrow.png' />" alt="<spring:message code='alt.Arrow' />" />
                <h2 class="toggleable">
                    ${expense.name}
                </h2>
                <ul class="expense">
                    <li class="amount">
                        ${expense.amount}
                    </li>
                    <li class="priority">
                        ${expense.priority} priority
                    </li>
                    <li class="dateTime">
                        ${expense.dateTime}
                    </li>
                </ul>
            </section>
        </c:forEach>
        <section>
            <dl>
                <dt><spring:message code="info.Total" /></dt>
                <dd>${category.total}</dd>
            </dl>
        </section>
    </main>
    <jsp:include page="footer.jsp" />
</body>
</html>