<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 20/07/2021
  Time: 09:10
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>


<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="#" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="" class="btn btn--without-border active">Start</a></li>
<%--<li><a href="<c:url value="/views/index.jsp" context="#steps" var="currentPage">" class="btn btn--without-border"> test </a></li>--%>

<%--            <li><a href="<c:url value="/views/index.jsp" context="/#steps" var="currentPage"/>"  class="btn btn--without-border">O co chodzi?</a></li>--%>
<%--            <li><a href="${pageContext.request.contextPath}/views/index.jsp#steps"  class="btn btn--without-border">O co chodzi?</a></li>--%>
<%--            <li><a href="<c:url value="/views/index.jsp" context="/#steps" var="currentPage"/>" class="btn btn--without-border">O co chodzi?</a></li>--%>
<%--            <li><a href="<jsp:element name="#steps"/>" class="btn btn--without-border">O co chodzi?</a></li>--%>
            <li><a href="/#steps"  class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="/form" class="btn btn--without-border">Przekaż dary</a></li>
            <li><a href="#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomagać!<br />
                Oddaj niechciane rzeczy w zaufane ręce
            </h1>
        </div>
    </div>
</header>
</body>
</html>