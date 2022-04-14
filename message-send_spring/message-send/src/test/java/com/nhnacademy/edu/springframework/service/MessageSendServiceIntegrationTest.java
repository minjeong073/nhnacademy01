package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.User;
import com.nhnacademy.edu.springframework.config.MainConfiguration;
import com.nhnacademy.edu.springframework.config.SenderConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MainConfiguration.class, SenderConfig.class})
class MessageSendServiceIntegrationTest {

    @Autowired
    @InjectMocks
    MessageSendService messageSendService;

    @Mock
    MessageSender messageSender;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(messageSender.sendMessage(any(), any())).thenReturn(false);
    }

    @Test
    void test() {

        User user = new User( "email", "010-");
        String message = "message!";
        boolean actual = messageSendService.doSendMessage(user, message);

        assertThat(actual).isFalse();
    }


}