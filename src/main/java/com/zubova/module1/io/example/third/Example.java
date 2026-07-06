package com.zubova.module1.io.example.third;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Example {
    public void binaryReadAndWrite() throws IOException {
        // Чтение бинарного файла (изображения) в байтовый массив
// Внешний try-with-resources для ByteArrayOutputStream
        try (
                // ByteArrayOutputStream - специальный поток для записи в байтовый массив
                // Автоматически расширяется при необходимости
                ByteArrayOutputStream baos = new ByteArrayOutputStream()
        ) {
            // Вложенный try-with-resources для чтения файла
            try (
                    // FileInputStream - базовый поток для чтения бинарного файла
                    InputStream is = new FileInputStream("image.jpg")
            ) {
                // Создаем буфер для порционного чтения
                // 4096 байт - оптимальный размер для большинства случаев
                byte[] buffer = new byte[4096];

                // Переменная для хранения количества прочитанных байт
                int bytesRead;

                // Читаем файл порциями, пока не достигнем конца
                // read возвращает -1 при достижении конца файла
                while ((bytesRead = is.read(buffer)) != -1) {
                    // Записываем прочитанные байты в ByteArrayOutputStream
                    // buffer - источник данных
                    // 0 - начальная позиция в буфере
                    // bytesRead - количество байт для записи
                    baos.write(buffer, 0, bytesRead);
                }
            }

            // Преобразуем все накопленные данные в байтовый массив
            byte[] imageData = baos.toByteArray();

            // Здесь можно выполнять дальнейшую обработку изображения
            // Например, передача по сети, сохранение в базу данных и т.д.
        }
    }
}
