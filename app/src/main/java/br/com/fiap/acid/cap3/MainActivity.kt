package br.com.fiap.acid.cap3

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.acid.cap3.databinding.ActivityMainBinding
import br.com.fiap.acid.cap3.repository.StoreRepositoryImpl
import br.com.fiap.acid.cap3.viewmodel.StoreViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: StoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        viewModel.registerAccess()
    }
}