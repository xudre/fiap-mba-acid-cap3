package br.com.fiap.acid.cap3.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.fiap.acid.cap3.R
import br.com.fiap.acid.cap3.databinding.FragmentHomeBinding

class HomeFragment(
    builder: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding = { inflater, container, root ->
        FragmentHomeBinding.inflate(inflater, container, root)
    }
) : BaseFragment<FragmentHomeBinding>(builder) {

    override fun onStart() {
        super.onStart()

        binding?.apply {
            val navigator = findNavController()

            btnUser.setOnClickListener {
                navigator.navigate(R.id.action_homeFragment_to_userFragment)
            }

            btnProduct.setOnClickListener {
                navigator.navigate(R.id.action_homeFragment_to_productFragment)
            }
        }
    }

    companion object {
    }
}