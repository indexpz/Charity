<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<jsp:include page="../header_footer/header_css.jsp"/>
<jsp:include page="../header_footer/header_form.jsp"/>

<section class="form--steps">
        <div class="form--steps-container">
<%--            <div class="form--steps-counter"> <span></span></div>--%>
            <!-- STEP 6 -->
    <form:form action="/form_summary" method="post" modelAttribute="donation">

    <div data-step="5" class="active">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text">${donation.quantity} worki, z
            <c:forEach items="${donationCategories}" var="category">
                ${category.name} </c:forEach>
            </span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text"
                                >${institution}</span
                                >
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">

                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li>${donation.street}</li>
                                <li>${donation.city}</li>
                                <li>${donation.zipCode}</li>
                                <li>${donation.phone}</li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li>${donation.pickUpDate}</li>
                                <li>${donation.pickUpTime}</li>
                                <li>${donation.pickUpComment}</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                  <a href="/form">  <button type="button"  class="btn prev-step">Wstecz</button></a>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </div>
    </form:form>
    </div>
</section>

<jsp:include page="../header_footer/footer_main.jsp"/>
<jsp:include page="../header_footer/footer_js.jsp"/>
</body>
</html>
