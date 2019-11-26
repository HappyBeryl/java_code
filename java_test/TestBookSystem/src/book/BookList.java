package book;

public class BookList {
    Book[] books = new Book[10];
    public int UseSize = 0;
    public BookList() {
        books[0] = new Book("三国演义","罗贯中",100,"小说");
        books[1] = new Book("水浒传","施耐庵",99,"小说");
        books[2] = new Book("红楼梦","曹雪芹",101,"小说");
        this.UseSize = 3;
    }
    public int getUseSize() {
        return UseSize;
    }

    public void setUseSize(int useSize) {
        UseSize = useSize;
    }

    public void setBooks(int pos, Book book) {
        books[pos] = book;
    }
}
