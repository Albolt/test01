//package com.personal.test01.test001;
//
///**
// * @Creater albolt
// * @12/12/20 9:23 PM
// */
//
//public class Student {
//
//    private String name;
//    private double grade,finalgrade;
//    private char overallscores;
//
//    Student(String name,double grade,double finalgrade){
//        this.finalgrade=finalgrade;
//        this.name=name;
//        this.grade=grade;
//    }
//
//    public String getters() {
//        return name;
//    }
//
//    double getters1() {
//        return grade;
//    }
//
//    double getters2() {
//        return finalgrade;
//    }
//
//    void setters(String name) {
//        this.name=name;
//    }
//
//    void setters1(double grade) {
//        this.grade=grade;
//    }
//
//    void setters2(double finalgrade) {
//        this.finalgrade=finalgrade;
//    }
//
//    public String rank( double finalgrade) {
//        this.finalgrade=finalgrade;
//        finalgrade=0.6*finalgrade+0.4*grade;
//        finalgrade=(int)finalgrade;
//        if(finalgrade>=90) {
//            return "A";
//        }else if(finalgrade>=80&&finalgrade<90) {
//            return"B";
//        }else if(finalgrade>=70&&finalgrade<80) {
//            return"C";
//        }else if(finalgrade>=60&&finalgrade<70) {
//            return"D";
//        }else return"E";
//    }
//}
