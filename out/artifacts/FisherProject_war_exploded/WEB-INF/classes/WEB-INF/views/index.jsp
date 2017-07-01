<!-- Подключаем специальные спринговские теги для вьюшек -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--Создаем форму с использованием тегов от spring (смотрите начало страницы), указываем метод формы (post или get),
атрибут модели (используется в контроллере из описания выше) и что произойдет при подтверждении (сабмите) формы
(после нажатия на кнопку в нашем случае).--%>

<html>

<head>
    <title>Index Page</title>
</head>

<body>
<spring:form method="post"  modelAttribute="userJSP" action="check-user">

    Name: <spring:input path="name"/> (path="" - указывает путь, используемый в modelAttribute=''. в нашем случае User.name)  <br/>
    Password: <spring:input path="password"/>   <br/>
    <spring:button>Next Page</spring:button>

</spring:form>

<form action=""></form>

</body>

</html>
