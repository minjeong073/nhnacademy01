package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.annotation.Sms;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import com.nhnacademy.edu.springframework.service.MessageSender;
import com.nhnacademy.edu.springframework.service.SmsMessageSender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.nhnacademy.edu.springframework")
@ImportResource("classpath:/beans.xml")
@EnableAspectJAutoProxy
public class MainConfiguration {

    @Bean
    public MessageSender smsMessageSender() {
        return new SmsMessageSender();
    }

//    @Conditional(SmsMessageSenderCheckCondition.class)
    @Bean
    public MessageSendService messageSendService(@Qualifier("doorayMessageSender") MessageSender messageSender) {
        return new MessageSendService(messageSender);
    }


}
