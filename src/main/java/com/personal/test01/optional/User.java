package com.personal.test01.optional;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User<PK> {

    private PK id;

    private Long code;

    private Map<String, String> Email;


}
