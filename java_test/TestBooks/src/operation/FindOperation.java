package operation;

import book.Book;
import book.BookList;

public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("查找书籍");
        System.out.println("输入要查找的书籍：");
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

        book = bookList.getBook(i);
        System.out.println(book);
        System.out.println("找到此书");
   }
}
