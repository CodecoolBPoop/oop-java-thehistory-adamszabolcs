package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        wordsArrayList = new ArrayList<>(Arrays.asList(text.split("\\s*(\\s|,)\\s*")));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        List<String> remove = new ArrayList<>(Arrays.asList(wordToBeRemoved));
        wordsArrayList.removeAll(remove);
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.remove(wordsArrayList);
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        for (int i = 0; i < wordsArrayList.size(); i++) {
            if (wordsArrayList.get(i).equals(from)) {
                wordsArrayList.set(i, to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        if (fromWords.length == toWords.length) {
            replaceEqualWords(fromWords, toWords, wordsArrayList);
        } else {
            if (fromWords.length < toWords.length) {
                replaceMoreToWords(fromWords, toWords, wordsArrayList);
            } else {
                replaceMoreFromWords(fromWords, toWords, wordsArrayList);
            }
        }
    }

    public void replaceEqualWords(String[] fromWords, String[] toWords, List<String> wordsArrayList) {
        if (fromWords.length == wordsArrayList.size()) {
            wordsArrayList = Arrays.asList(toWords);
        } else {
            for (int i = 0; i < wordsArrayList.size(); i++) {
                if (wordsArrayList.get(i).equals(fromWords[0])) {
                    List<String> fromWordsArrayList = Arrays.asList(fromWords);
                    if ((i + fromWordsArrayList.size()) < wordsArrayList.size() - 1) {
                        ArrayList<String> check = new ArrayList<String>(wordsArrayList.subList(i, i + fromWordsArrayList.size()));
                        if (check.equals(fromWordsArrayList)) {
                            for (int j = 0; j < toWords.length; j++) {
                                wordsArrayList.set(i + j, toWords[j]);
                            }
                        }
                    }
                }
            }
        }
    }

    public void replaceMoreToWords(String[] fromWords, String[] toWords, List<String> wordsArrayList) {
        for (int i = 0; i < wordsArrayList.size(); i++) {
            if (wordsArrayList.get(i).equals(fromWords[0])) {
                List<String> fromWordsArrayList = Arrays.asList(fromWords);
                if ((i + fromWordsArrayList.size()) < wordsArrayList.size() - 1) {
                    ArrayList<String> check = new ArrayList<String>(wordsArrayList.subList(i, i + fromWordsArrayList.size()));
                    if (check.equals(fromWordsArrayList)) {
                        for (int j = 0; j < toWords.length; j++) {

                        }
                    }
                }
            }
        }
    }

    public void replaceMoreFromWords(String[] fromWords, String[] toWords, List<String> wordsArrayList) {
        System.out.println("Here I am");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
