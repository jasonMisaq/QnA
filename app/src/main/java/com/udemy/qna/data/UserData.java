package com.udemy.qna.data;


import com.udemy.qna.R;

/**
 * Created by johndoe on 12/1/17.
 */

public class UserData {
   public final static String [] names = {
            "Elham",
            "Maryam",
            "Sahar",
            "Goli"
    };
   public final static int [] images = {
            R.drawable.elham,
            R.drawable.maryam,
            R.drawable.sahar,
            R.drawable.goli
    };
    public String [] getNames() {
        return names;
    }
    public int[] getImages () {
        return images;
    }

}
