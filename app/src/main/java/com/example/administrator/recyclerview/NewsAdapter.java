package com.example.administrator.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int TITLE_VIEW = 1;   //布局的头
    private final int CONTENT_VIEW = 2; //布局的子内容项
	private final int EMPTY_VIEW = 3;   

    private Context context;
    private List<News> list;

    public NewsAdapter(Context context, List<News> list) {
        this.context = context;
        this.list = list;
    }
	
	//多布局的管理
    @Override
    public int getItemViewType(int position) {
        if(list.get(position).getKind() == 1){
            return TITLE_VIEW;
        } else if(list.get(position).getKind() == 2){
            return CONTENT_VIEW;
        } else {
            return super.getItemViewType(position);
        }
    }

	//引入多布局
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == TITLE_VIEW){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.total, parent, false);
            return new TitleViewHolder(view);
        } else if(viewType == CONTENT_VIEW){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1, parent, false);
            return new ContentViewHolder(view);
        } else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
            return new EmptyViewHolder(view);
        }
    }


	//多布局内容的初始化和数据绑定
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if(holder instanceof EmptyViewHolder){
            EmptyViewHolder viewHolder = (EmptyViewHolder)holder;
            viewHolder.im1.setImageResource(R.drawable.background2);
            viewHolder.im2.setImageResource(R.drawable.background2);
            viewHolder.im3.setImageResource(R.drawable.background2);
        } else if(holder instanceof ContentViewHolder){
            ContentViewHolder viewHolder = (ContentViewHolder)holder;
            viewHolder.bt1.setText(list.get(position).getString());
            viewHolder.bt2.setText(list.get(position).getString());
            viewHolder.bt3.setText(list.get(position).getString());

        } else if(holder instanceof TitleViewHolder){
            TitleViewHolder viewHolder = (TitleViewHolder)holder;
            viewHolder.tv1.setText("标题");

        }
    }

	//总共有多少种布局
    @Override
    public int getItemCount() {
        return list.size();
    }

    class TitleViewHolder extends RecyclerView.ViewHolder{
        public final TextView tv1;
        public TitleViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
        }
    }

    class ContentViewHolder extends RecyclerView.ViewHolder{
        public final Button bt1,bt2,bt3;
        public ContentViewHolder(View itemView) {
            super(itemView);
            bt1 = (Button) itemView.findViewById(R.id.bt1);
            bt2 = (Button) itemView.findViewById(R.id.bt2);
            bt3 = (Button) itemView.findViewById(R.id.bt3);
        }
    }

    class EmptyViewHolder extends RecyclerView.ViewHolder{
        public final ImageView im1,im2,im3;
        public EmptyViewHolder(View itemView) {
            super(itemView);
            im1 = (ImageView) itemView.findViewById(R.id.im1);
            im2 = (ImageView) itemView.findViewById(R.id.im2);
            im3 = (ImageView) itemView.findViewById(R.id.im3);
        }
    }

}