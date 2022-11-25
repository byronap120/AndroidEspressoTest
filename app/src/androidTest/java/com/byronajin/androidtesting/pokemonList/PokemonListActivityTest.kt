package com.byronajin.androidtesting.pokemonList

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.byronajin.androidtesting.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class PokemonListActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(PokemonListActivity::class.java)

    @Test
    fun checkLoaderExist() {
        onView(withId(R.id.pokemonLoader)).check(ViewAssertions.matches(isDisplayingAtLeast(1)))
    }

    @Test
    fun checkPokemonListExist() {
        onView(withId(R.id.pokemonRecyclerView)).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun scrollToPosition() {
        onView(withId(R.id.pokemonRecyclerView)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5)
        )
    }

}