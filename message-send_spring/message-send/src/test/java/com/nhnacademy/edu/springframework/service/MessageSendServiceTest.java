package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.User;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class MessageSendServiceTest {

    @Test
    void testDoSendMessage() {
        User user = new User("email", "010-");
        String message = "message!";
        MessageSender messageSender = mock(MessageSender.class);

        when(messageSender.sendMessage(user, message)).thenReturn(false);
        MessageSendService messageSendService = new MessageSendService();

        ReflectionTestUtils.setField(messageSendService, "messageSender", messageSender);

        boolean actual = messageSendService.doSendMessage(user, message);

        assertThat(actual).isFalse();
    }

}