package de.carloausderwiesche.lumino.view.scene;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import de.carloausderwiesche.lumino.R;

public class NewSceneActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "de.carloausderwiesche.lumino.REPLY";

    private EditText mEditSceneView;
    private EditText mEditSceneViewPattern;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_scene);
        mEditSceneView = findViewById(R.id.edit_scene_title);
        mEditSceneViewPattern = findViewById(R.id.edit_scene_pattern);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditSceneView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = mEditSceneView.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, word);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}