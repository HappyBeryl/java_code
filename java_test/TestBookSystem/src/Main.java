import book.BookList;
import user.Admin;
import user.Normal;
import user.User;
import java.util.Scanner;

public class  Main {
    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name = scanner.nextLine();
        System.out.println("请输入你的身份（1-管理员，0-普通用户）：");
        int who = scanner.nextInt();
        if (who == 1) {
            return new Admin(name);
        } else {
            return new Normal(name);
        }
    }
    public static void main(String[] args) {
        //准备图书
        BookList bookList = new BookList();
        //登录、返回1对象
        User user = login();
        int choice = user.menu();
        user.doOperations(choice,bookList);
    }
}
