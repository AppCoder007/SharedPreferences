package com.example.donavarghese.sharedpreferences;

import android.provider.BaseColumns;

/**
 * Created by Donavarghese on 10/27/17.
 */

public final  class ProductHelper {

    private ProductHelper(){}



    public static class ProductEntry implements BaseColumns{

        public static final String TABLE_NAME = "Employee_Data";
        public static final String EMPLOYEE_NAME = "NAME";
        public static final String HOURS_WORKED = "WEIGHT";
        public static final String EMPLOYEE_PAY = "PAY";
        public static final String EMPLOYEE_ID = "ID";
    }


}
