package br.com.fiap.acid.cap3.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fiap.acid.cap3.adapter.UserListAdapter
import br.com.fiap.acid.cap3.databinding.FragmentUserBinding
import br.com.fiap.acid.cap3.model.UserData

class UserFragment(
    builder: (LayoutInflater, ViewGroup?, Boolean) -> FragmentUserBinding = { inflater, container, root ->
        FragmentUserBinding.inflate(inflater, container, root)
    }
) : BaseFragment<FragmentUserBinding>(builder) {

    private lateinit var adapter: UserListAdapter

    override fun onStart() {
        super.onStart()

        adapter = UserListAdapter(listOf())

        binding?.apply {
            btnSave.setOnClickListener { addUser() }

            rvUser.layoutManager = LinearLayoutManager(this@UserFragment.context)
            rvUser.adapter = adapter
        }

        updateList()
    }

    private fun updateList() {
        viewModel.retrieveUsers {
            adapter.updateList(it)
        }
    }

    private fun addUser() {
        binding?.let { view ->
            val id: String? =
                if (view.etId.text.isNullOrBlank()) null else view.etId.text.toString()
            val name = view.etName.text.toString()
            val email = view.etEmail.text.toString()

            view.btnSave.isEnabled = false

            viewModel.saveUser(UserData(id, name, email)) { user, exception ->
                if (user != null) {
                    updateList()
                }

                if (exception != null) {
                    Log.i(TAG, "Erro: ${exception.localizedMessage}")
                }

                view.btnSave.isEnabled = true
            }
        }
    }

    companion object {
        private const val TAG = "User"
    }
}