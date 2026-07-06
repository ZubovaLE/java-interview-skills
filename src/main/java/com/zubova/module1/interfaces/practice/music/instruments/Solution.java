package com.zubova.module1.interfaces.practice.music.instruments;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        MusicalInstrument[] musicalInstruments = {new Piano(), new Guitar(), new Drum()};
        Arrays.stream(musicalInstruments).forEach(MusicalInstrument::play);
    }
}