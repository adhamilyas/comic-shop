package com.example.wrcomics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wrcomics.databinding.ActivityComicDetailBinding;

public class ComicDetail extends AppCompatActivity {

    ActivityComicDetailBinding binding;
    TextView txtComicTitle, txtComicDesc;
    ImageView imgCover;
    Button btnBack, btnAddToCart;
    EditText edtQty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityComicDetailBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_comic_detail);

        txtComicTitle = findViewById(R.id.txtComicTitle);
        txtComicDesc = findViewById(R.id.txtComicDesc);
        imgCover = findViewById(R.id.imgCover);
        btnBack = findViewById(R.id.btnBack);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        edtQty = findViewById(R.id.edtQty);

        Intent intent = this.getIntent();

        if (intent != null){

            String comicTitle = intent.getStringExtra("comicTitle");
            String comicDesc = intent.getStringExtra("comicDesc");
            int imageId = intent.getIntExtra("imageId", R.drawable.imgcomic1);

            txtComicTitle.setText(comicTitle);
            txtComicDesc.setText(comicDesc);
            imgCover.setImageResource(imageId);

        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String quantity = edtQty.getText().toString();

                if(quantity.equals("") || quantity.equals("0")){
                    Toast.makeText(getApplicationContext(), "Quantity cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    openDialog();
                }


            }
        });
    }

    public void openDialog(){
        ComicDialog comicDialog = new ComicDialog(txtComicTitle.getText().toString(), edtQty.getText().toString());
        comicDialog.show(getSupportFragmentManager(), "comic dialog");
        //finish();
    }
}