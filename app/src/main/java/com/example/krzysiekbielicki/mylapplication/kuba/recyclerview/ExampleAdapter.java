package com.example.krzysiekbielicki.mylapplication.kuba.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krzysiekbielicki.mylapplication.R;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ExampleAdapter extends BaseRecyclerViewAdapter<String, ExampleAdapter.ViewHolder> {
	private final LayoutInflater layoutInflater;
	private RecyclerViewClickListener<ViewHolder> listener;
    private int layoutResourceId;

	public ExampleAdapter(Context context, String[] dataset, boolean useCardLayout) {
		super(new ArrayList<String>(Arrays.asList(dataset)));
		layoutInflater = LayoutInflater.from(context);

        layoutResourceId = useCardLayout ? R.layout.card_collection_item : R.layout.collection_item;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
		View view = layoutInflater.inflate(layoutResourceId, parent, false);
		view.setClipToOutline(true);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		viewHolder.image.setImageResource(R.drawable.ic_launcher);
		viewHolder.text.setText(getItem(position));
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
