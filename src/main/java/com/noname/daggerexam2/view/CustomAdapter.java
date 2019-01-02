package com.noname.daggerexam2.view;

import androidx.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.noname.daggerexam2.R;
import com.noname.daggerexam2.databinding.RecyclerItemBinding;
import com.noname.daggerexam2.repository.CustomRoom;

import javax.inject.Inject;

public class CustomAdapter extends PagedListAdapter<CustomRoom, RecyclerView.ViewHolder> {

    @Inject
    public CustomAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof CustomViewHolder){
            ((CustomViewHolder) holder).getRecyclerItemBinding().setObserver(new CustomObserver(getItem(position)));
        }
    }

    private static final DiffUtil.ItemCallback<CustomRoom> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<CustomRoom>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull CustomRoom oldModel, @NonNull CustomRoom newModel) {
                    // User properties may have changed if reloaded from the DB, but ID is fixed
                    return (oldModel.getId().equals(newModel.getId()));
                }
                @Override
                public boolean areContentsTheSame(
                        @NonNull CustomRoom oldModel, @NonNull CustomRoom newModel) {
                    // NOTE: if you use equals, your object must properly override Object#equals()
                    // Incorrectly returning false here will result in too many animations.
                    return oldModel.equals(newModel);
                }
            };
    
    static class CustomViewHolder extends RecyclerView.ViewHolder {

        private RecyclerItemBinding recyclerItemBinding;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerItemBinding = DataBindingUtil.bind(itemView);
        }

        public RecyclerItemBinding getRecyclerItemBinding() {
            return recyclerItemBinding;
        }
    }
}
