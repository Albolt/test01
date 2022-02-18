package com.personal.test01.everyOther;

import lombok.Data;

/**
 * @Creater albolt
 * @12/1/20 2:41 PM
 */

@Data
public class Plural {

    private Integer real;
    private Integer ima;

    public Plural addition(Plural p1, Plural p2) {
        Plural result = new Plural();
        result.setReal(p1.getReal()+p2.getReal());
        result.setIma(p1.getIma()+p2.getReal());
        return result;
    }

    public Plural multiplication(Plural p1, Plural p2) {
        Plural result = new Plural();
        result.setReal(p1.getReal()*p2.getReal()-p1.getIma()*p2.getIma());
        result.setIma(p1.getIma()*p1.getReal()+p1.getReal()*p2.getIma());
        return result;
    }

    @Override
    public String toString() {
        return this.real+"+"+this.ima+"i";
    }
}
