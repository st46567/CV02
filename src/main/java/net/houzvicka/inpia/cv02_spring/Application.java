package net.houzvicka.inpia.cv02_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Application {

    @Autowired
    List<MessageSender> sendersList;

    public Application(){

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("net.houzvicka.inpia.cv02_spring");
        Application app = context.getBean(Application.class);
        app.processMessages("Hello", "Jan");
    }

    public void processMessages(String msg, String recipient){
        if(msg == null){
            throw new IllegalArgumentException("msg cannot be null");
        }

        for (MessageSender messageSender : sendersList) {
            messageSender.sendMessage(msg, recipient);
        }
    }

}
