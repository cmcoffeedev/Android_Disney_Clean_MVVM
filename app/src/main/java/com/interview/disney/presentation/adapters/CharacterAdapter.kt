package com.interview.disney.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.interview.disney.databinding.FragmentCharacterItemBinding
import com.interview.disney.domain.model.DisneyCharacter
import com.interview.disney.presentation.CharacterClickListener


class CharacterAdapter(private val characterClickListener: CharacterClickListener) :
    PagingDataAdapter<DisneyCharacter, CharacterAdapter.CharacterViewHolder>(diffCallback) {


    inner class CharacterViewHolder(private val characterItemBinding: FragmentCharacterItemBinding) :
        RecyclerView.ViewHolder(characterItemBinding.root), View.OnClickListener {

        val view: View = characterItemBinding.root

        init {
            view.setOnClickListener(this)
        }

        fun bind(character: DisneyCharacter) {
            characterItemBinding.characterItem = character
        }

        override fun onClick(view: View?) {

            getItem(absoluteAdapterPosition)?.let { characterClickListener.clickedCharacter(it) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            FragmentCharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<DisneyCharacter>() {
            override fun areItemsTheSame(
                oldItem: DisneyCharacter,
                newItem: DisneyCharacter
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: DisneyCharacter,
                newItem: DisneyCharacter
            ): Boolean =
                oldItem == newItem
        }
    }


}