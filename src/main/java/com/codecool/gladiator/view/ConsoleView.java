package com.codecool.gladiator.view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Basic console view implementation
 */
public class ConsoleView implements Viewable {

    private Scanner scanner;

    @Override
    public void display(String text) {
        // Todo
        System.out.println(text);
    }

    @Override
    public int getNumberBetween(int min, int max) {
        scanner = new Scanner(System.in);
        int number = 0;

        do {
            try {
                number = scanner.nextInt();
                validateNumber(min, max, number);
            } catch (InputMismatchException e) {
                System.out.println(String.format("Please input a number between %s-%s", min, max));
            }
            scanner.nextLine();
        } while (number < min || number > max);

        return number;
    }

    private void validateNumber(int min, int max, int number) {
        if (number < min || number > max) {
            System.out.println(String.format("Wrong number! Choose a number between %d-%d", min, max));
        } else {
            System.out.println(String.format("You selected %s stage(s)", number));
        }
    }

}
