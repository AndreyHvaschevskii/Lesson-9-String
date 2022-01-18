package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextWorker {

    static boolean isPalindrome(String word) {
        String trim = word.trim();
        StringBuilder str = new StringBuilder(trim).reverse();
        System.out.println(trim + " " + str);
        return trim.equalsIgnoreCase((str.toString()));
    }

    static String getSequance(String text, char symbolStart, char symbolEnd) {
        String a = text.trim();
        int first = a.indexOf(symbolStart);
        int last = a.lastIndexOf(symbolEnd);
        if (first < 0 || last < 0) {
            return null;
        }
        return (a.substring(first, last + 1));
    }

    static String createSequance(int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();
        if (start >= end) {
            return null;
        } else {
            for (int i = start; i <= end; i++) {
                stringBuilder.append(i);
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    static String insertAll(String initialText, String[] toInsert, int[] indexes) {
        String trim = initialText.trim();
        StringBuffer stringBuffer = new StringBuffer(trim);
        for (int i = 0; i < toInsert.length; i++) {
            stringBuffer.insert(indexes[i], toInsert[i]);
        }
        return stringBuffer.toString();
    }

    static String insertAll1(String initialText, String[] toInsert, int[] indexes) {
        String trim = initialText.trim();
        StringBuffer stringBuffer = new StringBuffer(trim);
        Arrays.sort(indexes);
        stringBuffer.insert(indexes[0], toInsert[0]);
        for (int i = 1; i < indexes.length; i++) {
            indexes[i] = indexes[i] + toInsert[i - 1].length();
            stringBuffer.insert(indexes[i], toInsert[i]);
        }
        return stringBuffer.toString();
    }

    static String[] findAllMails(String text) {
        String trim = text.trim();
        int a = 0;
        String[] str = new String[trim.length()];
        String regex = "\\w+@\\w+\\.\\w+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(trim);
        for (int i = 0; i < trim.length(); i++) {
            if (matcher.find()) {
                str[i] = trim.substring(matcher.start(), matcher.end());
                a++;
            }
        }
        String[] email = new String[a];
        for (int i = 0; i < email.length; i++) {
            email[i] = str[i];
        }
        System.out.println(Arrays.toString(email));
        return str;
    }

    static String indexes(String text, char a) {
        String trim = text.trim();
        List<Integer> ar = new ArrayList<>();
        Pattern pattern = Pattern.compile(String.valueOf(a));
        Matcher matcher = pattern.matcher(trim);
        while (matcher.find()) {
            ar.add(matcher.start());
        }
        return String.valueOf(ar);
    }
}
