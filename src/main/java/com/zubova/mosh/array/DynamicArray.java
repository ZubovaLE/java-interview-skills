package com.zubova.mosh.array;

import java.util.Arrays;

public class DynamicArray {

    private int[] items;

    private int itemsCounter;

    public DynamicArray(int length) {
        if (length < 0) {
            throw new IllegalStateException("Length cannot be negative");
        }
        this.items = new int[length];
    }

    public void print() {
        for (int i = 0; i < itemsCounter; i++) {
            System.out.println(items[i]);
        }
    }

    public void insert(int item) {
        increaseLengthIfNeeded();
        items[itemsCounter++] = item;
    }

    public void insertAt(int index, int item) {
        increaseLengthIfNeeded();
        System.arraycopy(items, index, items, index + 1, itemsCounter - index);
        items[index] = item;
        itemsCounter++;
    }

    public void removeAt(int index) {
        validateIndex(index);
        if (index == itemsCounter - 1) {
            items[--itemsCounter] = 0;
            return;
        }
        System.arraycopy(items, index + 1, items, index, itemsCounter - index - 1);
        items[itemsCounter--] = 0;
    }

    public int indexOf(int item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    // the runtime complexity is O(n) because the efficiency increases linearly with the number of input items
    public int max() {
        if (itemsCounter == 0) {
            return -1;
        }
        int max = items[0];
        for (int i = 1; i < itemsCounter; i++) {
            if (items[i] > max) {
                max = items[i];
            }
        }
        return max;
    }

    public DynamicArray intersect(DynamicArray anotherArray) {
        DynamicArray result = new DynamicArray(Math.min(itemsCounter, anotherArray.itemsCounter));
        for (int i = 0; i < itemsCounter; i++) {
            outer:
            for (int j = 0; j < anotherArray.itemsCounter; j++) {
                if (items[i] == anotherArray.items[j]) {
                    for (int k = 0; k < result.itemsCounter; k++) {
                        if (result.items[k] == items[i]) {
                            break outer;
                        }
                    }
                    result.insert(items[i]);
                    break;
                }
            }
        }
        return result;
    }

    public void reverse() {
        for (int i = 0; i < itemsCounter / 2; i++) {
            int temp = items[i];
            items[i] = items[itemsCounter - i - 1];
            items[itemsCounter - i - 1] = temp;
        }
    }

    public int get(int index) {
        validateIndex(index);
        return items[index];
    }

    public int size() {
        return itemsCounter;
    }

    private void increaseLengthIfNeeded() {
        if (items.length == itemsCounter) {
            items = Arrays.copyOf(items, itemsCounter * 3 / 2 + 1);
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= itemsCounter) {
            throw new IllegalArgumentException("Invalid index");
        }
    }

}