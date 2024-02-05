package com.personal.test01.test001;
import com.personal.test01.thread.MyThread;
import org.springframework.scheduling.annotation.Async;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Creater albolt
 * @2020-10-10 15:22
 */
public class TestController extends Thread{
    @Override
    public void run() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH: mm:ss");
            Date date = sdf.parse("2023-08-08 11: 30: 00");
            long millis = date.getTime();
            Integer asd = 0;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                Date endDate = new Date();
                long endMillis = endDate.getTime();
                if (millis > endMillis) {
                    Thread.sleep(1000);
                    Long tian = (millis - endMillis) / 1000 / 60 / 60 / 24;
                    Long shi = (((millis - endMillis) / 1000 ) / 60 / 60 - ((millis - endMillis) / 1000 / 60 / 60 / 24 * 24));
                    Long fen = ((millis - endMillis) / 1000) / 60 % 60;
                    Long miao = ((millis - endMillis) / 1000) % 60;
                    List<Long> fenList = new ArrayList<>();
                    fenList.add(0L);
                    fenList.add(15L);
                    fenList.add(30L);
                    fenList.add(45L);
                    if (fen.equals(0L) && miao.equals(0L)) {
                        MyThread myThread = new MyThread(tian, shi, fen, miao);
                        Thread t = new Thread(myThread);
                        t.start();
                        asd++;
                    }
                    System.out.println("距复活还有: " + tian + "天" +
                            shi + "小吋" +
                            fen + "分: " +
                            miao + "秒");
                } else {
                    System.out.println("复活了! ! ! ");
                    break;
                }
            }
        }catch (Exception e){
                e. printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestController testController = new TestController();
        testController.start();
    }
}
