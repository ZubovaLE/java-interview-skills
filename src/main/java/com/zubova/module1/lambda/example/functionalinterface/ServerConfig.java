package com.zubova.module1.lambda.example.functionalinterface;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServerConfig {

    private String id;
    private int port;
    private int threads;

}
