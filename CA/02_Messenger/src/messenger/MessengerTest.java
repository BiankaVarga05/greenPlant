package messenger;

import java.io.IOException;
import java.util.zip.DataFormatException;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// End-to-end tests
class MessengerTest {
    Messenger messenger;

    @BeforeEach
    void setUp() throws IOException, InvalidMessageException {
        messenger = new Messenger();
    }

    @Test
    void receivesMessageUsingPassword() throws IOException {
        String message = "Hello World";
        String password = "foobar";

        messenger.sendMessage(message, password);
        messenger.sendMessage("Something Else", password);
        String receivedMessage = messenger.receiveMessage(password);

        assertEquals(message, receivedMessage);
    }

    @Test
    void doesntReceiveMessageUsingWrongPassword() throws IOException {
        String message = "Hello World";
        String password = "foobar";

        messenger.sendMessage(message, password);
        String receivedMessage = messenger.receiveMessage("wrongPwd");

        assertNull(receivedMessage);
    }
}