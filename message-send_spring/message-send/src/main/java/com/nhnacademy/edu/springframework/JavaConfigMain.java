package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigMain {
    private static final Log log = LogFactory.getLog(JavaConfigMain.class);

    public static void main(String[] args) {

        log.warn("JavaConfigMain STARTING !");

        User user = new User("김민정", "email", "bbbb-bbbb");
        String message = ":)";

        try (AnnotationConfigApplicationContext context
                     = new AnnotationConfigApplicationContext
                ("com.nhnacademy.edu.springframework")) {
            //context.getBean("messageSendService");
            context.getBean("messageSendService", MessageSendService.class)
                    .doSendMessage(user, message);
        }
    }
}
