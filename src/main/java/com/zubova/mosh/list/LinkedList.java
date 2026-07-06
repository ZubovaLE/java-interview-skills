package com.zubova.mosh.list;

import lombok.Getter;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    @Getter
    private int size;

    public void addFirst(int value) {
        Node node = new Node(value); //we want this node to point to our first
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    //let's start by implementing the addLast method
    // so, public void addLast
    // we give it an int
    // what we should do here
    // first step is to wrap this value inside a Node object
    public void addLast(int value) {
        //so we are creating a new Object like this
        Node node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            // we need to add this node after the last node
            last.next = node;
            // we are linking the last node to this new node
            // finally we should update last to point the new node
            last = node;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
        } else {
            Node forDelete = first;
            first = first.next;
            forDelete.next = null;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
        } else {
            last = getPreviousNode(last);
            if (last != null) {
                last.next = null;
            }
        }
        size--;
    }

    public void remove(int value) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
            size--;
        }
        if (value == first.value) {
            Node currentFirst = first;
            first = first.next;
            currentFirst.next = null;
            size--;
            return;
        }
        Node current = first;
        Node next = first.next;
        while (next != null) {
            if (next.value == value) {
                current.next = next.next;
                next.next = null;
                size--;
                break;
            }
            current = next;
            next = next.next;
        }
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        Node current = first;
        int index = 0;
        while (current != null) { //as long as the current is not null we are going to go forward
            if (current.value == value) {
                return index;
            }
            current = current.next; // otherwise we gonna to set current to the next node
            index++;
        }
        return -1;
    }

    public int getByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        Node current = first;
        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                return current.value;
            }
            current = current.next;
            currentIndex++;
        }
        return -1;
    }

    public int[] toArray() {
        int[] array = new int[size];
        Node current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        if (first == last) {
            return;
        }
        Node current = first;
        Node newNext = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = newNext;
            newNext = current;
            current = next;
        }
        Node currentFirst = first;
        first = last;
        last = currentFirst;
    }

    public void reverse2() {
        if (isEmpty()) {
            return;
        }

        Node previous = first;
        Node current = first.next;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    public int findKth(int k) {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        Node a = first;
        Node b = first;
        for (int i = 1; i < k; i++) {
            b = b.next;
            if (b == null) {
                throw new IllegalArgumentException();
            }
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public int findKthFromTheEnd(int k) {
        if (size < k) {
            return -1;
        }
        int targetIndex = size - k;
        Node current = first;
        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == targetIndex) {
                return current.value;
            }
            current = current.next;
            currentIndex++;
        }
        return -1;
    }

//    public void printMiddle() {
//        if (isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//        int step = 1;
//        Node current = first;
//        Node nodeAfterStep = first.next;
//        while (current != null) {
//            step++;
//            if (nodeAfterStep == last) {
//                System.out.println(current.value);
//                System.out.println(current.next.value);
//                return;
//            }
//            if (nodeAfterStep == null) {
//                System.out.println(current.value);
//                return;
//            }
//            current = current.next;
//            for (int i = 0; i < step; i++) {
//                nodeAfterStep = nodeAfterStep.next;
//            }
//        }
//    }

    // we assume that we don't know the size
    public void printMiddle2() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        Node a = first;
        Node b = first;
        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }
        if (b == last) {
            System.out.println(a.value);
        } else {
            System.out.println(a.value + ", " + a.next.value);
        }

    }

    public boolean hasLoop() {
        return false;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private Node getPreviousNode(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

}
