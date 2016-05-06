package com.zss.learning_ideas.recyclerview;

/**
 * Created by zhaoshanshan on 16/5/5.
 */
public interface ItemTouchHelperAdapter {
    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
