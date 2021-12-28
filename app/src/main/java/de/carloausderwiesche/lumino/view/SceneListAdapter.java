package de.carloausderwiesche.lumino.view;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import de.carloausderwiesche.lumino.data.Scene;

public class SceneListAdapter extends ListAdapter<Scene, SceneViewHolder> {

    public SceneListAdapter(@NonNull DiffUtil.ItemCallback<Scene> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public SceneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return SceneViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(SceneViewHolder holder, int position) {
        Scene current = getItem(position);
        holder.bind(current.getTitle());
    }

    static class SceneDiff extends DiffUtil.ItemCallback<Scene> {

        @Override
        public boolean areItemsTheSame(@NonNull Scene oldItem, @NonNull Scene newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Scene oldItem, @NonNull Scene newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    }
}
