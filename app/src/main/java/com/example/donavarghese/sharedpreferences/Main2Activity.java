package com.example.donavarghese.sharedpreferences;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    EditText id,hoursWork,name,pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        id = (EditText) findViewById(R.id.employeeID);
         hoursWork = (EditText) findViewById(R.id.hoursWorked);
        name= (EditText) findViewById(R.id.employeeName);
         pay = (EditText) findViewById(R.id.payRate);


    }


    public void saveToDatabase(View view ){


        int hourWorked = Integer.parseInt(hoursWork.getText().toString());
        int employee_id = Integer.parseInt(id.getText().toString());
        String employee_Name = name.getText().toString();
        double employee_Pay = Double.parseDouble(pay.getText().toString());


        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
       Toast toast =  Toast.makeText(getApplicationContext(),"Data saved to database",Toast.LENGTH_SHORT);
        toast.show();
        ContentValues values = new ContentValues();
        values.put(ProductHelper.ProductEntry.EMPLOYEE_NAME,employee_Name );
        values.put(ProductHelper.ProductEntry.EMPLOYEE_PAY,employee_Pay);
        values.put(ProductHelper.ProductEntry.HOURS_WORKED,hourWorked);
        values.put(ProductHelper.ProductEntry.EMPLOYEE_ID,employee_id);
        long newRowId = db.insert(ProductHelper.ProductEntry.TABLE_NAME,null,values);

        id.setText("");
        hoursWork.setText("");
        name.setText("");
        pay.setText("");





    }

    public void searchwindow(View view){


        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
    }


}
