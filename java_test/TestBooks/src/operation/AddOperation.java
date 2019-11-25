package operation;

import book.Book;
import book.BookList;

public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("添加图书");
        System.out.println("请输入要添加图书的名字：");
        String name = scanner.next();
        System.out.println("请输入要添加图书的作者");
        String author = scanner.next();
        System.out.println("请输入要添加图书的价格");
        int price = scanner.nextInt();
        System.out.println("请输入要添加图书的类型");
        String type = scanner.next();

        Book book = new Book(name,author, price, type);
        int pos = bookList.getUseSize();
        bookList.setBooks(pos,book);
        bookList.setUseSize(pos+1);
    }
}
