package user;

import book.BookList;
import operation.IOperation;

public abstract class User {
    String name;
    public abstract int menu();

    //IOperation接口数组 实现这个接口的类都可以存放进去
    public IOperation[] operations;

    //根据用户选项执行操作
    public void doOperations(int choice, BookList bookList) {
        operations[choice].work(bookList);
    }

}
