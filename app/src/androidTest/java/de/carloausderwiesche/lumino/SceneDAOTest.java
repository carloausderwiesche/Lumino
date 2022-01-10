package de.carloausderwiesche.lumino;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import de.carloausderwiesche.lumino.data.Scene;
import de.carloausderwiesche.lumino.data.SceneDAO;
import de.carloausderwiesche.lumino.data.SceneDatabase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.annotation.Nullable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;



@RunWith(AndroidJUnit4.class)
public class SceneDAOTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();


    private SceneDAO sceneDAO;
    private SceneDatabase sceneDatabase;

    @Before
    public void createDatabase(){
        Context context = ApplicationProvider.getApplicationContext();
        sceneDatabase = Room.inMemoryDatabaseBuilder(context, SceneDatabase.class)
                .allowMainThreadQueries()
                .build();
        sceneDAO = sceneDatabase.sceneDAO();
    }

    @After
    public void closeDatabase(){
        sceneDatabase.close();
    }

    @Test
    public void insert() throws InterruptedException {
        Scene scene = new Scene("Shine", "Continuous light", R.drawable.sceneicon_torch, "11", 0);
        sceneDAO.insert(scene);
        List<Scene> allScenes = LiveDataTestUtil.getValue(sceneDAO.getAllScenes());
        assertEquals(allScenes.get(0).getTitle(), scene.getTitle());
    }

    @Test
    public void getAllScenes() throws InterruptedException {
        Scene scene1 = new Scene("Shine", "Continuous light", R.drawable.sceneicon_torch, "11", 0);
        Scene scene2 = new Scene("Shine", "Continuous light", R.drawable.sceneicon_torch, "11", 0);
        Scene scene3 = new Scene("blink fast", "fast blinking", R.drawable.sceneicon_party, "10", 30);
        sceneDAO.insert(scene1);
        sceneDAO.insert(scene2);
        sceneDAO.insert(scene3);

        List<Scene> allScenes = LiveDataTestUtil.getValue(sceneDAO.getAllScenes());
        assertEquals(allScenes.get(0).getTitle(), scene1.getTitle());
        assertEquals(allScenes.get(1).getTitle(), scene2.getTitle());
        assertEquals(allScenes.get(2).getTitle(), scene3.getTitle());


    }

    @Test
    public void deleteAll() {
    }

}