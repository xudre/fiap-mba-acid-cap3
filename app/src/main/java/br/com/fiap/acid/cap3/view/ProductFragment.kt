package br.com.fiap.acid.cap3.view

import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.fiap.acid.cap3.databinding.FragmentProductBinding

class ProductFragment(
    builder: (LayoutInflater, ViewGroup?, Boolean) -> FragmentProductBinding = { inflater, container, root ->
        FragmentProductBinding.inflate(inflater, container, root)
    }
) : BaseFragment<FragmentProductBinding>(builder) {

    companion object {
    }
}