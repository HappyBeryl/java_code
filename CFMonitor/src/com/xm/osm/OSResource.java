package com.xm.osm;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class OSResource {
    //获取系统资源的接口OperatingSystemMXBean
    private static OperatingSystemMXBean mxBean =
            ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

    //声明数组记录xy的坐标
    private static final int DATA_LENGTH = 60;
    // 记录 60 个坐标点，也就是一个统计周期
    private static XYPair[] xypairs = new XYPair[DATA_LENGTH];
    private static int firstIndex = DATA_LENGTH;

    static {
        for (int i = 0; i < xypairs.length; i++) {
            xypairs[i] = new XYPair(0,0);
        }
    }


    //将cpu占有率显示到页面上
    public static class XYPair {

        public XYPair(double x, double y) {
            this.x = x;
            this.y = y;
        }

        private double x;
        private double y;

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }

    //获取cpu占有率
    public static XYPair[] getCpuPercetage() {
        double cpu = mxBean.getSystemCpuLoad();

        moveCPUData(cpu);

        return xypairs;
    }

    private static void moveCPUData(double cpuPercetage){
        int movIdx = -1;
        if (firstIndex == 0){
            movIdx = firstIndex + 1;
        }else {
            movIdx = firstIndex;
            firstIndex--;
        }

        for (; movIdx < xypairs.length; ++movIdx){
            xypairs[movIdx-1].setX(xypairs[movIdx].getX()-1);
            xypairs[movIdx-1].setY(xypairs[movIdx].getY());
        }

        movIdx--;

        xypairs[movIdx] = new XYPair(movIdx, cpuPercetage);
    }





}
