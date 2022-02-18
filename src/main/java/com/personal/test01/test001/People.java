package com.personal.test01.test001;

/**
 * @Creater albolt
 * @12/12/20 8:42 PM
 */

public class People implements Comparable<People> {

    private String name;
    private MyDate myDate;

    public People(String name, MyDate myDate) {
        this.name = name;
        this.myDate = myDate;
    }

    public String getName() {
        return name;
    }

    public MyDate getMyDate() {
        return myDate;
    }

    @Override
    public String toString() {
        return name+","+myDate.toString();
    }

    @Override
    public int compareTo(People people) {
        if (people.getMyDate().compareTo(this.myDate)>0) {
            return -1;
        } else if (people.getMyDate().compareTo(this.myDate)<0) {
            return 1;
        } else {
            if (people.getName().compareTo(this.name)>0) {
                return -1;
            } else if (people.getName().compareTo(this.name)<0) {
                return 1;
            }
        }
        return 0;
    }
}
