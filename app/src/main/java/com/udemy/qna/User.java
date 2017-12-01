package com.udemy.qna;

/**
 * Created by johndoe on 12/2/17.
 */

public class User {
    private String name;
    private int image;
    public User(String n, int img) {
        name= n;
        image = img;
    }
    String getName() { return name; }
    int getImage () {return image; }

}
