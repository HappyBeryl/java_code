package operation;

import book.Book;
import book.BookList;

public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍");
        System.out.println("输入要删除的书籍：");
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

        //i号下标的书籍就是要删除的书籍
        for (int j = i; j < bookList.getUseSize()-1; j++) {
            book = bookList.getBook(j+1);
            bookList.setBooks(j,book);
        }

        int curSize = bookList.getUseSize();
        bookList.setUseSize(curSize-1);
        System.out.println("删除成功！");

    }
}
