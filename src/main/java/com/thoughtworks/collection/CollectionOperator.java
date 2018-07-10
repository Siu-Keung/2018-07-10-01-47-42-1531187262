package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int increament = left > right ? -1 : 1;
        return Stream.iterate(left, num -> num + increament).limit(Math.abs(left - right) + 1).collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        int increament = left > right ? -1 : 1;
        return Stream.iterate(left, num -> num + increament)
                .limit(Math.abs(left - right) + 1)
                .filter(item -> item % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).boxed()
                .filter(item -> item % 2 == 0)
                .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> firstList = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        return firstList.stream()
                .filter(x -> secondList.stream().anyMatch(y -> y.equals(x)))
                .collect(Collectors.toList());
    }

    // TODO: 2018-07-10 此处方法是否正确？
    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = Arrays.asList(firstArray).stream().collect(Collectors.toList());
        List<Integer> secondList = Arrays.asList(secondArray).stream().collect(Collectors.toList());
        List<Integer> differentList = secondList.stream()
                .filter(item -> !firstList.stream().anyMatch(item2 -> item2.equals(item)))
                .collect(Collectors.toList());
        firstList.addAll(differentList);
        return firstList;
    }
}
