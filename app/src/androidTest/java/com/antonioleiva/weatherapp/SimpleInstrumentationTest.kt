package com.antonioleiva.weatherapp

import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.antonioleiva.weatherapp.ui.activities.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.junit.Rule
import org.junit.Test

class SimpleInstrumentationTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test fun itemClickNavigatesToDetail() {
        onView(withId(R.id.forecastList)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.weatherDescription))
                .check(matches(isAssignableFrom(TextView::class.java)))
    }

    @Test fun modifyZipCodeChangesToolbarTitle() {
        openActionBarOverflowOrOptionsMenu(activityRule.activity)
        onView(withText(R.string.settings)).perform(click())
        onView(withId(R.id.cityCode)).perform(replaceText("94301"))
        pressBack()
        onView(isAssignableFrom(Toolbar::class.java))
                .check(matches(withToolbarTitle(`is`("Palo Alto (US)"))))
    }

    private fun withToolbarTitle(textMatcher: Matcher<CharSequence>): Matcher<Any> =
            object : BoundedMatcher<Any, Toolbar>(Toolbar::class.java) {

                override fun matchesSafely(toolbar: Toolbar): Boolean =
                        textMatcher.matches(toolbar.title)

                override fun describeTo(description: Description) {
                    description.appendText("with toolbar title: ")
                    textMatcher.describeTo(description)
                }
            }
}

class SimpleInstrumentationTest2 {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test fun itemClickNavigatesToDetail() {
        onView(withId(R.id.forecastList)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.weatherDescription))
                .check(matches(isAssignableFrom(TextView::class.java)))
    }

    @Test fun modifyZipCodeChangesToolbarTitle() {
        openActionBarOverflowOrOptionsMenu(activityRule.activity)
        onView(withText(R.string.settings)).perform(click())
        onView(withId(R.id.cityCode)).perform(replaceText("94301"))
        pressBack()
        onView(isAssignableFrom(Toolbar::class.java))
                .check(matches(withToolbarTitle(`is`("Palo Alto (US)"))))
    }

    private fun withToolbarTitle(textMatcher: Matcher<CharSequence>): Matcher<Any> =
            object : BoundedMatcher<Any, Toolbar>(Toolbar::class.java) {

                override fun matchesSafely(toolbar: Toolbar): Boolean =
                        textMatcher.matches(toolbar.title)

                override fun describeTo(description: Description) {
                    description.appendText("with toolbar title: ")
                    textMatcher.describeTo(description)
                }
            }
}
