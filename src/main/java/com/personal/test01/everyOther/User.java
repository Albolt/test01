package com.personal.test01.everyOther;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Integer score;

    private String ruleName;

    private Date date;

    public User(Integer score) {
        this(score, "\"无名氏\"", new Date());
    }

    public User(Integer score, String ruleName) {
        this(score, ruleName, new Date());
    }

    public User(Date date) {
        this(0, "\"无名氏\"", date);
    }

    public User2 toU() {
        User2 user2 = new User2();
        user2.setScore(this.score.longValue());
        return user2;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(ruleName).toHashCode();
    }


}
