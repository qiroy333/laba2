package com.example.myanimalapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myanimalapp.R
import com.example.myanimalapp.adapter.AnimalAdapter
import com.example.myanimalapp.databinding.FragmentFirstBinding
import com.example.myanimalapp.adapter.model.AnimalModel

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    lateinit var adapter: AnimalAdapter
    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        adapter = AnimalAdapter()

        binding.recyclerView.adapter = adapter
        adapter.setList(myAnimals())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
        adapter.navController = navController

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun myAnimals(): ArrayList<AnimalModel>{
        var animalList = ArrayList<AnimalModel>()

        val animal1 = AnimalModel("Чупа",
            "Чуп - це маленька тваринка з великими очима.",
            "https://png2.cleanpng.com/dy/4d1d4b73b109be7f8c1880efb0a84548/L0KzQYm3VMEzN5Juj5H0aYP2gLBuTfdwdJVqhp9xYX32hLb5TfdmepNuhJ9wdXnxdbK0kPloNZRmf9c2aHHwg8Xskr02aZRrSdVuMXXocoG5V746OWY8TKM8NkG4QoS8UsI4QGYAT6kCLoDxd1==/kisspng-golden-hamster-gerbil-guinea-pig-cage-hamster-5acf1ce1eeb027.9157413615235227859777.png")
        animalList.add(animal1)

        val animal2 = AnimalModel("Супер",
            "Супер - це маленька герой з великим серцем.",
            "https://w7.pngwing.com/pngs/761/75/png-transparent-the-dog-will-laugh-animal-corgi-cute-dog.png")
        animalList.add(animal2)

        val animal3 = AnimalModel("Кукі",
            "Кукі - це маленький милий кіт.",
            "https://images.rawpixel.com/image_png_social_portrait/czNmcy1wcml2YXRlL3Jhd3BpeGVsX2ltYWdlcy93ZWJzaXRlX2NvbnRlbnQvcHUyMzMxNjM2LWltYWdlLTAxLXJtNTAzXzMtbDBqOXFrNnEucG5n.png?s=ap5xES89ty-fUtnmSk81EJPqHoIIeTxNy7wU3KJHUbU")
        animalList.add(animal3)



        return animalList
    }
}