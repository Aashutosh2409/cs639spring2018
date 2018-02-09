package com.pace.cs639spring.hw1;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private AnimalDisplayFragment animalDisplayFragment;
    private View vGreen, vBlue, vOrange, vPurple, vRed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //instance of colors and view
        setReference();
        setEvents();
        //instance of Fragment
        animalDisplayFragment = new AnimalDisplayFragment();
        addFrag(R.id.box, animalDisplayFragment, getString(R.string.fragment_animal));
        //Welcome Message when the application is created.
        Toast.makeText(getApplicationContext(), getString(R.string.tb), Toast.LENGTH_SHORT).show();
    }

    //initialization of colors to instant variables.
    private void setReference() {
        vPurple = findViewById(R.id.purple1);
        vOrange = findViewById(R.id.orange1);
        vRed = findViewById(R.id.red1);
        vGreen = findViewById(R.id.green1);
        vBlue = findViewById(R.id.blue1);

    }

    //defination of each view
    private void setEvents() {
        vBlue.setOnClickListener(this);
        vGreen.setOnClickListener(this);
        vRed.setOnClickListener(this);
        vOrange.setOnClickListener(this);
        vPurple.setOnClickListener(this);
    }

    protected void addFrag(int containerViewId, Fragment fragment, String fTag) {
        getSupportFragmentManager().beginTransaction().add(containerViewId, fragment, fTag).disallowAddToBackStack().commit();
    }

    @Override
    //onClick event, we color the animal with selected color.
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.purple1:
                animalDisplayFragment.colorM(ContextCompat.getColor(this, android.R.color.holo_purple));
                break;
            case R.id.green1:
                animalDisplayFragment.colorM(ContextCompat.getColor(this, android.R.color.holo_green_dark));
                break;
            case R.id.orange1:
                animalDisplayFragment.colorM(ContextCompat.getColor(this, android.R.color.holo_orange_dark));
                break;
            case R.id.blue1:
                animalDisplayFragment.colorM(ContextCompat.getColor(this, android.R.color.holo_blue_dark));
                break;
            case R.id.red1:
                animalDisplayFragment.colorM(ContextCompat.getColor(this, android.R.color.holo_red_dark));
                break;
        }
    }
}
