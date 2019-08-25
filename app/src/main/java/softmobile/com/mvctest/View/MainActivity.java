package softmobile.com.mvctest.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

import softmobile.com.mvctest.Adapter.RecyclerAdapter;
import softmobile.com.mvctest.Bean.Book;
import softmobile.com.mvctest.Controller.BookController;
import softmobile.com.mvctest.R;

/**
 * 視圖層/view層
 * 調用controller層方法
 * 將外部需求送進去給controller層
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private BookController bookController;

    //recyclerview
    private RecyclerView recyclerView;
    private RecyclerView.Adapter m_adapter;
    private RecyclerView.LayoutManager m_layoutManager;

    private Button m_btnAdd;
    private Button m_btnDelete;

    private List<Book> m_alBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookController = new BookController();
        m_alBook = bookController.query();

        initView();

    }

    private void initView() {
        recyclerView = findViewById(R.id.recycle_view);
        m_btnAdd = findViewById(R.id.btn_add);
        m_btnDelete = findViewById(R.id.btn_delete);

        m_btnAdd.setOnClickListener(this);
        m_btnDelete.setOnClickListener(this);

        //如果變更內容不會影響到recyclerView的layout大小的話
        //加上這條可以增進效能
        recyclerView.setHasFixedSize(true);

        //指定adapter
        m_adapter = new RecyclerAdapter(this, m_alBook);
        recyclerView.setAdapter(m_adapter);

        //要設定layoutmanager，不然沒畫面！
        m_layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(m_layoutManager);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            //新增
            case R.id.btn_add:
                bookController.add(new BookController.onAddBookListener() {
                    @Override
                    public void onComplete() {
                        m_adapter.notifyDataSetChanged();
                    }
                });
                break;

            //刪除
            case R.id.btn_delete:
                bookController.delete(new BookController.onDeleteBookListener() {
                    @Override
                    public void onComplete() {
                        m_adapter.notifyDataSetChanged();
                    }
                });
                break;
        }
    }
}
