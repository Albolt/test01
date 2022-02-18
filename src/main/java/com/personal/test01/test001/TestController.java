package com.personal.test01.test001;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @Creater albolt
 * @2020-10-10 15:22
 */
public class TestController extends Thread{
    @Override
    public void run() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH: mm:ss");
            Date date = sdf.parse("2022-2-18 18: 00: 00");
            long millis = date.getTime();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                Date endDate = new Date();
                long endMillis = endDate.getTime();
                if (millis > endMillis) {
                    Thread.sleep(1000);
                    System.out.println("距复活还有: " + (millis - endMillis) / 1000 / 60 / 60 / 24 + "天" +
                            (((millis - endMillis) / 1000 ) / 60 / 60 - ((millis - endMillis) / 1000 / 60 / 60 / 24 * 24)) + "小吋" +
                            ((millis - endMillis) / 1000) / 60 % 60 + "分: " +
                            ((millis - endMillis) / 1000) % 60 + "秒");
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
