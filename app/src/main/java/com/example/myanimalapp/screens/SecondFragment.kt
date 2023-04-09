package com.example.myanimalapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.myanimalapp.R
import com.example.myanimalapp.databinding.FragmentFirstBinding
import com.example.myanimalapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)

        // Retrieve arguments passed from source fragment
        val args: SecondFragmentArgs by navArgs()
        val name = args.name
        val description = args.description
        val photo = args.photo

        binding.name.text = name
        binding.description.text = description
        Glide.with(this)
            .load(photo)
            .into(binding.photo)

        binding.backButton.setOnClickListener{
            navController.navigate(R.id.action_secondFragment3_to_firstFragment2)
        }
    }
}