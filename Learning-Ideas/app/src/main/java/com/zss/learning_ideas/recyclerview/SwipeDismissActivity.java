package com.zss.learning_ideas.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.zss.learning_ideas.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshanshan on 16/5/5.
 */
public class SwipeDismissActivity extends Activity implements ItemDragListener {
    private RecyclerView mRecyclerView;
    private List<String> mData;
    private ListAdapter mAdapter;
    private SimpleTouchHelperCallback mSimpleTouchHelperCallback;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_dismiss);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new ListAdapter(mData);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        mSimpleTouchHelperCallback = new SimpleTouchHelperCallback(mAdapter);
        mItemTouchHelper = new ItemTouchHelper(mSimpleTouchHelperCallback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        mAdapter.setDragListener(this);
//        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
//
//            @Override
//            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
//                return false;
//            }
//
//            @Override
//            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//                int position = viewHolder.getAdapterPosition();
//                mData.remove(position);
//                mAdapter.notifyItemRemoved(position);
//            }
//        }).attachToRecyclerView(mRecyclerView);
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mData.add("hahahahahahha" + i);
        }

    }

    @Override
    public void dragStart(RecyclerView.ViewHolder viewHolder) {
        //用一个控件来控制滑动删除
        mItemTouchHelper.startDrag(viewHolder);
    }
}
