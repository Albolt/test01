package com.personal.test01.test001;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Creater albolt
 * @2020/12/18 下午11:15
 */

@Data
@NoArgsConstructor
public class Student2 {

    private Long uid;
    private String name;
    private Integer chinese;
    private Integer math;
    private Integer english;
    private Integer science;
    private String aaaa;

    public Student2(Long uid, String name, Integer chinese, Integer math, Integer english, Integer science, String aaaaa) {
        this.uid = uid;
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.science = science;
        this.aaaa = aaaa;
    }

    public Student2(String name, String aaaa) {
        this.name = name;
        this.aaaa = aaaa;
    }

    @Override
    public String toString() {
        return String.format("%12d", uid)+String.format("%9s", name)+
                String.format("%7d", chinese)+String.format("%7d", math)+
                String.format("%7d", english)+String.format("%7d", science);
    }
//
//    public static void option1(String[] lines) {
//        File file = new File("src/main/java/com/personal/test01/test001/student.inf");
//        Student2[] student2s = null;
//        String a = "";
//        try {
//            a = FileUtils.readFileToString(file);
//            String[] as = a.split("\n");
//            if (as.length>0) {
//                student2s = new Student2[as.length-1];
//                for (int i = 0; i < as.length-1; i++) {
//                    String x = as[i];
//                    String[] xs = x.split(" +");
//                    Student2 student2 = new Student2(Long.parseLong(xs[0]), xs[1], Integer.parseInt(xs[2]), Integer.parseInt(xs[2]), Integer.parseInt(xs[3]), Integer.parseInt(xs[4]));
//                    student2s[i-1] = student2;
//                }
//            } else {
//                a = "学号        姓名     语文   数学   英语   科学   总分";
//            }
//
//            System.out.println(a);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for(String line: lines) {
//            String[] lineSplit = line.split(" +");
//            Student2 student2 = new Student2(Long.parseLong(lineSplit[0]), lineSplit[1], Integer.parseInt(lineSplit[2]), Integer.parseInt(lineSplit[2]), Integer.parseInt(lineSplit[3]), Integer.parseInt(lineSplit[4]));
//            if (student2s!=null) {
//                Student2[] student2sNew = new Student2[student2s.length+1];
//                for (int i = 0; i < student2s.length; i++) {
//                    student2sNew[i] = student2s[i];
//                }
//            }
//
//        }
//    }
}
