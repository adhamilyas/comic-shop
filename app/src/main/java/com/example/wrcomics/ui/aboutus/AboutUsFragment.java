package com.example.wrcomics.ui.aboutus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.wrcomics.databinding.FragmentAboutusBinding;
import com.example.wrcomics.databinding.FragmentAboutusBinding;

public class AboutUsFragment extends Fragment {

    private AboutUsViewModel aboutUsViewModel;
    private FragmentAboutusBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutUsViewModel =
                new ViewModelProvider(this).get(AboutUsViewModel.class);

        binding = FragmentAboutusBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.txtAbout.setVisibility(View.VISIBLE);
                binding.txtContactUs.setVisibility(View.INVISIBLE);
                binding.linearLayout2.setVisibility(View.INVISIBLE);
                binding.linearLayout3.setVisibility(View.INVISIBLE);
            }
        });

        binding.btnContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.txtAbout.setVisibility(View.INVISIBLE);
                binding.txtContactUs.setVisibility(View.VISIBLE);
                binding.linearLayout2.setVisibility(View.VISIBLE);
                binding.linearLayout3.setVisibility(View.VISIBLE);
            }
        });

//        final TextView textView = binding.textSlideshow;
//        aboutUsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}