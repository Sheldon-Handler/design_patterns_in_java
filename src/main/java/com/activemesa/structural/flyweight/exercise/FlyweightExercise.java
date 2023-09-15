package com.activemesa.structural.flyweight.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Sentence {
    private String[] words;
    private Map<Integer, WordToken> tokens = new HashMap<>();

    public Sentence(String plainText) {
        words = plainText.split(" ");
    }

    public WordToken getWord(int index) {
        WordToken wordToken = new WordToken();
        tokens.put(index, wordToken);
        return tokens.get(index);
    }

    @Override
    public String toString() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            if (tokens.containsKey(i) && tokens.get(i).capitalize)
                word = word.toUpperCase();
            stringArrayList.add(word);
        }
        return String.join(" ", stringArrayList);
    }

    class WordToken {
        public boolean capitalize;
    }
}