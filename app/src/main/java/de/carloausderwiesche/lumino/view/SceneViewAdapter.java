package de.carloausderwiesche.lumino.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.carloausderwiesche.lumino.R;
import de.carloausderwiesche.lumino.data.Scene;
/*
public class SceneViewAdapter extends RecyclerView.Adapter<SceneViewAdapter.SceneHolder> {
    private List<Scene> scenes = new ArrayList<>();

    @NonNull
    @Override
    public SceneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scene_item, parent, false);
        return new SceneHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SceneHolder holder, int position) {
        Scene currentScene = scenes.get(position);
        holder.textViewID.setText(String.valueOf(currentScene.getId()));
        holder.textViewTitle.setText(currentScene.getTitle());
        holder.textViewDescription.setText(currentScene.getDescription());
    }

    @Override
    public int getItemCount() {
        return scenes.size();
    }

    public void setScenes(List<Scene> scenes){
        this.scenes = scenes;
        notifyDataSetChanged();
    }

    class SceneHolder extends RecyclerView.ViewHolder{
        private TextView textViewID;
        private TextView textViewTitle;
        private TextView textViewDescription;

        public SceneHolder(@NonNull View itemView) {
            super(itemView);
            textViewID = itemView.findViewById(R.id.text_view_description);
            //textViewTitle = itemView.findViewById(R.id.text_view_title);
            //textViewDescription = itemView.findViewById(R.id.text_view_description);
        }
    }
}

 */
