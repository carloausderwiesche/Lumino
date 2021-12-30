package de.carloausderwiesche.lumino.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.carloausderwiesche.lumino.MainActivity;
import de.carloausderwiesche.lumino.R;
import de.carloausderwiesche.lumino.controller.flash.Flash;
import de.carloausderwiesche.lumino.data.Scene;

public class SceneViewHolder extends RecyclerView.ViewHolder {
    private final TextView sceneItemView;
    private final TextView sceneDescription;
    private final ImageView sceneIcon;

    public SceneViewHolder(@NonNull View itemView) {
        super(itemView);
        this.sceneItemView = itemView.findViewById(R.id.scene_title);
        this.sceneDescription = itemView.findViewById(R.id.scene_description);
        this.sceneIcon = itemView.findViewById(R.id.sceneIcon);
        itemView.setSelected(false);
    }

    public void bind(Scene scene) {
        sceneItemView.setText(scene.getTitle());
        sceneDescription.setText(scene.getDescription());
        sceneIcon.setImageResource(scene.getIcon());

        itemView.setOnClickListener(v -> {
            Flash flash = Flash.getFlashComponent();
            flash.setScene(scene);
            itemView.setSelected(true);
        });
    }

    public static SceneViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scene_row, parent, false);
        return new SceneViewHolder(view);
    }
}
