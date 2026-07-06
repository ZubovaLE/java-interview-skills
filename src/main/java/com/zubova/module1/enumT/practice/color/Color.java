package com.zubova.module1.enumT.practice.color;

public enum Color {
    RED(255, 0, 0),
    GREEN(0, 128, 0),
    BLUE(0, 0, 255),
    YELLOW(255, 255, 0);

    private final int r;
    private final int g;
    private final int b;

    Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() { return r; }
    public int getG() { return g; }
    public int getB() { return b; }

    /**
     * Определяет, является ли цвет "тёплым".
     * Упрощенная логика: тёплые цвета имеют больше красного/жёлтого, чем синего.
     * @return true, если цвет тёплый.
     */
    public boolean isWarm() {
        return this.r > this.b;
    }

    /**
     * Смешивает текущий цвет с другим.
     * @param other Другой цвет для смешивания.
     * @return новый массив int 3 , представляющий RGB результат.
     */
    public int[] mixWith(Color other) {
        int mixedR = (this.r + other.r) / 2;
        int mixedG = (this.g + other.g) / 2;
        int mixedB = (this.b + other.b) / 2;
        return new int[]{mixedR, mixedG, mixedB};
    }
}