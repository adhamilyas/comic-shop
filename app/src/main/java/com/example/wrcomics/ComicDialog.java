package com.example.wrcomics;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import org.jetbrains.annotations.NotNull;

public class ComicDialog extends AppCompatDialogFragment {

    String internalComicName;
    String internalQty;

    public ComicDialog(String comicName, String qty){
        internalComicName = comicName;
        internalQty = qty;
    }

    @NonNull
    @NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        String dialogMessage = "Success submit to cart! \n\n";
        dialogMessage += "Comic Name : " + internalComicName + "\n";
        dialogMessage += "Quantity : " + internalQty + "\n";

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Message Cart")
                .setMessage(dialogMessage)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                });
        return builder.create();
    }
}
