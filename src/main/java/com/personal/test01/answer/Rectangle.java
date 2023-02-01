package com.personal.test01.answer;


public class Rectangle {

    private double width;

    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Rectangle() {}

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Double getArea() {
        return this.width*this.height;
    }

    public Double getPerimeter() {
        return (this.width+this.height)*2;
    }
}
