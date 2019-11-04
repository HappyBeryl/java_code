package com.test;

public class Calc {
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public double add() {
        return this.num1+this.num2;
    }
    public double sub() {
        return this.num1-this.num2;
    }
    public double mul() {
        return this.num1*this.num2;
    }
    public double div() {
        return this.num1/this.num2;
    }

}
class Main {
    public static void main(String[] args) {
      Calc calc = new Calc();
      calc.setNum1(20);
      calc.setNum2(10);
        System.out.println(calc.add());
        System.out.println(calc.sub());
        System.out.println(calc.mul());
        System.out.println(calc.div());
}

}

