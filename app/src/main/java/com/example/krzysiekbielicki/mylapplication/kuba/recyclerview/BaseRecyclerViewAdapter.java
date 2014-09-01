package com.example.krzysiekbielicki.mylapplication.kuba.recyclerview;

import android.support.v7.widget.RecyclerView;

import java.util.List;

public abstract class BaseRecyclerViewAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
	private List<T> items;

	protected BaseRecyclerViewAdapter(List<T> items) {
		this.items = items;
	}

	@Override
	public int getItemCount() {
		return items.size();
	}

	public T getItem(int position) {
		return items.get(position);
	}

	public void add(T item, int position) {
		items.add(position, item);
		notifyItemInserted(position);
	}

	public void remove(int position) {
		items.remove(position);
		notifyItemRemoved(position);
	}
}
