package com.interview.disney.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.interview.disney.R
import com.interview.disney.databinding.FragmentCharacterDetailBinding
import com.interview.disney.presentation.viewmodels.SingleCharacterViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_CHARACTER_ID = "characterId"

/**
 * A simple [Fragment] subclass.
 * Use the [CharacterDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var characterId: Int? = null

    private lateinit var mBinding : FragmentCharacterDetailBinding
    private val mViewModel: SingleCharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            characterId = it.getInt(ARG_CHARACTER_ID)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.character().observe(viewLifecycleOwner, { character ->
            val tvShows = character.tvShows.joinToString(", ")
            mBinding.singleCharacterName.text = character.name
            mBinding.singleTvShows.text = tvShows
            Picasso.
            get()
                .load(character.imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(mBinding.singleImageView)

        })


        characterId?.let { mViewModel.getSingleCharacter(it) }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_character_detail, container, false)

        // Inflate the layout for this fragment
        return mBinding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CharacterDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(characterId: String) =
            CharacterDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_CHARACTER_ID, characterId)
                }
            }
    }
}