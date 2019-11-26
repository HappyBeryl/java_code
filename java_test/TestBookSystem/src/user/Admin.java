package user;

import com.sun.org.apache.bcel.internal.generic.NEW;
import operation.*;

import java.util.Scanner;

public class Admin extends User {
    public Admin(String name) {
        this.name = name;
        this.operations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation()
        };
    }
    @Override
    public int menu() {
        System.out.println("欢迎管理员"+ this.name+"登录");
        System.out.println("0.退出系统");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示所有图书");
        System.out.println("输入选择");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }



}
