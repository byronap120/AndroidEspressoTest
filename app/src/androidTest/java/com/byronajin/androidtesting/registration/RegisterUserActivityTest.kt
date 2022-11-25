package com.byronajin.androidtesting.registration

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.times
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.byronajin.androidtesting.R
import com.byronajin.androidtesting.pokemonList.PokemonListActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class RegisterUserActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(RegisterUserActivity::class.java)

    @Test
    fun checkPokemonListButton() {
        val targetContext = ApplicationProvider.getApplicationContext<Context>()
        val buttonText: String = targetContext.resources.getString(R.string.registration)
        Espresso.onView(ViewMatchers.withText(buttonText))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun checkUserNameEditText() {
        Espresso.onView(ViewMatchers.withId(R.id.editTextTextPersonName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun checkEmailEditText() {
        Espresso.onView(ViewMatchers.withId(R.id.editTextTextEmailAddress))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testUserDoesNotMoveToPokemonList() {
        // Given
        Espresso.onView(ViewMatchers.withId(R.id.editTextTextPersonName))
            .perform(typeText("UserName"))

        Espresso.onView(ViewMatchers.withId(R.id.editTextTextEmailAddress))
            .perform(typeText("UserName@gmail.com"))

        // Then
        Intents.init()
        intended(hasComponent(PokemonListActivity::class.java.name), times(0))
        Intents.release()
    }

    @Test
    fun testUserMoveToPokemonList() {
        // Given
        Espresso.onView(ViewMatchers.withId(R.id.editTextTextPersonName))
            .perform(typeText("UserName"))

        Espresso.onView(ViewMatchers.withId(R.id.editTextTextEmailAddress))
            .perform(typeText("UserName@gmail.com"))

        // When
        Intents.init()
        Espresso.onView(ViewMatchers.withId(R.id.registerUserButton))
            .perform(ViewActions.click())

        // Then
        intended(hasComponent(PokemonListActivity::class.java.name), times(1))
        Intents.release()
    }


}