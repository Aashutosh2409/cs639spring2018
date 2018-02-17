package com.pace.cs639spring.hw2;
import java.util.ArrayList;
import java.util.List;
/**
/**
 * Created by aashutoshsingh on 2/12/18.
 */

public class AnimalDescription {
    int ImageId;
    ArrayList<String> AnimalList;
    int pointer;

    AnimalDescription(int aImageId, List<String> List, int mIndex) {
        ImageId = aImageId;
        AnimalList = new ArrayList<>(List);
        pointer = mIndex;
    }
}

