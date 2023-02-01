package com.personal.test01.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

@Data
@NoArgsConstructor
public class MyThread implements Runnable {

    private Thread t;
    private Long tian;
    private Long shi;
    private Long fen;
    private Long miao;

    public MyThread(Long tian, Long shi, Long fen, Long miao) {
        this.t = t;
        this.tian = tian;
        this.shi = shi;
        this.fen = fen;
        this.miao = miao;
    }

    @Override
    public void run() {
        JOptionPane.showMessageDialog(null, "剩余"+tian+"天"+shi+"时"+fen+"分"+miao+"秒", "复活", JOptionPane.ERROR_MESSAGE, new Icon() {
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
}
