package com.mateus.task.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import com.mateus.task.databinding.FragmentRegisterBinding
import androidx.navigation.fragment.findNavController
class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.toolbar.setNavigationOnClickListener { findNavControllerCompatBack() }
        binding.buttonRegister.setOnClickListener {
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()
            when {
                email.isEmpty() -> Toast.makeText(requireContext(), "Preencha seu e-mail", Toast.LENGTH_SHORT).show()
                password.isEmpty() -> Toast.makeText(requireContext(), "Preencha sua senha", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(requireContext(), "Cadastro preparado para integração com Firebase.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun findNavControllerCompatBack() {
        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
