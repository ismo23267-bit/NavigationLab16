
package com.example.navigationlab16

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.fragment.app.viewModels
import com.example.navigationlab16.viewmodel.ProfileViewModel
import android.widget.TextView

class ProfileFragment : Fragment() {
    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        return inflater.inflate(
            R.layout.fragment_profile,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val tvUsername = view.findViewById<TextView>(
            R.id.tvUsername

        )
        tvUsername.text = profileViewModel.username

        val btnProfileHome = view.findViewById<Button>(
            R.id.btnProfileHome
        )

        btnProfileHome.setOnClickListener {
            val navController = findNavController()

            val returned = navController.popBackStack(
                R.id.homeFragment,
                false
            )

            if (!returned) {
                navController.navigate(R.id.homeFragment)
            }
        }
    }
}
