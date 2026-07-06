package com.zubova.module1.finalTopic;

public class ShoppingCart {

    private final int[] items;

    public ShoppingCart(int[] items) {
        this.items = items;
    }

    public void updateItemAtIndex(int item, int index) {
        if (index < 0 || index >= items.length) {
            throw new IllegalArgumentException("Index " + index + " is out of bounds for length " + items.length);
        }
        items[index] = item;
    }

}
