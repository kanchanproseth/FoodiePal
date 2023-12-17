package com.cs473.mda.foodiepal.dashboard.pages

import android.app.Instrumentation.ActivityResult
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.cs473.mda.foodiepal.R
import com.cs473.mda.foodiepal.databinding.FragmentContactMeBinding

class ContactMeFragment : Fragment(R.layout.fragment_contact_me), FragmentPropertyInterface {
    override val title = "Contact"


    private var _binding: FragmentContactMeBinding? = null

    private val binding get() = _binding!!

    private val checkPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) {
            makePhoneCall()
        } else {
            // if permission denied then check whether never ask
            // again is selected or not by making use of
            !ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(), android.Manifest.permission.CALL_PHONE
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactMeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    private fun viewBinding() {
        binding.phoneCallIcon.setOnClickListener {
            checkPhoneCallPermission()
        }

        binding.emailIcon.setOnClickListener {
            openEmail()
        }
    }


    private fun checkPhoneCallPermission() {
        checkPermission.launch(android.Manifest.permission.CALL_PHONE)
    }


    private fun makePhoneCall() {
        val phoneNumber = "tel:" + getString(R.string.chef_phone_number).replace("-", "") // Replace with the desired phone number
        Log.d("phoneNumber", phoneNumber)
        val dialIntent = Intent(Intent.ACTION_CALL, Uri.parse(phoneNumber))

        try {
            startActivity(dialIntent)
        } catch (e: SecurityException) {
            e.printStackTrace()
            // Handle the exception (e.g., show a message to the user)
        }
    }

    private fun openEmail() {
        val intent = Intent(Intent.ACTION_SEND);
        intent.type = "plain/text"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("some@email.address"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "");
        intent.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(Intent.createChooser(intent, ""));
    }

}