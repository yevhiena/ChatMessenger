import client.ChatMessengerAppl;
import org.xml.sax.SAXException;
import server.ChatMessengerServer;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Run {
    public static void main(final String ... args) throws InterruptedException {

        Thread one = new Thread(() -> {
            try {
                ChatMessengerServer.main(args);
            } catch (IOException | ParserConfigurationException | SAXException e) {
                e.printStackTrace();
            }
        });
        Thread two = new Thread(() -> ChatMessengerAppl.main(args));

        one.start();
        two.start();

        one.join();
        two.join();
    }
}
