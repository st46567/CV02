package net.houzvicka.inpia.cv02_spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EmailSender implements MessageSender{

    @Override
    public void sendMessage(String msq, String recipient) {
        System.out.println("Sending email " + msq + " to " + recipient);
    }

    @PostConstruct
    public void loadCache(){
        System.out.println("Loading cache");
    }

}
