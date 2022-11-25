package com.byronajin.androidtesting.home

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.byronajin.androidtesting.pokemonList.PokemonListActivity
import com.byronajin.androidtesting.registration.RegisterUserActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.byronajin.androidtesting.R

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkRegisterButton() {
        val targetContext = ApplicationProvider.getApplicationContext<Context>()
        val buttonText: String = targetContext.resources.getString(R.string.list)
        onView(withText(buttonText)).check(matches(isDisplayed()))
    }

    @Test
    fun checkPokemonListButton() {
        val targetContext = ApplicationProvider.getApplicationContext<Context>()
        val buttonText: String = targetContext.resources.getString(R.string.registration)
        onView(withText(buttonText)).check(matches(isDisplayed()))
    }

    @Test
    fun checkRegisterButtonClick() {
        Intents.init()
        onView(withId(R.id.registrationButton))
            .perform(click())

        intended(hasComponent(RegisterUserActivity::class.java.name))
        Intents.release()
    }

    @Test
    fun checkPokemonListButtonClick() {
        Intents.init()
        onView(withId(R.id.listButton))
            .perform(click())

        intended(hasComponent(PokemonListActivity::class.java.name))
        Intents.release()
    }

}