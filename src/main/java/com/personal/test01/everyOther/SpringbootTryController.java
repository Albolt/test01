package com.personal.test01.everyOther;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/controller321")
public class SpringbootTryController {

    @PostMapping("/321")
    public Object tryController() {
        Date a = new Date();
        System.out.println(a);

        return null;
    }
}
