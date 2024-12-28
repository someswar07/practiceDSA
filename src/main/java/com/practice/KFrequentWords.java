package com.practice;

import java.util.*;

public class KFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> frequencyMap = new LinkedHashMap<>();
        for(String word: words) {
            if(frequencyMap.containsKey(word)) {
                int freq = frequencyMap.get(word);
                frequencyMap.put(word, freq+1);
            } else {
                frequencyMap.put(word, 1);
            }
        }

        System.out.println("FrequencyMap :: "+frequencyMap);

        List<Map.Entry<String, Integer> > list =
                new LinkedList<>(frequencyMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                if(Objects.equals(o1.getValue(), o2.getValue())) {
                    return (o1.getKey()).compareTo(o2.getKey());
                } else {
                    return (o2.getValue()).compareTo(o1.getValue());
                }
            }
        });

        List<String> outputList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry: list ) {
            if(outputList.size()>=k) {
                break;
            }
            outputList.add(entry.getKey());
        }

        return outputList;
    }

    public static void main(String[] args) {

        KFrequentWords kFrequentWords = new KFrequentWords();
        int k = 3;
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        System.out.println("Output :: "+kFrequentWords.topKFrequent(words, k));
    }
}
