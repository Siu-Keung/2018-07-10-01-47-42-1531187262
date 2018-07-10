package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    // TODO: 2018-07-10 此处是否有更好的方法
    public List<Integer> transformToOneDimesional() {
        List<Integer> resultList = new ArrayList<>();
        for (Integer[] integers : array) {
            for (Integer integer : integers) {
                resultList.add(integer);
            }
        }
        return resultList;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        return this.transformToOneDimesional().stream().distinct().collect(Collectors.toList());
    }
}
