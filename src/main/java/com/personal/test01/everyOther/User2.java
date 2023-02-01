package com.personal.test01.everyOther;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class User2 {

    private Long score;

    private Integer a;

    public User2(){}

    public User2(Long score) {
        this.score = score;
    }

    public String User2(List<String> a) {
        return "2";
    }

    @Override
    public String toString() {
        return "score:" + this.score +
                "\n A:" + this.a;
    }
}
