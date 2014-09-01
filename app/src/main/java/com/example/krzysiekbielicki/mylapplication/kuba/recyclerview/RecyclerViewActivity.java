package com.example.krzysiekbielicki.mylapplication.kuba.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.krzysiekbielicki.mylapplication.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class RecyclerViewActivity extends Activity implements RecyclerViewClickListener<ExampleAdapter.ViewHolder> {
	private static final String LOREM_IPSUM = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem " +
			"Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of " +
			"type and scrambled it to make a type specimen book. It has survived not only five centuries, " +
			"but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s " +
			"with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing " +
			"software like Aldus PageMaker including versions of Lorem Ipsum.";

	@InjectView(R.id.recyclerView)
	RecyclerView recyclerView;

	private ExampleAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycler_view);

		ButterKnife.inject(this);

		// improve performance if you know that changes in content
		// do not change the size of the RecyclerView
		recyclerView.setHasFixedSize(true);

		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
		recyclerView.setLayoutManager(layoutManager);

		adapter = new ExampleAdapter(this, LOREM_IPSUM.split(" "));
		adapter.setListener(this);
		recyclerView.setAdapter(adapter);

		recyclerView.setItemAnimator(new DefaultItemAnimator());
		recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST));
	}

	@OnClick(R.id.addItem)
	void onAddItemButtonClick() {
		adapter.add("Item " + adapter.getItemCount(), 1);
	}

	@OnClick(R.id.removeItem)
	void onRemoveItemButtonClick() {
		if (adapter.getItemCount() >= 0) {
			adapter.remove(0);
		}
	}

	@Override
	public void onItemClick(int position, ExampleAdapter.ViewHolder viewHolder, long itemId) {
		Toast.makeText(this, "Item " + position + " clicked", Toast.LENGTH_SHORT).show();
	}
}
