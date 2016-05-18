<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<spring:message code='title.Rates' var="title"/>
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
                <spring:message code="info.TodaysRates" />
            </h2>
            <ul class="rates">
                <li>
                    1 EUR
                </li>
                <c:forEach var="rate" items="${exchangeRates.rates}">
                    <li>
                        ${rate.value} ${rate.key}
                    </li>
                </c:forEach>
            </ul>
        </section>
    </main>
    <jsp:include page="footer.jsp" />
</body>
</html>