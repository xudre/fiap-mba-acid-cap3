package br.com.fiap.acid.cap3.view

import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.fiap.acid.cap3.databinding.FragmentHomeBinding

class HomeFragment(
    builder: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding = { inflater, container, root ->
        FragmentHomeBinding.inflate(inflater, container, root)
    }
) : BaseFragment<FragmentHomeBinding>(builder) {

    companion object {
    }
}