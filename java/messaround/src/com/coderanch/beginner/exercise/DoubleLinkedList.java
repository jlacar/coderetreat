package com.coderanch.beginner.exercise;

public class DoubleLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public void append(E data) {
        Node<E> n = new Node<>(data);
        if (head == null) {
            head = tail = n;
        } else {
            n.prev = tail;
            tail = tail.next = n;
        }
        size++;
    }

    public boolean delete(E data) {
        int oldSize = size;
        Node<E> current = head;
        while (current != null) {
            if (current.data == data) {
                if (current != head && current != tail){
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                if (current == head) {
                    head = head.next;
                }
                if (current == tail) {
                    tail = tail.prev;
                }
                size--;
            }
            current = current.next;
        }
        return oldSize > size;
    }

    public E first() {
        return (head != null) ? head.data : null;
    }

    public E last() {
        return (tail != null) ? tail.data : null;
    }

    private class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.data = data;
        }
    }

    public int size() {
        return size;
    }

}
