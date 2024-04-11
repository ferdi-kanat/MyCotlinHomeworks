package com.example.cotlindersim

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cotlindersim.databinding.FragmentFirstPageBinding

class FirstPageFragment : Fragment() {

    private lateinit var binding: FragmentFirstPageBinding
    private lateinit var myAdapter: ListAdapter
    private var itemList = mutableListOf<ListDataModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        binding.button2.setOnClickListener {
            val title = binding.editTextText.text.toString()
            val description = binding.editTextText2.text.toString()

            if (title.isNotEmpty() && description.isNotEmpty()) {
                addItemToList(title, description)
                clearInputFields()
            } else {
                // Both fields are not filled
                showErrorMessage("Fill all the blanks")
            }
        }
    }

    private fun setupRecyclerView() {
        myAdapter = ListAdapter(itemList)
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = myAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addItemToList(title: String, description: String) {
        val newItem = ListDataModel(title, description)
        itemList.add(newItem)
        myAdapter.notifyDataSetChanged()
    }

    private fun clearInputFields() {
        binding.editTextText.text.clear()
        binding.editTextText2.text.clear()
    }

    private fun showErrorMessage(message: String) {
        binding.errorTextView.text = message
        // Set a delay to clear the error message after a certain period
        Handler(Looper.getMainLooper()).postDelayed({
            binding.errorTextView.text = ""
        }, 3000) // Clear the error message after 3 seconds

    }

}