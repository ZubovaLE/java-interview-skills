package com.zubova.module1.interfaces.practice.file;

import java.io.IOException;

interface Writable {
    void write(String data) throws IOException;
}
