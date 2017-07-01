package com.fish.controller;

import com.fish.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {
    /*Попадаем сюда на старте приложения*/
    /* Аннотация @Controller служит для сообщения Spring'у о том, что данный класс является bean'ом
    и его необходимо подгрузить при старте приложения.
    Аннотацией @RequestMapping(value = "/") сообщаем, что данный контроллер будет обрабатывать запрос, URI которого "/" */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        /*Специальный класс ModelAndView, который агрегирует все параметры модели и имя отображения
        * подробнее можно почитать тут http://www.seostella.com/ru/article/2012/04/23/spring-3-i-controller-chast-1.html*/
        modelAndView.addObject("userJSP", new User()); //создаем нового юзера, и даем имя этому бину userJSP
        modelAndView.setViewName("index"); //направляемся на страницу index
        return modelAndView;
    }

    /*как только на index.jsp подтвердится форма
    <spring:form method="post"  modelAttribute="userJSP" action="check-user">,
    то попадем вот сюда
     */
    @RequestMapping(value = "/check-user")
    public ModelAndView checkUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();

        //имя представления, куда нужно будет перейти
        modelAndView.setViewName("secondPage");

        //записываем в атрибут userJSP (используется на странице *.jsp объект user
        modelAndView.addObject("userJSP", user);

        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
    }

    @RequestMapping(value = "/simple")
    public String SimpleController() {
        return "simple";
    }

}
