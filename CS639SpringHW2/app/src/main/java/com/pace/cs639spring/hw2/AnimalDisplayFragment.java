package com.pace.cs639spring.hw2;
import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by aashutoshsingh on 2/12/18.
 */

public class AnimalDisplayFragment extends Fragment {

    public final String label = "AnimalDisplayFragment";

    View mAnimalDisplayView;
    EditText mAddDescEditText;
    Button mAddDescBtn;

    public static ListView mListView;
    AnimalDisplayListViewAdapter mAdapter;
    ImageButton cBtn1,cBtn2,cBtn3,cBtn4,cBtn5;

    List<AnimalDescription> animalDescriptionList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mAnimalDisplayView = inflater.inflate(R.layout.display, container, false);

        mListView = (ListView)mAnimalDisplayView.findViewById(R.id.TotalView);
        mListView.setItemsCanFocus(false);
        // Configure the list view data
        configureListView();
        return mAnimalDisplayView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mAddDescBtn = mAnimalDisplayView.findViewById(R.id.addBtn);
        mAddDescEditText = mAnimalDisplayView.findViewById(R.id.editText);
        mAddDescBtn.setOnClickListener(addDescBtnOnClickListener());

        cBtn1 = mAnimalDisplayView.findViewById(R.id.Btn1);
        cBtn2 = mAnimalDisplayView.findViewById(R.id.Btn2);
        cBtn3 = mAnimalDisplayView.findViewById(R.id.Btn3);
        cBtn4 = mAnimalDisplayView.findViewById(R.id.Btn4);
        cBtn5 = mAnimalDisplayView.findViewById(R.id.Btn5);

        // Setting the click listener for color buttons
        cBtn1.setOnClickListener(colorButtonClickListener());
        cBtn2.setOnClickListener(colorButtonClickListener());
        cBtn3.setOnClickListener(colorButtonClickListener());
        cBtn4.setOnClickListener(colorButtonClickListener());
        cBtn5.setOnClickListener(colorButtonClickListener());

    }

    public View.OnClickListener colorButtonClickListener(){
        View.OnClickListener set = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(label,"Inside ColorButton OnClick Event");

                ImageButton ib = (ImageButton) view;
                ColorDrawable dc = (ColorDrawable)ib.getBackground();


                if(mAdapter.mSelectedAnimalRow!=null){
                    //if any row is selected
                    int colorId = mAdapter.mSelectedAnimalRow.mAnimalSelectedIndex==mAdapter.mSelectedIndex? dc.getColor():R.color.colorBlack;
                    mAdapter.mColor = colorId;
                    mAdapter.mSelectedAnimalRow.mImageView.setColorFilter(colorId);
                }
                //display toast message
                else{
                    Toast.makeText(view.getContext(),R.string.image_not_selected,Toast.LENGTH_SHORT).show();
                }
            }
        };
        return set;
    }

    public View.OnClickListener addDescBtnOnClickListener(){
        View.OnClickListener set = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add new description to selected Animal/Bird
                String newDesc = mAddDescEditText.getText().toString();
                if(newDesc.equalsIgnoreCase("")){// If no description is added show Toast message
                    Toast.makeText(mAnimalDisplayView.getContext() , R.string.desc_not_added, Toast.LENGTH_SHORT).show();
                    return;
                }
                if(null!=mAdapter.mSelectedAnimalRow){// If any Image is not selected then display Toast Message otherwise add description
                    mAdapter.mSelectedAnimalRow.mAnimalDescList.add(newDesc);
                    mAddDescEditText.setText("");
                    InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mAddDescEditText.getWindowToken(), 0);
                }
                else{
                    Toast.makeText(mAnimalDisplayView.getContext() , R.string.image_not_selected, Toast.LENGTH_SHORT).show();
                }
            }
        };

        return set;
    }

    public void configureListView(){

        // First Animal with multiple description
        animalDescriptionList.add(new AnimalDescription(R.drawable.bird, Arrays.asList(getResources().getString(R.string.bird)),0));
        animalDescriptionList.add(new AnimalDescription(R.drawable.dog, Arrays.asList(getResources().getString(R.string.dog)),0));
        animalDescriptionList.add(new AnimalDescription(R.drawable.cat, Arrays.asList(getResources().getString(R.string.cat)),0));
        animalDescriptionList.add(new AnimalDescription(R.drawable.snake, Arrays.asList(getResources().getString(R.string.snake)),0));
        animalDescriptionList.add(new AnimalDescription(R.drawable.horse, Arrays.asList(getResources().getString(R.string.horse)),0));
        animalDescriptionList.add(new AnimalDescription(R.drawable.duck, Arrays.asList(getResources().getString(R.string.duck)),0));
        animalDescriptionList.add(new AnimalDescription(R.drawable.lizard, Arrays.asList(getResources().getString(R.string.lizard)),0));
        animalDescriptionList.add(new AnimalDescription(R.drawable.dino, Arrays.asList(getResources().getString(R.string.dino)),0));
        animalDescriptionList.add(new AnimalDescription(R.drawable.fish, Arrays.asList(getResources().getString(R.string.fish)),0));
        animalDescriptionList.add(new AnimalDescription(R.drawable.scorpio, Arrays.asList(getResources().getString(R.string.scorpio)),0));

        mAdapter = new AnimalDisplayListViewAdapter(mAnimalDisplayView.getContext(), animalDescriptionList);
        mListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}

