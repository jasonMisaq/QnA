package com.udemy.qna;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;

import com.udemy.qna.data.UserData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.submit);
        final EditText text = (EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().toString().isEmpty()) {
                    text.setError(getString(R.string.username_required));
                }
                else{
                    Intent intent = new Intent(MainActivity.this, TargetActivity.class);
                    startActivity(intent);
                }
            }
        });


        Button showPicker = (Button) findViewById(R.id.show_picker);
        final TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            }
        };

        showPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog = new TimePickerDialog(MainActivity.this, myTimeListener, 5,10,true);
                dialog.show();
            }
        });
        ListView listView = (ListView) findViewById(R.id.list);
        ArrayList<User> users = new ArrayList<>();
        for(int i= 0; i< UserData.names.length; i++) {
            users.add(new User(UserData.names[i],UserData.images[i]));
        }
        MyAdapter adapter = new MyAdapter(this, users);
        listView.setAdapter(adapter);
        
    }

}
