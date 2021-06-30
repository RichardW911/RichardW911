package org.example;

import org.example.controller.LoginController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {


        ApplicationContext context = new
                ClassPathXmlApplicationContext("beans.xml");

        LoginController loginController =
                (LoginController) context.getBean("loginController");
        System.out.println(loginController);



       /* LoginController loginController1 = context.getBean(LoginController.class);
        System.out.println(loginController1);*/

        ((ClassPathXmlApplicationContext)context).close();
    }

    public final int m() {

        try {

        }catch (Exception e) {

        }
        return 0;
    }
}
