package com.example.krzysiekbielicki.mylapplication.kuba.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krzysiekbielicki.mylapplication.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ViewHolder> {
	private final LayoutInflater layoutInflater;
	private String[] dataset;
	private RecyclerViewClickListener<ViewHolder> listener;

	public ExampleAdapter(Context context, String[] dataset) {
		layoutInflater = LayoutInflater.from(context);
		this.dataset = dataset;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
		View view = layoutInflater.inflate(R.layout.collection_item, parent, false);
		view.setClipToOutline(true);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		viewHolder.image.setImageResource(R.drawable.ic_launcher);
		viewHolder.text.setText(dataset[position]);
	}

	@Override
	public int getItemCount() {
		return dataset.length;
	}

	public void setListener(RecyclerViewClickListener<ViewHolder> listener) {
		this.listener = listener;
	}

	public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		@InjectView(R.id.image)
		public ImageView image;

		@InjectView(R.id.text)
		public TextView text;

		public ViewHolder(View view) {
			super(view);
			view.setOnClickListener(this);
			ButterKnife.inject(this, view);
		}

		@Override
		public void onClick(View view) {
			listener.onItemClick(getPosition(), this, getItemId());
		}
	}
}
