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



    inner class CharacterViewHolder(characterItemBinding: FragmentCharacterItemBinding): RecyclerView.ViewHolder(characterItemBinding.root), View.OnClickListener {
        val characterName: TextView = characterItemBinding.characterName
        val characterImg: ImageView = characterItemBinding.imageView

        val view : View = characterItemBinding.root



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

        holder.view.setOnClickListener(holder)

        val character = characters[position]
        holder.characterName.text = character.name
        Picasso.
        get()
            .load(character.imageUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(holder.characterImg)
    }
}