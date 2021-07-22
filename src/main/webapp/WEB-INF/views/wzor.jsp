<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="student">
    <label>First name:
        <form:input path="firstName"/>
    </label><br/>
    <label>Last name:
        <form:input path="lastName"/>
    </label><br/>
    <label>Gender:
        <form:radiobutton path="gender" value="Male"/>
        <form:radiobutton path="gender" value="Female"/>
    </label><br/>
    <label>Coutry:
        <form:select path="country" items="${countries}"/>
    </label><br/>
    <label>Notes:
        <form:textarea path="notes"/>
    </label><br/>
    <label>Mailing list:
        <form:checkbox path="mailingList"/>
    </label><br/>
    <label>Programming skills:
        <form:select path="programmingSkills" multiple="true" items="${programmingSkills}"/>
    </label><br/>
    <label>Hobbies:
        <form:checkboxes path="hobbies" items="${hobbies}"/>
    </label><br/>
    <form:button type="submit">Dodaj</form:button>
</form:form>
</body>
</html>
