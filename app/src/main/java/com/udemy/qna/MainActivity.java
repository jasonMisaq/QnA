package com.udemy.qna;

import android.app.Application;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.udemy.qna.data.UserData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.submit);
        final EditText text = (EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText().toString().isEmpty()) {
                    text.setError(getString(R.string.username_required));
                } else {
                    Intent intent = new Intent(MainActivity.this, TargetActivity.class);
                    startActivity(intent);
                }
            }
        });
        mArrayList = new ArrayList<>();


        Button showPicker = (Button) findViewById(R.id.show_picker);
        final TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            }
        };

        showPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog = new TimePickerDialog(MainActivity.this, myTimeListener, 5, 10, true);
                dialog.show();
            }
        });
        ListView listView = (ListView) findViewById(R.id.list);
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < UserData.names.length; i++) {
            users.add(new User(UserData.names[i], UserData.images[i]));
        }
        MyAdapter adapter = new MyAdapter(this, users);
        listView.setAdapter(adapter);
        TextView floatingTV = new TextView(this);
        floatingTV.setGravity(Gravity.CENTER);
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        root.addView(floatingTV);

        Object[] params = new Object[]{new Object(), new Object()};
        params[0] = mArrayList;
        params[1] = floatingTV;
        new FillData().execute(params);
    }

    private static class FillData extends AsyncTask<Object, Void, Void> {
        ArrayList<String> strList;
        Context context;
        TextView tv;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Object... objs) {
            this.strList = (ArrayList<String>) objs[0];
            tv = (TextView) objs[1];
            //I am going to create an application context here to access string resources
            context = tv.getContext();
            strList.add(context.getString(R.string.app_name));
            strList.add(context.getString(R.string.username_required));

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            tv.setText(strList.get(0));

        }
    }

}
