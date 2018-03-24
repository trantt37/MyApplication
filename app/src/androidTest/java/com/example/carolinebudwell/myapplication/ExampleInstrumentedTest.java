package com.example.carolinebudwell.myapplication;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.carolinebudwell.myapplication", appContext.getPackageName());
    }
    @Rule
    public ActivityTestRule<MainActivity> mButtonTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);
    @Test
    public void MainActivityButtonSwitchToEnterValuesActivity() throws Exception{
        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.button3))
                .check(matches(isDisplayed()));
        onView(withId(R.id.editText))
                .check(matches(isDisplayed()));
        onView(withId(R.id.editText2))
                .check(matches(isDisplayed()));
        onView(withId(R.id.textView3))
                .check(matches(isDisplayed()));
        onView(withId(R.id.textView))
                .check(matches(isDisplayed()));
    }
}
