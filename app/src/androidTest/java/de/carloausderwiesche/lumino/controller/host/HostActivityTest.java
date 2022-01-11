package de.carloausderwiesche.lumino.controller.host;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.carloausderwiesche.lumino.R;

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

}