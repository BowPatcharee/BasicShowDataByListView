package com.example.patcharee.basicshowdatabylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final DBHelper db = new DBHelper(this,null,null,0);
       final ArrayList<HashMap<String ,String>> CustomerLists = db.getCustomerLists();

       ListView lsvCustomers = (ListView) findViewById(R.id.lsvCutomers);
       SimpleAdapter adt = new SimpleAdapter(MainActivity.this,
               CustomerLists, R.layout.lsv_item,
               new String[]{"CustomerID", "FullName"},
               new int[]{R.id.tvCustomerID,R.id.tvFullName});

       lsvCustomers.setAdapter(adt);
       lsvCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String sctCustomerID = CustomerLists.get(position).get("CustomerID");
               String sctFullName = CustomerLists.get(position).get("FullName");

               String str = sctCustomerID + " " + sctFullName;
               Toast.makeText(MainActivity.this," รายการที่ถูกเลือก :" + str,Toast.LENGTH_SHORT).show();

           }
       });


    }//void
}//main
