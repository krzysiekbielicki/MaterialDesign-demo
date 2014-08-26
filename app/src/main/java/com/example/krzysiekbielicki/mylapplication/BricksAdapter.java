package com.example.krzysiekbielicki.mylapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class BricksAdapter extends RecyclerView.Adapter {
    public static final float SCALE = 1.01f;
    private final LayoutInflater layoutInflater;

    private RecyclerViewClickListener listener;

    public BricksAdapter(Context context) {
        super();
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = layoutInflater.inflate(R.layout.collection_item, parent, false);
        view.setClipToOutline(true);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ItemViewHolder holder = (ItemViewHolder) viewHolder;
        holder.image.setImageResource(R.drawable.ic_launcher);
        holder.text.setText("Position " + position);
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    public void setListener(RecyclerViewClickListener listener) {
        this.listener = listener;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @InjectView(R.id.image)
        public ImageView image;

        @InjectView(R.id.text)
        public TextView text;

        public ItemViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            ButterKnife.inject(this, view);
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(getPosition(), this, getItemId());
        }
    }

    public interface RecyclerViewClickListener {
        void onItemClick(int position, ItemViewHolder viewHolder, long itemId);
    }
}
