package br.com.fiap.acid.cap3.view

import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.fiap.acid.cap3.databinding.FragmentStoreBinding

class StoreFragment(
    builder: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStoreBinding = { inflater, container, root ->
        FragmentStoreBinding.inflate(inflater, container, root)
    }
) : BaseFragment<FragmentStoreBinding>(builder) {

    companion object {
    }
}