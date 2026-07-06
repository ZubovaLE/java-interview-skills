package com.zubova.module1.io.example.second;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class Example {

    public void readAndWrite() throws IOException {
// Чтение сжатого текстового файла с буферизацией
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new GZIPInputStream(
                                new FileInputStream("text.gz")
                        ),
                        StandardCharsets.UTF_8
                )
        )) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Обработка текстовых данных
            }
        }
    }

    public void textFileReadAndWrite() throws IOException {
        // Пример многослойного чтения текстового файла с указанной кодировкой
        try (
                // FileInputStream - низкоуровневый поток для чтения байтов из файла
                // Самый базовый уровень, просто читает байты
                FileInputStream fileStream = new FileInputStream("text.txt");

                // InputStreamReader - преобразует байты в символы используя указанную кодировку
                // StandardCharsets.UTF_8 гарантирует правильное чтение Unicode-символов
                InputStreamReader inputReader = new InputStreamReader(
                        fileStream,
                        StandardCharsets.UTF_8
                );

                // BufferedReader добавляет буферизацию и удобные методы для чтения текста
                // например, readLine() для чтения целых строк
                BufferedReader bufferedReader = new BufferedReader(inputReader)
        ) {
            String line;
            // readLine() читает строку целиком до символа переноса строки
            // возвращает null при достижении конца файла
            while ((line = bufferedReader.readLine()) != null) {
                // Обработка прочитанной строки
                // Здесь line уже содержит текст в правильной кодировке
            }
        }

    }

}
