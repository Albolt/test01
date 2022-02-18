package com.personal.test01.everyOther;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Points extends JPanel {
    public void paintComponent(Graphics g) {
        Scanner kb = new Scanner(System.in);
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);

        Dimension size = getSize();

        g2d.drawLine(0, 0, 0, 600);
        g2d.drawLine(0, 600, 800, 600);
        g2d.drawString("0", 0, 310);
        g2d.drawString("5", 0, 235);
        g2d.drawString("10", 0, 160);
        g2d.drawString("15", 0, 85);
        g2d.drawString("20", 0, 10);
        g2d.drawString("-5", 0, 385);
        g2d.drawString("-10", 0, 460);
        g2d.drawString("-15", 0, 535);
        g2d.drawString("-20", 0, 600);

        g2d.drawString("1", 100, 610);
        g2d.drawString("2", 200, 610);
        g2d.drawString("3", 300, 610);
        g2d.drawString("4", 400, 610);
        g2d.drawString("5", 500, 610);
        g2d.drawString("6", 600, 610);
        g2d.drawString("7", 700, 610);
        g2d.drawString("8", 800, 610);

        g2d.drawLine(0, 0, 800, 0);
        g2d.drawLine(800, 0, 800, 600);

        for (double k = 0.1; k < 8; k += 0.2) {
            g2d.fillOval((int) (k * 100), 225, 10, 2);
            g2d.fillOval((int) (k * 100), 75, 15, 2);
            g2d.fillOval((int) (k * 100), 300, 15, 2);
            g2d.fillOval((int) (k * 100), 525, 15, 2);
            g2d.fillOval((int) (k * 100), 375, 15, 2);
        }
        for (double k = 0.0; k < 40; k += 0.5) {
            g2d.fillOval(100, (int) (k * 15), 2, 5);
            g2d.fillOval(300, (int) (k * 15), 2, 5);
            g2d.fillOval(400, (int) (k * 15), 2, 5);
            g2d.fillOval(600, (int) (k * 15), 2, 5);
        }


        double t = kb.nextDouble(), n = 0.0;
        while (n <= 8.0) {
//            System.out.println(-2.0 * n + " " + Math.sin(n * n));
//            System.out.println(-2.0 * n * Math.sin(n * n));
            int x = (int) (n * 100);
            int y = (int) ((2.0 * n * Math.sin(n * n)) * 15 + 300);
//            System.out.println(x + " 0 " + y);
            g2d.fillOval(x, y, 5, 5);
            n += t;
        }
//        g2d.fillOval(0, 0, 10, 10);
    }

    public static void main(String[] args) {
        Points points = new Points();
        JFrame frame = new JFrame("Points");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(points);
        frame.setSize(850, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}