package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return this.arrayList.stream().max((x, y) -> x - y).get();
    }

    public double getMinimum() {
        return this.arrayList.stream().max((x, y) -> y - x).get();
    }

    public double getAverage() {
        return 1.0 * this.arrayList.stream()
                .reduce(0, (sum, current) -> sum + current) /
                this.arrayList.size();
    }

    public double getOrderedMedian() {
        List<Integer> resultList = this.arrayList.stream()
                .sorted((x, y) -> x - y).collect(Collectors.toList());
        double result = resultList.get(resultList.size() / 2);
        if (resultList.size() % 2 != 1)
            result = (resultList.get(resultList.size() / 2) + resultList.get(resultList.size() / 2 - 1)) / 2.0;
        return result;
    }

    public int getFirstEven() {
        for (Integer integer : arrayList) {
            if(integer % 2 == 0)
                return integer;
        }
        return this.arrayList.get(0);
    }

    public int getIndexOfFirstEven() {
        for(int i = 0; i < this.arrayList.size(); i++){
            if(arrayList.get(i) % 2 == 0)
                return i;
        }
        return -1;
    }

    public boolean isEqual(List<Integer> arrayList) {
        if(this.arrayList.size() != arrayList.size())
            return false;
        for(int i = 0; i < this.arrayList.size(); i++)
            if(!this.arrayList.get(i).equals(arrayList.get(i)))
                return false;
        return true;
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        double result = this.arrayList.get(this.arrayList.size() / 2);
        if (this.arrayList.size() % 2 != 1)
            result = (this.arrayList.get(this.arrayList.size() / 2) + this.arrayList.get(this.arrayList.size() / 2 - 1)) / 2.0;
        return result;
    }

    public int getLastOdd() {
        return this.arrayList.stream()
                .reduce(-1, (accumulator, current) -> current % 2 == 1 ? current : accumulator);
    }

    public int getIndexOfLastOdd() {
        int lastIndex = 0;
        for(int index = 0; index < arrayList.size(); index++){
            if(arrayList.get(index) % 2 == 1)
                lastIndex = index;
        }
        return lastIndex;
    }
}
