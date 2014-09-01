package com.example.krzysiekbielicki.mylapplication.kuba.recyclerview;

import android.support.v7.widget.RecyclerView;

public interface RecyclerViewClickListener<T extends RecyclerView.ViewHolder> {
	void onItemClick(int position, T viewHolder, long itemId);
}
