package messenger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {
    @Test
    void checkPassword_returnsTrue_whenPasswordsMatch() {
        Message message = new Message("Hello World", "foobar");
        assertTrue(message.checkPassword("foobar"));
    }

    @Test
    void checkPassword_returnsFalse_whenPasswordsDontMatch() {
        Message message = new Message("Hello World", "right");
        assertFalse(message.checkPassword("wrong"));
    }

    @Test
    void serialize_convertsMessageIntoString() {
        Message message = new Message("Hello World", "foobar");
        assertEquals("foobar;Hello World", message.serialize());
    }

    @Test
    void deserialize_convertsStringIntoMessage_whenStringIsValid() throws InvalidMessageException {
        Message message = Message.deserialize("foobar;Hello World");

        assertEquals("Hello World", message.toString());
        assertTrue(message.checkPassword("foobar"));
    }

    @Test
    void deserialize_throwsException_whenStringIsInvalid() {
        assertThrows(InvalidMessageException.class, () -> Message.deserialize("foobarHello"));
    }
}