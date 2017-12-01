package com.udemy.qna;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.udemy.qna.data.UserData;

import java.util.ArrayList;

/**
 * Created by johndoe on 12/2/17.
 */

public class MyAdapter extends ArrayAdapter<User> {
    public MyAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
        mUsers = users;
    }
    private ArrayList<User> mUsers;



    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            TextView name = convertView.findViewById(R.id.name);
            ImageView image = convertView.findViewById(R.id.image);
            name.setText(user.getName());
            image.setImageResource(user.getImage());

        }
        return convertView;
    }

}