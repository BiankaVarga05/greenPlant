package messenger;

class EncryptionService {
    public String encrypt(String text) {
        String ciphertext = "";

        for (int i = 0; i < text.length(); i += 4) {
            ciphertext += text.charAt(i);
        }
        for (int i = 1; i < text.length(); i += 2) {
            ciphertext += text.charAt(i);
        }
        for (int i = 2; i < text.length(); i += 4) {
            ciphertext += text.charAt(i);
        }

        return ciphertext;
    }

    public String decrypt(String ciphertext) {
        char[] text = new char[ciphertext.length()];
        int position = 0;

        for (int i = 0; i < text.length; i += 4) {
            text[i] = ciphertext.charAt(position);
            position++;
        }
        for (int i = 1; i < text.length; i += 2) {
            text[i] = ciphertext.charAt(position);
            position++;
        }
        for (int i = 2; i < text.length; i += 4) {
            text[i] = ciphertext.charAt(position);
            position++;
        }

        return new String(text);
    }
}
