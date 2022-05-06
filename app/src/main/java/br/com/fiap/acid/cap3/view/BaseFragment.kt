package br.com.fiap.acid.cap3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewbinding.ViewBinding
import br.com.fiap.acid.cap3.viewmodel.StoreViewModel

abstract class BaseFragment<T : ViewBinding>(
    private val builder: (inflater: LayoutInflater, root: ViewGroup?, attachToRoot: Boolean) -> T
) : Fragment() {

    var binding: T? = null
        private set

    val viewModel: StoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = builder(inflater, container, false)

        return binding?.root
    }
}