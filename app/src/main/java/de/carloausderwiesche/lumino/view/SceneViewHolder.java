package de.carloausderwiesche.lumino.view;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.carloausderwiesche.lumino.R;

public class SceneViewHolder extends RecyclerView.ViewHolder {
    private final TextView sceneItemView;
    private final TextView sceneDescription;
    private final ImageView sceneIcon;

    public SceneViewHolder(@NonNull View itemView) {
        super(itemView);
        this.sceneItemView = itemView.findViewById(R.id.scene_title);
        this.sceneDescription = itemView.findViewById(R.id.scene_description);
        this.sceneIcon = itemView.findViewById(R.id.sceneIcon);
    }

    public void bind(String title, String description, int icon) {
        sceneItemView.setText(title);
        sceneDescription.setText(description);
        sceneIcon.setImageResource(icon);
    }

    public static SceneViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scene_row, parent, false);
        return new SceneViewHolder(view);
    }
}
