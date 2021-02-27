package com.example.anchorbooks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.anchorbooks.databinding.BooksListBinding
import com.example.anchorbooks.model.local.entities.BooksEntity

class BooksAdapter : RecyclerView.Adapter<BooksAdapter.BooksVH>(){

    private var listBooks = listOf<BooksEntity>()
    private val selectedBook = MutableLiveData<BooksEntity>()

    fun update(list: List<BooksEntity>) {
        listBooks = list
        notifyDataSetChanged()
    }

    fun selectedBook(): LiveData<BooksEntity> = selectedBook

    inner class BooksVH(private val mBinding: BooksListBinding) :
        RecyclerView.ViewHolder(mBinding.root), View.OnClickListener{
        fun bind(book: BooksEntity){
            Glide.with(mBinding.ivCoverPage).load(book.imageLink).centerCrop().
            into(mBinding.ivCoverPage)
            mBinding.tvTitle.text = book.title
            mBinding.tvauthor.text = book.author
            mBinding.tvLanguage.text = book.language
        }


        override fun onClick(v: View?) {
            selectedBook.value = listBooks[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksAdapter.BooksVH {
        return BooksVH(BooksListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BooksAdapter.BooksVH, position: Int) {
        val book = listBooks[position]
        holder.bind(book)
    }

    override fun getItemCount()=listBooks.size


}