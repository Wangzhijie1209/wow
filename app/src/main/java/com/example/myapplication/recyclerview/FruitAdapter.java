package com.example.myapplication.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;

    /**
     * 构造函数,用于把要展示的数据源传进来,并赋值给一个全局变量mFruitList,后续的操作都将在这个数据源的基础上进行
     *
     * @param mFruitList
     */
    public FruitAdapter(List<Fruit> mFruitList) {
        this.mFruitList = mFruitList;
    }


    /**
     * onCreateViewHolder()方法是用于创建ViewHolder实例的,我们在这个方法中将fruit_item布局加载进来,然后创建一个
     * ViewHolder实例,并把加载出来的布局传入到构造函数当中,最后将viewHolder的实例返回
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        
        holder.image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(), "you clicked view" + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(), "you clicked image", Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    /**
     * 绑定数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.image_view.setImageResource(fruit.getImageId());
        holder.text_view.setText(fruit.getName());
    }

    /**
     * 用于告诉RecyclerView一共有多少子项,直接返回数据源的长度即可
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    /**
     * 定义了一个内部类ViewHolder,继承至RecyclerView.ViewHolder,ViewHolder的构造函数中要传入一个View参数,
     * 这个参数通常就是RecyclerView子项的最外层布局,也就是Item布局
     * 通过findViewById()方法来获取布局中的空间
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image_view;
        private final TextView text_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_view = itemView.findViewById(R.id.text_view);
            image_view = itemView.findViewById(R.id.image_view);
        }
    }
}
