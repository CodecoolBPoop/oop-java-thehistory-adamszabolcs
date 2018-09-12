package com.codecool.thehistory;

import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList = new LinkedList<>(Arrays.asList(text.split("\\s*(\\s|,)\\s*")));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        Iterator<String> iterator = wordsLinkedList.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals(wordToBeRemoved)) {
                iterator.remove();
            }
        }
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        Iterator<String> iterator = wordsLinkedList.iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals(from)) {
                wordsLinkedList.set(counter, to);
            }
            counter++;
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
