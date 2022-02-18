package com.personal.test01.test001;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class StorageLocationNo {

    private static List<String> toNameList(List<Integer> locationStart, List<Integer> locationEnd) {
        Boolean excep = false;
        //最少一位，必须按顺序填写，中间不能空，开始和结束位数一样
        if (CollectionUtils.isEmpty(locationStart) || CollectionUtils.isEmpty(locationEnd) || locationStart.size()!=locationEnd.size() || locationStart.size() < 1 || locationStart.size()>4 || locationStart.contains(null) || locationEnd.contains(null)) {
            return null;
        }
        //从前往后，结束小于开始：异常，结束大于开始：通过，结束等于开始：校验下一位，直到最后一位相等，通过
        for (int i = 0; i < locationStart.size(); i++) {
            if (locationStart.get(i)>10||locationStart.get(i)<1||locationEnd.get(i)>10||locationEnd.get(i)<1) {
                break;
            }
            if (locationStart.get(i)>locationEnd.get(i)) {
                break;
            } else if (locationStart.get(i)<locationEnd.get(i)) {
                excep = true;
                break;
            } else {
                if (i==locationStart.size()-1) {
                    excep = true;
                }
            }
        }
        if (!excep) {
            return null;
        }

        //开始生成
        //开始和结束两个列表转成两个数字
        //从开始的数字依次加一，每个数字转成对应的库位编码
        //库位编码也是十进制，但是是从01到10，没有0
        //所以0要特殊处理：前一位减一
        //如果前一位是1，减一变成0，也要特殊处理
        //由于位数不确定，所以循环处理
        List<String> nameList = new ArrayList<>();

        String nameStart = "";
        String nameEnd = "";
        for (int i = 0; i < locationStart.size(); i++) {
            if (locationStart.get(i) != 10) {
                nameStart+=locationStart.get(i);
            } else {
                nameStart = toNameTen(nameStart) + "0";
            }
            if (locationEnd.get(i) != 10) {
                nameEnd+=locationEnd.get(i);
            } else {
                nameEnd = toNameTen(nameEnd) + "0";
            }
        }
        Integer start = Integer.valueOf(nameStart);
        Integer end = Integer.valueOf(nameEnd);

        Integer nameIndex = start;
        while (nameIndex<=end) {
            String nameString = nameIndex.toString();
            String[] names = nameString.split("");
            String name = "";
            for (String namex : names) {
                if (namex.equals("0")) {
                    String result = toNameZero(name);
                    name = result + "-10";
                } else {
                    name = name + "-" + "0" + namex;
                }
            }
            nameList.add(name);
            nameIndex++;
        }

        return nameList;
    }

    private static String toNameTen(String name) {
        if (StringUtils.isBlank(name)) {
            return "1";
        }
        String nameFirst = name.substring(0, name.length());
        String nameLast = name.substring(name.length());
        if (nameLast.equals("9")) {
            String result = toNameTen(nameFirst);
            return result + "0";
        } else {
            if (StringUtils.isBlank(nameLast)) {
                Integer nameNum = Integer.valueOf(nameFirst)+1;
                return nameNum.toString();
            }
            Integer nameNum = Integer.valueOf(nameLast)+1;
            return nameFirst+nameNum.toString();
        }
    }

    private static String toNameZero(String name) {
        if (StringUtils.isBlank(name)) {
            return "";
        }
        Integer index = name.lastIndexOf("-");
        String nameFirst = name.substring(0, index);
        String nameLast = name.substring(index+1);
        if (nameLast.equals("01")) {
            if (StringUtils.isBlank(nameFirst)) {
                return "";
            }
            String result = toNameZero(nameFirst);
            return result + "-10";
        } else {
            Integer nameNum = Integer.valueOf(nameLast)-1;
            return nameFirst + "-0" + nameNum;
        }
    }
}
