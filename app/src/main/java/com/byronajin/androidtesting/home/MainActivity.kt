package com.byronajin.androidtesting.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.byronajin.androidtesting.databinding.ActivityMainBinding
import com.byronajin.androidtesting.pokemonList.PokemonListActivity
import com.byronajin.androidtesting.registration.RegisterUserActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()

        binding.listButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, PokemonListActivity::class.java))
        }

        binding.registrationButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, RegisterUserActivity::class.java))
        }
    }
}