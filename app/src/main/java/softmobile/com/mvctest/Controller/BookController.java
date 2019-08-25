package softmobile.com.mvctest.Controller;

import java.util.List;

import softmobile.com.mvctest.Bean.Book;
import softmobile.com.mvctest.Model.BookModel;
import softmobile.com.mvctest.R;

/**
 * 控制層/controller層
 * 調用model層方法，加入業務邏輯，對外揭露接口
 *
 */
public class BookController {
    private BookModel model;

    public BookController()
    {
        model = new BookModel();
    }

    //成功加入callback接口
    public interface onAddBookListener
    {
        void onComplete();
    }

    //成功刪除callback接口
    public interface onDeleteBookListener
    {
        void onComplete();
    }

    //新增書籍
    public void add(onAddBookListener listener)
    {
        model.addBook("JavaWeb从入门到精通", R.drawable.baseline_bookmark_black_18dp);
        if(null != listener)
        {
            listener.onComplete();
        }
    }

    //刪除書籍
    public void delete(onDeleteBookListener listener)
    {
        model.deleteBook();
        if(null != listener)
        {
            listener.onComplete();
        }
    }

    //查詢所有書籍
    public List<Book> query()
    {
        return model.query();
    }

}
