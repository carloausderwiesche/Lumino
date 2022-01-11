package de.carloausderwiesche.lumino.controller;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.assertEquals;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.carloausderwiesche.lumino.R;
import de.carloausderwiesche.lumino.controller.flash.PlayingLightScene;
import de.carloausderwiesche.lumino.view.host.HostActivity;

@RunWith(AndroidJUnit4.class)
public class PlayingLightSceneTest {

    @Rule
    public ActivityScenarioRule<HostActivity> activityScenarioRule = new ActivityScenarioRule<HostActivity>(HostActivity.class);


    @Test
    public void selectSceneTest(){
        onView(withId(R.id.btn_hostSelectScene))
                .perform(click());

        onView(withId(R.id.recycler_view_scenes))
                .perform(RecyclerViewActions.actionOnItemAtPosition(4, click()))
                .perform(pressBack());


        PlayingLightScene playingLightScene = PlayingLightScene.getPlayingLightScene();
        assertEquals("SOS" ,playingLightScene.getCurrentScene().getTitle());
    }
}