package de.carloausderwiesche.lumino.view;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.startsWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.carloausderwiesche.lumino.R;
import de.carloausderwiesche.lumino.view.client.ClientActivity;

@RunWith(AndroidJUnit4.class)
public class ClientActivityTest {

    @Rule
    public ActivityScenarioRule<ClientActivity> activityScenarioRule = new ActivityScenarioRule<ClientActivity>(ClientActivity.class);

    @Test
    public void connectTest(){
        onData(hasToString(startsWith("Chef")))
            .perform(click());

        onView(withId(R.id.clientView))
                .check(matches(isDisplayed()));

    }

}