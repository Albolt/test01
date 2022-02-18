package com.personal.test01.optional;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long code;

    private String Email;

    private Map<String, String> a;


}
