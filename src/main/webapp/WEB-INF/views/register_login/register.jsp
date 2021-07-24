<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>

</head>
<body>
<jsp:include page="../header_footer/header_css.jsp"/>
<jsp:include page="../header_footer/header_login.jsp"/>



<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form method="post" modelAttribute="data" action="/register">
        <div class="form-group">
            <input type="email" name="username" placeholder="Email" />
            <form:errors path="username" element="div"/>
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło" />
            <form:errors path="password" element="div"/>
        </div>
        <div class="form-group">
            <input type="password" name="password2" placeholder="Powtórz hasło" />
            <form:errors path="password" element="div"/>
        </div>

        <div class="form-group form-group--buttons">
            <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<jsp:include page="../header_footer/footer_main.jsp"/>
</body>
</html>
