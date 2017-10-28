package com.example.donavarghese.sharedpreferences;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    EditText search,searchID;
    TextView textView;
    RadioButton rdName, rdID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());


    }
    public void searchEmployee(View view){
         textView = (TextView) findViewById(R.id.textView2) ;
         search = (EditText) findViewById(R.id.search);
         rdName = (RadioButton) findViewById(R.id.radioButton);
        rdID = (RadioButton) findViewById(R.id.radioButton2);
        SQLiteDatabase db = mDatabaseHelper.getReadableDatabase();
        String[] longString = {
                ProductHelper.ProductEntry._ID,
                ProductHelper.ProductEntry.EMPLOYEE_NAME,
                ProductHelper.ProductEntry.EMPLOYEE_PAY,
                ProductHelper.ProductEntry.EMPLOYEE_ID,
                ProductHelper.ProductEntry.HOURS_WORKED
        };
        String sortOrder = ProductHelper.ProductEntry.EMPLOYEE_NAME + " DESC";
        String selection;
        String[] selectionArgs = new String[1];

        if(rdName.isChecked()) {
            selection = ProductHelper.ProductEntry.EMPLOYEE_NAME + " = ?";
             selectionArgs[0] = search.getText().toString();

        } else {
             selection = ProductHelper.ProductEntry.EMPLOYEE_ID + " = ?";
            selectionArgs[0] = search.getText().toString();
        }

       // String[] idSelection = {searchID.getText().toString()};




    Cursor curser  = db.query(
                ProductHelper.ProductEntry.TABLE_NAME,
                longString,
                selection,
             selectionArgs,
                null,
                null,
                sortOrder
        );

       /*  String query = "SELECT * FROM " +  ProductHelper.ProductEntry.TABLE_NAME + " WHERE " + "(" + ProductHelper.ProductEntry.EMPLOYEE_ID + " like ? and " + ProductHelper.ProductEntry.EMPLOYEE_NAME + " like ?";
        String[] params = {"%" + search.getText().toString() + "%", "%" + searchID.getText().toString() + "%"};
        Cursor curser = db.rawQuery(query,params);
*/
        Log.v("Writing ", "here");
        List<String> prodNames = new ArrayList<>();
        List<Double> prodCosts = new ArrayList<>();
        List<Integer> prodWeght = new ArrayList<>();
        List<Integer> prodisbn = new ArrayList<>();
        //while(curser.moveToNext()){
        while(curser.moveToNext()){
            String pn = curser.getString(curser.getColumnIndexOrThrow(ProductHelper.ProductEntry.EMPLOYEE_NAME));
            Double cost = curser.getDouble(curser.getColumnIndexOrThrow(ProductHelper.ProductEntry.EMPLOYEE_PAY));
            int weight = curser.getInt(curser.getColumnIndexOrThrow(ProductHelper.ProductEntry.HOURS_WORKED));
            int isbn = curser.getInt(curser.getColumnIndexOrThrow(ProductHelper.ProductEntry.EMPLOYEE_ID));
            prodNames.add(pn);
            prodCosts.add(cost);
            prodWeght.add(weight);
            prodisbn.add(isbn);


        }
        Log.v("Writing ", "here1");
        String info="";
        int i=0;
       // textView.append("Employee_ID|Employee_Name|HourlyPay|Hours\n");
        for (; i<prodNames.size(); i++){
            info +=  prodisbn.get(i)  ;

            if(prodisbn.get(i) != null){
                info += " | " + prodNames.get(i) + " | " + prodCosts.get(i) + " | " + prodWeght.get(i) ;

            }

            Log.v("Writing", info);
            info += "\n";

        }
        Log.v("Writing ", "here2");
        search.setText("");
        Log.v("Writing ", "here3");
        textView.append(info);
        Log.v("Writing ", "here4");

    }


}
