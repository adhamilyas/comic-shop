package com.example.wrcomics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ListComics> {

    public ListAdapter(Context context, ArrayList<ListComics> listComicsArrayList){

        super(context,R.layout.list_item,listComicsArrayList);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ListComics comic = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        ImageView imageView = convertView.findViewById(R.id.image_cover);
        TextView comicTitle = convertView.findViewById(R.id.comic_title);
        TextView comicDesc = convertView.findViewById(R.id.comic_desc);

        imageView.setImageResource(comic.imageId);
        comicTitle.setText(comic.comicTitle);
        comicDesc.setText(comic.comicDesc);


        return convertView;
    }


}
