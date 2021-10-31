package com.interview.disney.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.interview.disney.R
import com.interview.disney.databinding.FragmentCharacterItemBinding
import com.interview.disney.domain.model.DisneyCharacter
import com.interview.disney.presentation.CharacterClickListener
import com.squareup.picasso.Picasso



class CharacterAdapter(private val characters:List<DisneyCharacter>, private val characterClickListener: CharacterClickListener) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){



    inner class CharacterViewHolder(private val characterItemBinding: FragmentCharacterItemBinding): RecyclerView.ViewHolder(characterItemBinding.root), View.OnClickListener {
        val characterName: TextView = characterItemBinding.characterName
        val characterImg: ImageView = characterItemBinding.imageView

        val view : View = characterItemBinding.root

        init {
            view.setOnClickListener(this)
        }

        fun bind(character: DisneyCharacter){
            characterItemBinding.characterItem = character
        }

        override fun onClick(view: View?) {
            characterClickListener.clickedCharacter(characters[adapterPosition])
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  CharacterViewHolder{
        val binding = FragmentCharacterItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return CharacterViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }
}