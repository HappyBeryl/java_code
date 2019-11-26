package com.testthinkinginjava;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

class  WaterSource {
    private String s;
    WaterSource() {
        System.out.println("waterSource()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

public class SprinklerSystem {
    private String value1,valve2,valve3,valve4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        return "SprinklerSystem{" +
                "value1='" + value1 + '\'' +
                ", valve2='" + valve2 + '\'' +
                ", valve3='" + valve3 + '\'' +
                ", valve4='" + valve4 + '\'' +
                ", source=" + source +
                ", i=" + i +
                ", f=" + f +
                '}';
    }

    public static void main(String[] args) {
        SprinklerSystem sprink = new SprinklerSystem();
        System.out.println(sprink);
    }
}
