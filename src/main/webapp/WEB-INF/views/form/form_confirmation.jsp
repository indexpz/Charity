
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<jsp:include page="../header_footer/header_css.jsp"/>
<jsp:include page="../header_footer/header_form.jsp"/>

<form:form action="/form_confirmation" method="post" modelAttribute="donation">
    <header class="header--form-page">
        <nav class="container container--70">
            <ul class="nav--actions">
                <li class="logged-user">
                    Witaj Agata
                    <ul class="dropdown">
                        <li><a href="#">Profil</a></li>
                        <li><a href="#">Moje zbiórki</a></li>
                        <li><a href="#">Wyloguj</a></li>
                    </ul>
                </li>
            </ul>

            <ul>
                <li><a href="index.html" class="btn btn--without-border active">Start</a></li>
                <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>
                <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>
                <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
                <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>
            </ul>
        </nav>

        <div class="slogan container container--90">
            <h2>
                Dziękujemy za przesłanie formularza Na maila prześlemy wszelkie
                informacje o odbiorze.
            </h2>
        </div>
    </header>
</form:form>

<jsp:include page="../header_footer/footer_main.jsp"/>
<jsp:include page="../header_footer/footer_js.jsp"/>
</body>
</body>
</html>
