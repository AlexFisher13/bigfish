<!-- Подключаем специальные спринговские теги для вьюшек -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--Создаем форму с использованием тегов от spring, указываем метод формы (post или get),
атрибут модели (нашу модельс которой работаем) и что произойдет при подтверждении (сабмите) формы
(после нажатия на кнопку в нашем случае).--%>

<html>

<head>
    <title>Index Page</title>
</head>

<body>
<spring:form method="post"  modelAttribute="userJSP" action="check-user"> <%--Спринг-форма, post - будет отправлять данные, в модель userJSP, и послее подтверждения формы отправит нас по запросу check-user--%>

    Name: <spring:input path="name"/>   <br/>  <%--(path="" - указывает путь, используемый в modelAttribute=''. в нашем случае User.name)--%>
    Password: <spring:input path="password"/>   <br/>
    <spring:button>Next Page</spring:button>

</spring:form>

<!--<form action=""></form>-->

</body>

</html>
