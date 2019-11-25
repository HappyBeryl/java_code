package operation;

import book.Book;
import book.BookList;

public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅书籍");
        System.out.println("请输入要借阅书籍的名字：");
        String name = scanner.next();
        int i = 0;
        Book book = null;
        for (; i < bookList.getUseSize(); i++) {
            book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                break;
            }
        }

        if (i == bookList.getUseSize()) {
            System.out.println("没有此书");
            return;
        }

        book =  bookList.getBook(i);
        if (book.getBorrowed()) {
            System.out.println("此书已被借出");
        } else {
            book.setBorrowed(true);
            System.out.println("借阅成功");
        }
    }
}
