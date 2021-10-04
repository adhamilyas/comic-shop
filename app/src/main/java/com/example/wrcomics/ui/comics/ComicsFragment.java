package com.example.wrcomics.ui.comics;

import android.content.Intent;
import android.os.Bundle;
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

import com.example.wrcomics.ComicDetail;
import com.example.wrcomics.ListComics;
import com.example.wrcomics.R;
import com.example.wrcomics.databinding.FragmentComicsBinding;
import com.example.wrcomics.databinding.FragmentComicsBinding;

import java.util.ArrayList;

public class ComicsFragment extends Fragment {

    private ComicsViewModel comicsViewModel;
    private FragmentComicsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        comicsViewModel =
                new ViewModelProvider(this).get(ComicsViewModel.class);

        binding = FragmentComicsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        int[] imageId = {R.drawable.imgcomic1, R.drawable.imgcomic2, R.drawable.imgcomic3, R.drawable.imgcomic4, R.drawable.imgcomic5};
        String[] comicTitle = {"Naruto", "Tokyo Revengers", "Boku no Hero Academia", "One Piece", "Shingeki no Kyojin"};
        String[] comicDesc = {"Desc 1", "Desc 2", "Desc 3", "Desc 4", "Desc 5"};

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