package com.personal.test01.everyOther;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;


/**
 * @Creater albolt
 * @12/4/20 10:21 AM
 */

class Matrix {

    private String name;
    private int[][] data;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int[][] getData() {
        return data;
    }

    void setData(int[][] data) {
        this.data = data;
    }

    private static Integer count=1;

    private Matrix(int[][] data) {
        this.data = data;
        this.name = "矩阵"+count.toString();
        count++;
    }

    private Matrix(String name, int[][] data) {
        this.name = name;
        this.data = data;
    }

    public static Matrix getInstance(int[][] data) {
        int x = data[0].length;
        if (data.length==0 || x==0) {
            return null;
        }
        int i = 0;
        for (i = 0;i<data.length;i++) {
            if (data[i].length!=x) {
                return null;
            }
        }
        return new Matrix(data);
    }

    public static Matrix getInstance(String name, int[][] data) {
        int x = data[0].length;
        if (data.length==0 || x==0 || StringUtils.isBlank(name)) {
            return null;
        }
        int i = 0;
        for (i = 0;i<data.length;i++) {
            if ((data[i].length)!=x) {
                return null;
            }
        }
        return new Matrix(name, data);
    }

    public int sum() {
        int x = 0;
        int i = 0;
        int j = 0;
        for (i = 0;i<data.length;i++) {
            for (j = 0;j<data[i].length;j++) {
                if (i==0||(i==data.length-1)) {
                    x+=data[i][j];
                } else {
                    if (j==0||j==(data[i].length-1)) {
                        x+=data[i][j];
                    }
                }
            }
        }
        return x;
    }

    @Override
    public String toString() {
        String result = "";
        int i = 0;
        int j = 0;
        for (i = 0; i < data.length; i++) {
            for (j = 0; j < data[i].length; j++) {
                result+=String.format("%4d", this.data[i][j]);
                if (j==(data[i].length-1)&&i!=(data.length-1)) {
                    result+="\n";
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Matrix matrix = (Matrix) o;
        if (!this.name.equals(matrix.getName())) {
            return false;
        }
        if (this.data.length!=matrix.getData().length || this.data[0].length!=matrix.getData()[0].length) {
            return false;
        }
        int i = 0;
        int j = 0;
        for (i = 0;i<data.length;i++) {
            for (j = 0; j < data[i].length; j++) {
                if (this.data[i][j]!=matrix.data[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
