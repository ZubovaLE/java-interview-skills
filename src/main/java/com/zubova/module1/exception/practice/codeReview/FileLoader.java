package com.zubova.module1.exception.practice.codeReview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class FileLoader {

    private static final Logger LOGGER = Logger.getLogger(FileLoader.class.getName());

    public String loadFileContent(String path) throws FileNotFoundException, IOException {
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader(path);
            bufferedReader = new BufferedReader(reader);
            StringBuilder content = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }

            return content.toString();
        } catch (FileNotFoundException e) {
            LOGGER.severe("Can't find the file: " + path);
            throw e;
        } catch (IOException e) {
            LOGGER.severe("Error while working with file: " + path);
            throw e;
        } catch (Exception e) {
            LOGGER.severe("Error while working " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        } finally {
            closeReader(reader);
            closeBufferedReader(bufferedReader);
        }
    }

    private void closeReader(FileReader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                LOGGER.severe("Error while closing reader");
            }
        }
    }

    private void closeBufferedReader(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                LOGGER.severe("Error while closing bufferedReader");
            }
        }
    }

}