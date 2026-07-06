package com.zubova.module1.serialization.practice.second;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CustomStudent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Setter
    private String lastname;
    @Setter
    private String name;
    @Setter
    private String surname;
    @Setter
    private transient String confirmationCode;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        String encryptedCode = encryptCode(this.confirmationCode);
        out.writeObject(encryptedCode);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        String encryptedCode = (String) in.readObject();
        this.confirmationCode = decryptCode(encryptedCode);
    }

    private String encryptCode(String confirmationCode) {
        if (confirmationCode == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(confirmationCode.getBytes(StandardCharsets.UTF_8));
    }

    private String decryptCode(String encryptedConfirmationCode) {
        if (encryptedConfirmationCode == null) {
            return null;
        }
        return new String(Base64.getDecoder().decode(encryptedConfirmationCode));
    }
}