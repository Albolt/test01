package com.personal.test01.everyOther;

import lombok.Getter;

/**
 * @Creater albolt
 * @2020/4/26 下午5:23
 */

@Getter
public enum EnumDemo {

    TRY_001(1,"try001","测试001"),
    TRY_002(2,"try002","测试002"),
    TRY_003(3,"try003","测试003");


    int code;
    String name;
    String nameCn;

    EnumDemo(int code,String name,String nameCn){
        this.code = code;
        this.name = name;
        this.nameCn = nameCn;
    }

    public static boolean isEnum(int code){
        for (EnumDemo e:values()){
            if (e.code==code){
                return true;
            }
        }
        return false;
    }

    public static EnumDemo getByCode(int code) {
        for (EnumDemo e:values()){
            if (e.code==code){
                return e;
            }
        }
        return null;
    }
}
