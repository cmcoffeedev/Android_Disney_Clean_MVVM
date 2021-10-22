package com.interview.disney.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.interview.disney.R
import com.interview.disney.databinding.FragmentDisneyCharactersBinding
import com.interview.disney.domain.model.DisneyCharacter
import com.interview.disney.presentation.adapters.CharacterAdapter
import com.interview.disney.presentation.viewmodels.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DisneyCharactersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class DisneyCharactersFragment : Fragment(), CharacterClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mBinding: FragmentDisneyCharactersBinding

    private val mCharacters = ArrayList<DisneyCharacter>()
    private val mCharacterViewModel: CharacterViewModel by viewModels()
    private lateinit var mCharacterAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mCharacterViewModel.characters().observe(viewLifecycleOwner, { characters ->
            mCharacters.clear()
            mCharacters.addAll(characters)
            mCharacterAdapter.notifyItemRangeChanged(0, characters.size)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_disney_characters, container, false )
        val recyclerView = mBinding.list

        mCharacterAdapter = CharacterAdapter(mCharacters, this)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mCharacterAdapter
        }


        return mBinding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DisneyCharactersFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DisneyCharactersFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun clickedCharacter(character: DisneyCharacter) {
        findNavController().navigate(R.id.characterDetailFragment, bundleOf(Pair("characterId", character.id)))
    }

}