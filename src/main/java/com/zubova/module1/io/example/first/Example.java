package com.zubova.module1.io.example.first;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Example {

    public void readAndWrite() throws IOException {
        // Пример работы с байтовым потоком
        try (FileInputStream fis = new FileInputStream("image.jpg");
             FileOutputStream fos = new FileOutputStream("copy.jpg")) {

            byte[] buffer = new byte[8192]; // Буфер 8KB
            int bytesRead;

            // Чтение в буфер и запись из буфера
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.flush(); // Сброс буфера
        }
    }

    public void readAndWriteSymbols() throws IOException {
        // Пример чтения и записи текстового файла с использованием символьных потоков
// try-with-resources автоматически закроет потоки после использования
        try (
                // Создаем буферизованный читатель
                // FileReader - базовый поток для чтения файла в указанной кодировке UTF-8
                // BufferedReader добавляет буферизацию для эффективного чтения
                BufferedReader reader = new BufferedReader(
                        new FileReader("text.txt", StandardCharsets.UTF_8));

                // Создаем буферизованный писатель
                // FileWriter - базовый поток для записи в файл в кодировке UTF-8
                // BufferedWriter добавляет буферизацию для эффективной записи
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("output.txt", StandardCharsets.UTF_8))) {

            // Переменная для хранения прочитанной строки
            String line;

            // Читаем файл построчно, пока не достигнем конца (null)
            // readLine() возвращает null, когда достигает конца файла
            while ((line = reader.readLine()) != null) {
                // Записываем прочитанную строку в выходной файл
                writer.write(line);
                // Добавляем перевод строки после каждой записанной строки
                writer.newLine();
            }
        }
    }

}
