package com.personal.concurrency;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Aaaa {


    /**
     * 根据随机输入的数组计算得分
     * @param boxes 数组
     * @return 总得分
     */
    public static Integer getMaxScore(Integer[] boxes) {

        AtomicReference<Integer> totalScore = new AtomicReference<>(0);
        while (boxes.length>0){
            Map<Integer, List<Integer>> numMap = getNextMap(boxes);
            boxes = nextScore(numMap, boxes,totalScore);
        }
        return totalScore.get();
    }


    /**
     * 获取下一个数据最少的数据对[数字，数字在源数组中的索引下标数组]
     * @param numList 源数据数组
     * @return
     */
    public static Map<Integer,List<Integer>> getNextMap(Integer[] numList){
        Map<Integer, List<Integer>> indexMap = new HashMap<>(numList.length);
        TreeMap<Integer, Map<Integer, List<Integer>>> countMap = new TreeMap<>();
        for (int i = 0; i < numList.length; i++) {
            Integer num = numList[i];
            List<Integer> indexList = indexMap.getOrDefault(num, new ArrayList<>());
            indexList.add(i+1);
            indexMap.put(num, indexList);
        }
        indexMap.forEach((num,indexList)->{
            Map<Integer, List<Integer>> sortMap = countMap.getOrDefault(indexList.size(), new HashMap<>());
            sortMap.put(num, indexList);
            countMap.put(indexList.size(), sortMap);
        });
        return countMap.firstEntry().getValue();
    }

    /**
     * 查找下一个取值的数并计算得分
     * @param indexMap （数字，数组下标列表）
     * @param sourceList 数据源
     * @return 得分
     */
    public static Integer[] nextScore(Map<Integer, List<Integer>> indexMap,Integer[] sourceList,AtomicReference<Integer> totalScore){
        AtomicReference<Integer> maxScore = new AtomicReference<>(0);
        AtomicReference<Integer> resultNum = new AtomicReference<>(0);
        indexMap.forEach((num,list)->{
            Integer score = getScore(list.toArray(new Integer[]{}));
            if (score > maxScore.get()) {
                maxScore.set(score);
                resultNum.set(num);
            }
        });
        totalScore.set(totalScore.get() + maxScore.get());
        return removeNum(sourceList,resultNum.get());
    }


    /**
     * 移除数组指定元素
     * @param sourceList 原始数组
     * @param num 移除的数据
     * @return 新数组
     */
    public static Integer[] removeNum(Integer[] sourceList, Integer num) {
        Integer[] change = new Integer[sourceList.length];
        int index = 0;
        for (Integer integer : sourceList) {
            if (!num.equals(integer)) {
                change[index] = integer;
                index++;
            }
        }
        Integer[] result = new Integer[index];
        if (index >= 0) {
            System.arraycopy(change, 0, result, 0, index);
        }
        return result;
    }


    /**
     * 同一种数据 按不同索引计算得分
     * @param boxes 数字索引
     * @return 总分
     */
    public static int getScore(Integer[] boxes){
        if (boxes.length == 0) {
            return 0;
        }
        int score = 0;
        int lastIndex = 0;
        int count = 1;
        for (int index : boxes) {
            if (lastIndex == 0) {
                count = 1;
            } else if (index == lastIndex + 1) {
                count++;
            } else {
                score += count * count;
                count = 1;
            }
            lastIndex = index;
            if (lastIndex == boxes[boxes.length - 1]) {
                score += count * count;
            }
        }
        return score;
    }


    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,3,2,2,2,3,4,3,1};
        System.out.println(getMaxScore(array));
    }
}
