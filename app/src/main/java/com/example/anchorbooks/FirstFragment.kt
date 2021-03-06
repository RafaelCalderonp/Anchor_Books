package com.example.anchorbooks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anchorbooks.databinding.FragmentFirstBinding
import com.example.anchorbooks.viewModel.BooksViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var mBinding:FragmentFirstBinding
    private val mViewModel : BooksViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding= FragmentFirstBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BooksAdapter()
        mBinding.rvListBooks.adapter = adapter
        mBinding.rvListBooks.layoutManager = LinearLayoutManager(context)

        mViewModel.getBooksList().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })



        //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

    }
}