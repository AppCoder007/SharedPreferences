package com.example.donavarghese.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String MyPREFERENCES = "UserPrefs";
    public static final String FavoriteNumber = "numKey";
    public static final String Name = "nameKey";
    public static final String ID = "Key";
    SharedPreferences sharedPref;
    String initialValue = "1";
    EditText name,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name1);
        id = (EditText) findViewById(R.id.id1);
        sharedPref = getSharedPreferences(MyPREFERENCES,
                Context.MODE_PRIVATE);
    }



    public void saveData(View view){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Name, name.getText().toString());
        editor.putString(ID, id.getText().toString());
        editor.commit();
        String userNumber = sharedPref.getString(Name, String.valueOf(editor)) + "  "+ sharedPref.getString(ID,String.valueOf(editor));
        Toast.makeText(getApplicationContext(), userNumber, Toast.LENGTH_LONG).show();






        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }



}
