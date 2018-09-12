package com.codecool.thehistory;

import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] parts = text.split("\\s*(\\s|,)\\s*");
        wordsArray = Arrays.copyOf(wordsArray, parts.length);
        System.arraycopy(parts, 0, wordsArray, 0, parts.length);
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        int counter = 0;
        for (String word : wordsArray) {
            if (word.equals(wordToBeRemoved)){
                counter++;
            }
        }
        String[] arrayWithoutRemovedWord = new String[wordsArray.length-counter];
        int indexCounter = 0;
        for (String word : wordsArray) {
            if (word.equals(wordToBeRemoved)) {
                continue;
            } else {
                arrayWithoutRemovedWord[indexCounter] = word;
                indexCounter++;
            }
        }
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(from)) {
                wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        if (fromWords.length == toWords.length) {
            if (fromWords.length == wordsArray.length) {
                wordsArray = toWords;
            } else {
                String[] check = new String[fromWords.length];
                for (int i = 0; i < wordsArray.length; i++) {
                    if (wordsArray[i].equals(fromWords[0])) {
                        for (int j = 0; j < check.length; j++) {
                            check[j] = wordsArray[i + j];
                        }
                        if (Arrays.equals(fromWords, check)) {
                            for (int k = 0; k < check.length; k++) {
                                wordsArray[i + k] = toWords[k];
                            }
                        }
                    }
                }
            }
        } // else {
//            if (fromWords.length < toWords.length) {
//                int difference = toWords.length - fromWords.length;
//                wordsArray = Arrays.copyOf(wordsArray, wordsArray.length + difference);
//                String[] newWordsArray = new String[wordsArray.length];
//                String[] check = new String[fromWords.length];
//                for (int i = 0; i<wordsArray.length; i++) {
//                    if (wordsArray[i].equals(fromWords[0])) {
//                        for (int j = 0; j < check.length; j++) {
//                            check[j] = wordsArray[i + j];
//                        }
//                        if (Arrays.equals(fromWords, check)) {
//                            System.arraycopy();
//                        }
//                    }
//                }
//            }
//        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
