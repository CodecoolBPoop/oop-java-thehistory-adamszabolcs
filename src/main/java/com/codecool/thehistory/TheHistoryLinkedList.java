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
        List<String> remove = new LinkedList<>(Arrays.asList(wordToBeRemoved));
        wordsLinkedList.removeAll(remove);
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
        ListIterator<String> listIterator = wordsLinkedList.listIterator();
        while(listIterator.hasNext()) {
            String nextWord = listIterator.next();
            if (nextWord.equals(from)) {
                listIterator.set(to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        if (fromWords.length == toWords.length) {
            replaceEqualWords(fromWords, toWords, wordsLinkedList);
        } else {
            if (fromWords.length < toWords.length) {
                replaceMoreToWords(fromWords, toWords, wordsLinkedList);
            } else {
                replaceMoreFromWords(fromWords, toWords, wordsLinkedList);
            }
        }
    }

    public void replaceEqualWords(String[] fromWords, String[] toWords, List<String> wordsLinkedList) {
        if (fromWords.length == wordsLinkedList.size()) {
            wordsLinkedList = Arrays.asList(toWords);
        } else {
            ListIterator<String> listIterator = wordsLinkedList.listIterator();
            while (listIterator.hasNext()) {
                String word = listIterator.next();
                int wordIndex = listIterator.nextIndex() - 1;
                if (word.equals(fromWords[0])) {
                    List<String> fromwordsLinkedList = Arrays.asList(fromWords);
                    if ((wordIndex + fromwordsLinkedList.size()) < wordsLinkedList.size()) {
                        ArrayList<String> check = new ArrayList<String>(wordsLinkedList.subList(wordIndex, wordIndex + fromwordsLinkedList.size()));
                        if (check.equals(fromwordsLinkedList)) {
                            int i = 0;
                            while(i < toWords.length) {
                                listIterator.set(toWords[i]);
                                listIterator.next();
                                i++;
                            }
                        }
                    }
                }
            }
        }
    }

    public void replaceMoreToWords(String[] fromWords, String[] toWords, List<String> wordsLinkedList) {
        List<String> fromwordsLinkedList = Arrays.asList(fromWords);
        ListIterator<String> listIterator = wordsLinkedList.listIterator();
        while(listIterator.hasNext()) {
            String word = listIterator.next();
            int wordIndex = listIterator.nextIndex()-1;
            int prevWordIndex = listIterator.previousIndex()-1;
            if (word.equals(fromWords[0]) && !wordsLinkedList.get(prevWordIndex).equals(toWords[0])) {
                if ((wordIndex + fromwordsLinkedList.size()) <= wordsLinkedList.size()|| fromwordsLinkedList.size() == 1) {
                    ArrayList<String> check = new ArrayList<String>(wordsLinkedList.subList(wordIndex, wordIndex + fromwordsLinkedList.size()));
                    if (check.equals(fromwordsLinkedList)) {
                        int i = 0;
                        while (i < toWords.length) {
                            if (i < fromWords.length) {
                                if (i > 0 && listIterator.hasNext()) {
                                    listIterator.next();
                                }
                                listIterator.set(toWords[i]);
                            } else {
                                listIterator.add(toWords[i]);
                            }
                            i++;
                        }
                    }
                }
            }
        }
    }

    public void replaceMoreFromWords(String[] fromWords, String[] toWords, List<String> wordsLinkedList) {
        List<String> fromwordsLinkedList = Arrays.asList(fromWords);
        ListIterator<String> listIterator = wordsLinkedList.listIterator();
        while(listIterator.hasNext()) {
            String word = listIterator.next();
            int wordIndex = listIterator.nextIndex()-1;
            int prevWordIndex = listIterator.previousIndex()-1;
            if (word.equals(fromWords[0])) {
                if ((wordIndex + fromwordsLinkedList.size()) <= wordsLinkedList.size()|| fromwordsLinkedList.size() == 1) {
                    ArrayList<String> check = new ArrayList<String>(wordsLinkedList.subList(wordIndex, wordIndex + fromwordsLinkedList.size()));
                    if (check.equals(fromwordsLinkedList)) {
                        int i = 0;
                        while (i < fromWords.length) {
                            if (i < toWords.length) {
                                if (i > 0 && listIterator.hasNext()) {
                                    listIterator.next();
                                }
                                listIterator.set(toWords[i]);
                            } else {
                                listIterator.next();
                                listIterator.remove();
                            }
                            i++;
                        }
                    }
                }
            }
        }
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
