package com.example.wrcomics.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.wrcomics.ComicDetail;
import com.example.wrcomics.ListComics;
import com.example.wrcomics.R;
import com.example.wrcomics.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

import com.denzcoskun.imageslider.constants.ScaleTypes;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ImageSlider imageSlider = root.findViewById(R.id.slider);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.carousel1, "", ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.carousel2, "", ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.carousel3, "", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels);

        int[] imageId = {R.drawable.imgcomic5, R.drawable.imgcomic2, R.drawable.imgcomic1, R.drawable.imgcomic4, R.drawable.imgcomic3};
        String[] comicTitle = {"Shingeki no Kyojin", "Tokyo Revengers", "Naruto", "One Piece", "Boku no Hero Academia"};
        String[] comicDesc = {"Desc 5", "Desc 2", "Desc 1", "Desc 4", "Desc 3"};

        ArrayList<ListComics> listComicsArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            ListComics comics = new ListComics(comicTitle[i],comicDesc[i],imageId[i]);
            listComicsArrayList.add(comics);
        }

        ListAdapter listAdapter = new com.example.wrcomics.ListAdapter(getActivity(), listComicsArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getActivity(), ComicDetail.class);
                i.putExtra("comicTitle", comicTitle[position]);
                i.putExtra("comicDesc", comicDesc[position]);
                i.putExtra("imageId", imageId[position]);
                startActivity(i);

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}