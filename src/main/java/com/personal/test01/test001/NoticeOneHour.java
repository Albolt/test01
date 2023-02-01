package com.personal.test01.test001;

import com.personal.test01.thread.MyThread;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Desc 每个小时提醒你该活动一下了
 * @author albolt
 * @ClassName NoticeOneHour.java
 * @createTime 2022.05.27. 17:48:49
 */
public class NoticeOneHour extends Thread{
    @Override
    public void run() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse("2099-00-00 00:00:00");
            long millis = date.getTime();
            Integer asd = 0;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                Date endDate = new Date();
                long endMillis = endDate.getTime();
                if (true) {
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
                        JOptionPane.showMessageDialog(null, null, "该起来活动一下了", JOptionPane.WARNING_MESSAGE, new Icon() {
                            @Override
                            public void paintIcon(Component c, Graphics g, int x, int y) {

                            }

                            @Override
                            public int getIconWidth() {
                                return 0;
                            }

                            @Override
                            public int getIconHeight() {
                                return 0;
                            }
                        });
                    }
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
        NoticeOneHour noticeOneHour = new NoticeOneHour();
        noticeOneHour.start();
    }
}
