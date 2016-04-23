<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer>
    <p>
        Joris Palings - r0377429 - 2TX/3 - Internetprogrammeren
    </p>
    <select name="lang" id="lang">
        <option value="?lang=en" <c:if test="${pageContext.response.locale == 'en'}">selected</c:if>>
            English
        </option>
        <option value="?lang=nl_BE" <c:if test="${pageContext.response.locale == 'nl_BE'}">selected</c:if>>
            Nederlands
        </option>
    </select>
</footer>