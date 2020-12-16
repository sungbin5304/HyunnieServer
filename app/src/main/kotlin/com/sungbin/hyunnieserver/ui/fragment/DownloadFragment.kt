package com.sungbin.hyunnieserver.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sungbin.hyunnieserver.databinding.TestFragmentBinding


/**
 * Created by SungBin on 2020-08-31.
 */

class DownloadFragment : Fragment() {

    private val binding by lazy { TestFragmentBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.tvTest.text = "기다려...\n곧 만들게..."
    }

}