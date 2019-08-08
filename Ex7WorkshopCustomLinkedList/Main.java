package Ex7WorkshopCustomLinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DoublyLinkedList list = new DoublyLinkedList();

        list.addLast(16);
        list.addLast(42);
        list.addLast(87);

        list.forEach(System.out::println);
    }
}
