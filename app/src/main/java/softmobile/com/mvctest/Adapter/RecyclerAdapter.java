package softmobile.com.mvctest.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import softmobile.com.mvctest.Bean.Book;
import softmobile.com.mvctest.R;

/**
 * recyclerview的adapter
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context m_context;
    List<Book> m_list;

    public RecyclerAdapter(Context context, List<Book> list)
    {
        m_context = context;
        m_list = list;
    }

    //初始化元件，綁定viewholder中的元件
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(m_context).inflate(R.layout.view_recycler, viewGroup, false);

        //把建立好的view丟進viewholder
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.tvName = view.findViewById(R.id.tv_item);
        viewHolder.ivBook = view.findViewById(R.id.iv_book);
        return viewHolder;
    }

    //綁定數據，填入資料囉
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Book book = m_list.get(i);
        viewHolder.tvName.setText(book.getName());
        viewHolder.ivBook.setImageResource(book.getImg());
    }


    @Override
    public int getItemCount() {
        if(null != m_list)
        {
            return m_list.size();
        }
        return 0;
    }


    //在recyclerview裡面，繼承RecyclerView的ViewHolder是必要的
    class ViewHolder extends RecyclerView.ViewHolder
    {
        //宣告有哪些元件
        public TextView tvName;
        public ImageView ivBook;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
