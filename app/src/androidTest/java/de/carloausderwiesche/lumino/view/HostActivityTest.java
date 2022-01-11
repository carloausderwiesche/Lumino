package de.carloausderwiesche.lumino.view;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.carloausderwiesche.lumino.R;
import de.carloausderwiesche.lumino.view.host.HostActivity;

@RunWith(AndroidJUnit4.class)
public class HostActivityTest {

    @Rule
    public ActivityScenarioRule<HostActivity> activityScenarioRule = new ActivityScenarioRule<HostActivity>(HostActivity.class);

    @Test
    public void clickStartButton_changesText(){
        onView(withId(R.id.btn_hostStartScene))
                .perform(click());
        onView(withId(R.id.btn_hostStartScene))
                .check(matches(withText("STOP")));
    }

    @Test
    public void selectSceneTest(){
        onView(withId(R.id.btn_hostSelectScene))
                .perform(click());

        onView(withId(R.id.recycler_view_scenes))
                .perform(RecyclerViewActions.actionOnItemAtPosition(4, click()))
                .perform(pressBack());

        onView(withId(R.id.selectedScene_host))
                .check(matches(withText("SOS")));
    }
}