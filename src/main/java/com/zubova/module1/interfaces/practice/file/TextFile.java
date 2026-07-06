package com.zubova.module1.interfaces.practice.file;


import java.io.*;
import java.util.logging.Logger;

public class TextFile implements Readable, Writable, Closeable {

    private static final Logger LOGGER = Logger.getLogger(TextFile.class.getName());
    private final String filePath;
    private final BufferedWriter writer;
    private final BufferedReader reader;
    private boolean isClosed = false;

    public TextFile(String filePath) throws IOException {
        this.filePath = filePath;
        this.writer = new BufferedWriter(new FileWriter(filePath, true));
        this.reader = new BufferedReader(new FileReader(filePath));
        LOGGER.info("Файл " + filePath + " открыт.");
    }

    @Override
    public String read() throws IOException {
        checkIfClosed();
        LOGGER.info("Чтение из файла " + filePath);
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append(System.lineSeparator());
        }
        return content.toString();
    }

    @Override
    public void write(String data) throws IOException {
        checkIfClosed();
        LOGGER.info("Запись в файл " + filePath);
        writer.write(data);
        writer.newLine();
        writer.flush();
    }

    @Override
    public void close() throws IOException {
        if (!isClosed) {
            try {
                writer.close();
                reader.close();
            } finally {
                isClosed = true;
                LOGGER.info("Файл " + filePath + " закрыт.");
            }
        }
    }

    private void checkIfClosed() throws IOException {
        if (isClosed) {
            throw new IOException("Файл уже закрыт.");
        }
    }

}