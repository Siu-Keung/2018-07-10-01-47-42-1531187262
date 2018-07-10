package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return this.array.stream().map(item -> item * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(item -> String.valueOf((char)(item.intValue() + 96))).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return this.array.stream().map(item -> {
           int num = item;
           String tempResult = "";
           while(num != 0){
               int countResult = num % 26;
               char ch = countResult != 0 ? (char)(96 + countResult) : 'z';
               num = num % 26 == 0 ? num / 26  -1 : num / 26;
               tempResult += ch;
           }
           return new StringBuffer(tempResult).reverse().toString();
        }).collect(Collectors.toList());

    }

    public List<Integer> sortFromBig() {
        throw new NotImplementedException();
    }

    public List<Integer> sortFromSmall() {
        throw new NotImplementedException();
    }
}
