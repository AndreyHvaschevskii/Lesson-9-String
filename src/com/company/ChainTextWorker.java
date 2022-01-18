package com.company;

import java.util.Scanner;

public class ChainTextWorker {

    public ChainTextWorker(TextProcessable[] processables) {

    }

    public String processText(String text) {
    String trim = text.trim();
    System.out.println("Do you want to reverse your future text? Enter Yes or No");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        if (a.equalsIgnoreCase("yes")) {
            new ReverseInformation();
        }
        return trim;
    }
}
