package net.houzvicka.inpia.cv02_spring;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;


public class ApplicationTest {

    @Test
    public void processMessagesTest() {
        Application app = new Application();
        app.sendersList = new ArrayList<>();
        app.sendersList.add(new EmailSender());

        try {
            app.processMessages(null, "Jan");
        }catch(IllegalArgumentException ex){
            // OK
        }
    }

    @Test
    public void ProcessMessagesMsgNonEmptyTest(){
        Application app = new Application();
        EmailSenderMock esm = new EmailSenderMock();

        app.sendersList = new ArrayList<>();
        app.sendersList.add(new EmailSender());

        app.processMessages("Hello", "Jan");
        assertEquals(0, esm.callCount);
    }

    private class EmailSenderMock extends EmailSender{
        int callCount = 0;

        @Override
        public void sendMessage(String msq, String recipient) {
            callCount++;
            super.sendMessage(msq, recipient);
        }
    }
}
