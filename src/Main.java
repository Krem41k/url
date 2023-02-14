import day.Day;
import exception.MyException;
import page.PageWork;

public class Main {
    public static void main(String[] args) {
        Day today = new Day();
        Day yesterday = new Day();

        yesterday.put("url1", "html1");
        yesterday.put("url2", "html22");
        yesterday.put("url3", "html3");
        yesterday.put("url4", "html4");
        today.put("url8", "html8");
        today.put("url2", "html2");
        today.put("url3", "html32");
        today.put("url5", "html5");
        today.put("url7", "html7");

        System.out.println("Здравствуйте, дорогая и.о. секретаря\n" +
                "За последние сутки во вверенных Вам сайтах произошли следующие изменения:");
        System.out.print("Исчезли следующие страницы: ");
        try {
            for (String s :
                    PageWork.deletedPages(yesterday, today)) {
                System.out.print(s + " ");
            }
            System.out.print("\nПоявились следующие новые страницы: ");
            for (String s :
                    PageWork.createdPages(yesterday, today)) {
                System.out.print(s + " ");
            }

            System.out.print("\nИзменились следующие страницы: ");
            for (String s :
                    PageWork.changedPages(yesterday, today)) {
                System.out.print(s + " ");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }


    }
}