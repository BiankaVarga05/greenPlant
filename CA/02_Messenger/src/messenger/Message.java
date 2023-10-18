package messenger;

class Message {
    private String text;
    private String password;

    private static String separator = ";";

    public Message(String text, String password) {
        this.text = text;
        this.password = password;
    }

    @Override
    public String toString() {
        return text;
    }

    public String serialize() {
        return password + separator + text;
    }

    public static Message deserialize(String line) throws InvalidMessageException {
        String[] parts = line.split(separator);
        if (parts.length < 2) {
            throw new InvalidMessageException();
        }
        return new Message(parts[1], parts[0]);
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
