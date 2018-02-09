package com.pace.cs639spring.hw1;

import android.graphics.PorterDuff;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by kachi on 1/31/18.
 * Modified by Aashutosh
 */

public class AnimalDisplayFragment extends Fragment implements View.OnClickListener {
    //instance of animal: view and text part
    private ImageView biView, ciView, diView;
    private TextView biText, ciText, diText;
    //pointer to store the event action number.
    int pointer = -1;


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.animal_display, container, false);

        //2 methods
        define(view);
        setView();
        return view;

    }

    //initialization of animal: views&text to instance variables.
    private void define(View view) {
        biView = view.findViewById(R.id.iBird);
        ciView = view.findViewById(R.id.iCat);
        diView = view.findViewById(R.id.iDog);

        diText = view.findViewById(R.id.tDog);
        ciText = view.findViewById(R.id.tCat);
        biText = view.findViewById(R.id.tBird);
    }

    //Declaration of animal: views&text
    private void setView() {
        biView.setOnClickListener(this);
        ciView.setOnClickListener(this);
        diView.setOnClickListener(this);

        biText.setOnClickListener(this);
        ciText.setOnClickListener(this);
        ciText.setOnClickListener(this);

    }

    public void colorM(int c) {
        //initially the pointer value is=-1 so that we can ask user to select the animal.
        if (pointer == -1) {
            Toast.makeText(getActivity(), getString(R.string.b), Toast.LENGTH_SHORT).show();
        } else if (pointer == 1) {
            biView.setColorFilter(c, PorterDuff.Mode.SRC_IN);
        } else if (pointer == 2) {
            ciView.setColorFilter(c, PorterDuff.Mode.SRC_IN);
        } else if (pointer == 3) {
            diView.setColorFilter(c, PorterDuff.Mode.SRC_IN);
        }
    }

    //selecting on click event and assigning pointer.
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iBird:
                pointer = 1;
                break;
            case R.id.iCat:
                pointer = 2;
                break;
            case R.id.iDog:
                pointer = 3;
                break;
        }
        information(); //call of method, to be visible & show respective messages.
    }

    private void information() {
        // For Bird: Text to be visible
        if (pointer == 1) {
            if (biText.getVisibility() == View.GONE) {
                biText.setVisibility(View.VISIBLE);
            } else {
                pointer = -1;
                biText.setVisibility(View.GONE);
            }
            ciText.setVisibility(View.GONE);
            diText.setVisibility(View.GONE);

        }
        //For Cat: Text to be visible
        else if (pointer == 2) {
            biText.setVisibility(View.GONE);
            if (ciText.getVisibility() == View.GONE) {
                ciText.setVisibility(View.VISIBLE);
            } else {
                pointer = -1;
                ciText.setVisibility(View.GONE);
            }
            diText.setVisibility(View.GONE);
        }
        //For Dog: Text to be visible
        else if (pointer == 3) {
            biText.setVisibility(View.GONE);
            ciText.setVisibility(View.GONE);
            if (diText.getVisibility() == View.GONE) {
                diText.setVisibility(View.VISIBLE);
            } else {
                pointer = -1;
                diText.setVisibility(View.GONE);
            }

        }
    }
}
