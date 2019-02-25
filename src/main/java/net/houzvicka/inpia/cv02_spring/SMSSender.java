package net.houzvicka.inpia.cv02_spring;

import org.springframework.stereotype.Component;

@Component
public class SMSSender implements MessageSender {

    @Override
    public void sendMessage(String msq, String recipient) {
        System.out.println("Sending SMS " + msq + " to " + recipient);
    }

}
