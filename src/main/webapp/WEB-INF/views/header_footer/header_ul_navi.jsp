
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<ul>
    <li><a href="/" class="btn btn--without-border active">Start</a></li>
    <li><a href="<c:url value="/#steps" />"class="btn btn--without-border">O co chodzi?</a></li>
    <li><a href="<c:url value="/#about-us" />" class="btn btn--without-border">O nas</a></li>
    <li><a href="<c:url value="/#help" />" class="btn btn--without-border">Fundacje i organizacje</a></li>
    <li><a href="<c:url value="/#contact" />" class="btn btn--without-border">Kontakt</a></li>
</ul>