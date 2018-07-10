package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        throw new NotImplementedException();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        throw new NotImplementedException();
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        throw new NotImplementedException();
    }
}
