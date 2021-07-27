<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
</head>


<body>
<jsp:include page="../header_footer/header_css.jsp"/>
<jsp:include page="../header_footer/header_form.jsp"/>


<section class="form--steps">

    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form:form action="form" method="post" modelAttribute="donation">

        <!-- STEP 1: class .active is switching steps -->
        <div data-step="1" class="active">
            <h3>Zaznacz co chcesz oddać:</h3>

            <c:forEach items="${categories}" var="category" >
                <div class="form-group form-group--checkbox">
                    <label>

    <form:checkbox path="categories" value="${category.id}"  />
                        <span  class="checkbox checkbox-square">
                            </span>
                        <span class="description">${category.name}</span>

                    </label>
                </div>
            </c:forEach>
            <div class="form-group form-group--checkbox">

            </div>
            <div class="form-group form-group--buttons">
                <button type="submit" class="btn next-step">Dalej</button>
            </div>
        </div>


        <!-- STEP 2 -->
        <div data-step="2">
            <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>
            <div class="form-group form-group--inline">
                <label>
                    Liczba 60l worków:
                    <form:input path="quantity" type="number" name="bags" step="1" min="1"/>

                </label>
            </div>

            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <button type="button" class="btn next-step">Dalej</button>
            </div>
        </div>

        <!-- STEP 4 -->
        <div data-step="3">
            <h3>Wybierz organizacje, której chcesz pomóc:</h3>
            <c:forEach items="${institutions}" var="institution">
                <div class="form-group form-group--checkbox">
                    <label>


                      <form:radiobutton path="institution" value="${institution.id}"/>
                        <span class="checkbox radio"></span>
                        <span class="description">

                        <div class="title">${institution.name}</div>
                        <div class="subtitle">${institution.description}</div>
                        </span>
                    </label>
                </div>
            </c:forEach>


            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <button type="button" class="btn next-step">Dalej</button>
            </div>
        </div>

        <!-- STEP 5 -->
        <div data-step="4">
            <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

            <div class="form-section form-section--columns">
                <div class="form-section--column">
                    <h4>Adres odbioru</h4>
                    <div class="form-group form-group--inline">
                        <label> Ulica <form:input path="street" type="text" name="street"/> </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label> Miasto <form:input path="city" type="text" name="city"/> </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label>
                            Kod pocztowy <form:input path="zipCode" type="text" name="postcode"/>
                        </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label>
                            Numer telefonu <form:input path="phone" type="phone" name="phone"/>
                        </label>
                    </div>
                </div>

                <div class="form-section--column">
                    <h4>Termin odbioru</h4>
                    <div class="form-group form-group--inline">
                        <label> Data <form:input path="pickUpDate" type="date" name="data"/> </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label> Godzina <form:input path="pickUpTime" type="time" name="time"/> </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label>
                            Uwagi dla kuriera
                            <form:textarea path="pickUpComment" name="more_info" rows="5"></form:textarea>
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <button type="submit" class="btn">Dalej</button>
            </div>
        </div>

        <!-- STEP 6 -->
<%--        <div data-step="5">--%>
<%--            <h3>Podsumowanie Twojej darowizny</h3>--%>

<%--            <div class="summary">--%>
<%--                <div class="form-section">--%>
<%--                    <h4>Oddajesz:</h4>--%>
<%--                    <ul>--%>
<%--                        <li>--%>
<%--                            <span class="icon icon-bag"></span>--%>
<%--                            <span class="summary--text"--%>
<%--                            >4 worki ubrań w dobrym stanie dla dzieci</span--%>
<%--                            >--%>
<%--                        </li>--%>

<%--                        <li>--%>
<%--                            <span class="icon icon-hand"></span>--%>
<%--                            <span class="summary--text"--%>
<%--                            >Dla fundacji "Mam marzenie" w Warszawie</span--%>
<%--                            >--%>
<%--                        </li>--%>
<%--                    </ul>--%>
<%--                </div>--%>

<%--                <div class="form-section form-section--columns">--%>
<%--                    <div class="form-section--column">--%>
<%--                        <h4>Adres odbioru:</h4>--%>
<%--                        <ul>--%>
<%--                            <li>${donation.street}</li>--%>
<%--                            <li>Warszawa</li>--%>
<%--                            <li>99-098</li>--%>
<%--                            <li>123 456 789</li>--%>
<%--                        </ul>--%>
<%--                    </div>--%>

<%--                    <div class="form-section--column">--%>
<%--                        <h4>Termin odbioru:</h4>--%>
<%--                        <ul>--%>
<%--                            <li>13/12/2018</li>--%>
<%--                            <li>15:40</li>--%>
<%--                            <li>Brak uwag</li>--%>
<%--                        </ul>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="form-group form-group--buttons">--%>
<%--                <button type="button" class="btn prev-step">Wstecz</button>--%>
<%--                <button type="submit" class="btn">Potwierdzam</button>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div>
    </form:form>
</section>


<jsp:include page="../header_footer/footer_main.jsp"/>
<jsp:include page="../header_footer/footer_js.jsp"/>
</body>
</html>
