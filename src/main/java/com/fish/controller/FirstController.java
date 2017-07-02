package com.fish.controller;

import com.fish.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //Аннотация указывает что это бин, и его нужно подгружать при старте приложения. HTTP запросы обрабатываются контроллером.
public class FirstController {
    //Аннотацией @RequestMapping(value = "/") сообщаем, что данный контроллер будет обрабатывать запрос, URI которого "/" */
    @RequestMapping(value = "/", method = RequestMethod.GET) //RequestMethod - метод доступа. GET - запрашивает ресурсы. POST - отправляет данные на заданный ресурс.
    public ModelAndView main() {    //Попадаем сюда на старте приложения
        ModelAndView modelAndView = new ModelAndView(); //ModelAndView - cпециальный класс, который агрегирует все параметры модели и имя отображения
        // подробнее можно почитать тут http://www.seostella.com/ru/article/2012/04/23/spring-3-i-controller-chast-1.html
        //Теперь нам необходимо записать в модель атрибут, а так же объект, который будет соответствовать этому атрибуту.
        modelAndView.addObject("userJSP", new User()); //создаем нового юзера, и даем имя этому бину userJSP
        //Здесь используется имя userJSP, который ссылается на модель POJO класса User.class.
        //Здесь специально разделил названия атрибута и модели, т.к. во многих примерах всегда используется model=user, object=user, name=user и т.п.. А потом нельзя понять куда что пишется и на что ссылается..*/
        modelAndView.setViewName("index"); //Тут мы устанавливаем имя представления - index.
        return modelAndView; //После чего мы отправляемся в dispatcher-servlet к org.springframework.web.servlet.view.InternalResourceViewResolver
    }

    //Как только на index.jsp подтвердится форма <spring:form method="post"  modelAttribute="userJSP" action="check-user">, то попадем вот сюда
    @RequestMapping(value = "/check-user") //Контролле обрабатывает запрос /check-user и потом нас будет отправлять на страницу "secondPage"
    public ModelAndView checkUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView(); //создаем новую модель
        modelAndView.setViewName("secondPage");//устанавливаем имя представления куда будем переходить
        modelAndView.addObject("userJSP", user); //записываем в атрибут модель с который мы работаем - userJSP (используется на странице *.jsp объект user)
        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
    }

    @RequestMapping(value = "/simple")
    public String SimpleController() {
        return "simple";
    }

}
