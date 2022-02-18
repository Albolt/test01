package com.personal.test01.everyOther;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Creater albolt
 * @12/4/20 9:11 PM
 */

public class People implements Comparable<People> {

    private String name;
    private Double height;
    private Double weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public People(String name, Double height, Double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + "，身高：" + height + "，体重：" + weight;
    }

    @Override
    public int compareTo(People o) {
        if (o.getHeight()>this.height) {
            return 1;
        } else if (o.getHeight()<this.height) {
            return -1;
        } else {
            if (o.getWeight()>=this.weight) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
