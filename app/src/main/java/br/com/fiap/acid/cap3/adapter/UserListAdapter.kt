package br.com.fiap.acid.cap3.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.acid.cap3.databinding.ListItemUserBinding
import br.com.fiap.acid.cap3.model.UserData

class UserListAdapter(
    private var users: List<UserData>,
) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ListItemUserBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserData) {
            binding.tvName.text = user.name
            binding.tvEmail.text = user.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemUserBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(data: List<UserData>) {
        users = data

        notifyDataSetChanged()
    }

}