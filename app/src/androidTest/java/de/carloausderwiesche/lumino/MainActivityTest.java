package de.carloausderwiesche.lumino;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void clickHostButton(){
        onView(withId(R.id.btn_hostSession))
                .perform(click());

        onView(withId(R.id.hostView))
                .check(matches(isDisplayed()));
    }

    @Test
    public void clickClientButton(){
        onView(withId(R.id.btn_joinSession))
                .perform(click());

        onView(withId(R.id.bluetoothFindDevicesView))
                .check(matches(isDisplayed()));
    }
}