package messenger;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Messenger {
    private List<Message> messages;
    private StorageService storageService;
    private EncryptionService encryptionService;

    public Messenger() throws IOException, InvalidMessageException {
        messages = new ArrayList<>();
        storageService = new StorageService(Paths.get("messages.txt"));
        encryptionService = new EncryptionService();

        for (String line : storageService.readAll()) {
            messages.add(Message.deserialize(encryptionService.decrypt(line)));
        }
    }

    public void sendMessage(String text, String password) throws IOException {
        Message message = new Message(text, password);
        messages.add(message);
        saveToStorage();
    }

    public String receiveMessage(String password) {
        for (Message message : messages) {
            if (message.checkPassword(password)) {
                return message.toString();
            }
        }

        return null;
    }

    private void saveToStorage() throws IOException {
        List<String> lines = new ArrayList<>();
        for (Message message : messages) {
            lines.add(encryptionService.encrypt(message.serialize()));
        }
        storageService.writeAll(lines);
    }
}
