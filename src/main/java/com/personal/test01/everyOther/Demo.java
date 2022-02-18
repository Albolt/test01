package com.personal.test01.everyOther;


import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

public class Demo
{

    public static void main(String[] args)
    {

        XYSeries series = new XYSeries("xySeries");

        for (double x = 0; x < 8; x = x + 0.01)
        {

            double y = -2 * x * Math.sin(x * x);

            series.add(x, y);

        }

        XYSeriesCollection dataset = new XYSeriesCollection();

        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(

                "y =-2xsin(x^2)",

                "x",

                "-2xsin(x^2)",

                dataset,

                PlotOrientation.VERTICAL,

                false,

                false,

                false

        );

        XYPlot plot = (XYPlot) chart.getPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.BLUE);

        renderer.setSeriesLinesVisible(0, false);

        plot.setRenderer(renderer);

        ChartFrame frame = new ChartFrame("my picture", chart);

        frame.pack();

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}