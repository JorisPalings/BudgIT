<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav>
    <ul>
        <li>
            <a href="<c:url value='/index.htm' />">
                <spring:message code="title.Home" />
            </a>
        </li><li>
            <a href="<c:url value='/categories.htm' />">
                <spring:message code="title.Overview" />
            </a>
        </li>
    </ul>
</nav>