package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if(leftBorder > rightBorder){
            int temp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = temp;
        }
        int result = 0;
        int index = leftBorder % 2 == 0 ? leftBorder : leftBorder + 1;
        while(index <= rightBorder){
            result += index;
            index += 2;
        }
        return result;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if(leftBorder > rightBorder){
            int temp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = temp;
        }
        int result = 0;
        int index = leftBorder % 2 == 1 ? leftBorder : leftBorder + 1;
        while(index <= rightBorder){
            result += index;
            index += 2;
        }
        return result;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int result = arrayList.stream().reduce(0, (accumulator, current) -> accumulator + 3 * current + 2);
        return result;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(item -> item % 2 == 1 ? item * 3 + 2 : item).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().reduce(
                0, (accumulator, current) -> current % 2 == 1 ? accumulator + current * 3 + 5 : accumulator);
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> resultList = arrayList.stream()
                .filter(item -> item % 2 == 0).sorted((x, y) -> x - y).collect(Collectors.toList());
        double result = resultList.get(resultList.size() / 2);
        if(resultList.size() % 2 != 1)
            result = (resultList.get(resultList.size() / 2) + resultList.get(resultList.size() / 2 - 1)) / 2.0;
        return result;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());
        return evenList.stream().reduce(0, (sum, current) -> sum + current) / evenList.size();

    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(item -> item % 2 == 0)
                .anyMatch(item -> item.equals(specialElment));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(item -> item % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    // TODO: 2018-07-10 这题是否有更优解决方案？
    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> resultList = new ArrayList<>();
        for(int i = 1; i < arrayList.size(); i++){
            resultList.add((arrayList.get(i - 1) + arrayList.get(i)) * 3);
        }
        return resultList;
    }
}
