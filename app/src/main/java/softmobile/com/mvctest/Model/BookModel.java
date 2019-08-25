package softmobile.com.mvctest.Model;

import java.util.ArrayList;
import java.util.List;

import softmobile.com.mvctest.Bean.Book;
import softmobile.com.mvctest.R;

/**
 * 模型層/model層
 * 對本地數據庫的操作or打API請求網路資料
 */
public class BookModel {
    private static List<Book> list = new ArrayList<>(); //用來模擬本地的數據庫

    //先建立本地數據庫資料，用來模擬
    static
    {
        list.add(new Book("Java从入门到精通", R.drawable.baseline_bookmark_black_18dp));
        list.add(new Book("Android从入门到精通", R.drawable.baseline_library_books_black_18dp));
        list.add(new Book("Java从入门到精通", R.drawable.baseline_bookmark_black_18dp));
        list.add(new Book("Android从入门到精通", R.drawable.baseline_library_books_black_18dp));
    }

    //新增書籍
    public void addBook(String name, int image)
    {
        list.add(new Book(name, image));
    }

    //刪除書籍
    public void deleteBook()
    {
        list.remove(list.size()-1); //刪除最後一筆
    }

    //查詢所有書籍
    public List<Book> query()
    {
        return list;
    }
}
