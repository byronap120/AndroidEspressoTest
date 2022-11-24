package com.byronajin.androidtesting.registration

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.byronajin.androidtesting.R
import com.byronajin.androidtesting.databinding.ActivityRegisterUserBinding
import com.byronajin.androidtesting.pokemonList.PokemonListActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterUserBinding
    val viewModel: RegisterUserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()
        initObservers()

        binding.registerUserButton.setOnClickListener {
            viewModel.registerUser(
                binding.editTextTextPersonName.text.toString(),
                binding.editTextTextEmailAddress.text.toString()
            )
        }
    }

    private fun initObservers() {
        viewModel.invalidUserData.observe(this) {
            showToast(getString(R.string.invalid_user_data))
        }

        viewModel.isUserRegister.observe(this) {
            startActivity(Intent(this@RegisterUserActivity, PokemonListActivity::class.java))
        }
    }

    private fun showToast(message: String) {
        val toast = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
        toast.show()
    }
}
