package com.zubova.module1.method.javadoc;


/**
 * Class for showing JavaDoc example
 */
public class JavaDocExample {

    /**
     * Шифрует текст с использованием указанного ключа.
     * <p>
     * Алгоритм использует XOR-шифрование для каждого символа строки.
     *
     * @param text входной текст, который необходимо зашифровать
     *             (не должен быть null)
     * @param key  ключ для шифрования
     * @return зашифрованный текст в виде строки
     * @throws IllegalArgumentException если входной текст равен null
     *                                  или ключ равен 0
     * Пример использования:
     * <pre>
     *     String encrypted = encrypt("Hello, World!", 12345);
     *     System.out.println(encrypted);
     * </pre>
     * @see java.util.Base64 для возможного кодирования результата
     * <p>
     */
    public String encrypt(String text, int key) {
        if (text == null) {
            throw new IllegalArgumentException("Текст не может быть null");
        }
        if (key == 0) {
            throw new IllegalArgumentException("Ключ не может быть равен 0");
        }

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] ^= key; // XOR шифрование
        }
        return new String(chars);
    }

}
