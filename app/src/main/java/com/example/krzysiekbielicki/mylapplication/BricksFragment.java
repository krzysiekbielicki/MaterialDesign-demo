package com.example.krzysiekbielicki.mylapplication;

import android.app.ActivityOptions;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class BricksFragment extends Fragment implements BricksAdapter.RecyclerViewClickListener {

    private static final String ARG_SECTION_NUMBER = "section_number";

    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;

    public static BricksFragment newInstance(int sectionNumber) {
        BricksFragment fragment = new BricksFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public BricksFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_collection, container, false);
        ButterKnife.inject(this, rootView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLongClickable(true);
        BricksAdapter adapter = new BricksAdapter(getActivity());
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position, BricksAdapter.ItemViewHolder viewHolder, long itemId) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        viewHolder.image.setViewName("image");
        ActivityOptions options = ActivityOptions
                .makeSceneTransitionAnimation(getActivity(), viewHolder.image, "image");
        startActivity(intent, options.toBundle());
    }
}
