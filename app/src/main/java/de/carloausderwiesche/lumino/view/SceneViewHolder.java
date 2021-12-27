package de.carloausderwiesche.lumino.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.carloausderwiesche.lumino.R;

public class SceneViewHolder extends RecyclerView.ViewHolder {
    private final TextView sceneItemView;

    public SceneViewHolder(@NonNull View itemView) {
        super(itemView);
        this.sceneItemView = itemView.findViewById(R.id.text_view_title);
    }

    public void bind(String text) {
        sceneItemView.setText(text);
    }

    public static SceneViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scene_item, parent, false);
        return new SceneViewHolder(view);
    }
}
