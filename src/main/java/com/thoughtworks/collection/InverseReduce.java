package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    // TODO: 2018-07-10 是否有更好的方法？ 
    public List<Integer> divideToSmaller(int number) {
        List<Integer> resultList = new ArrayList<>();
        int num = number - random.nextInt(3);
        while(num > 0){
            resultList.add(num);
            int temp = random.nextInt(3);
            num -= temp;
        }
        return resultList;
    }
}
