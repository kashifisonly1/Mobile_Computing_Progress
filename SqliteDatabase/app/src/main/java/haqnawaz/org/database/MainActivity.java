package haqnawaz.org.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonAdd, buttonViewAll;
    EditText editName, editAge;
    Switch switchIsActive;
    ListView listViewCustomer;
    ArrayAdapter<CustomerModel> arrayAdapter;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonViewAll = findViewById(R.id.buttonViewAll);
        editName = findViewById(R.id.editTextName);
        editAge = findViewById(R.id.editTextAge);
        switchIsActive = findViewById(R.id.switchCustomer);
        listViewCustomer = findViewById(R.id.listViewCustomer);
        RefreshData();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            CustomerModel customerModel;

            @Override
            public void onClick(View v) {
                try {
                    customerModel = new CustomerModel(editName.getText().toString(), Integer.parseInt(editAge.getText().toString()), switchIsActive.isChecked(), 1);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                boolean b = dbHelper.addCustomer(customerModel);
                RefreshData();
            }
        });

        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RefreshData();
            }
        });
        listViewCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = listViewCustomer.getItemAtPosition(i).toString();
                String customerId = str.substring(str.lastIndexOf("id=")+3, str.lastIndexOf("}"));
                System.out.println(customerId);
                dbHelper = new DBHelper(MainActivity.this);
                dbHelper.deleteRecord(Integer.parseInt(customerId));
                RefreshData();
            }
        });
    }

    private void RefreshData() {
        DBHelper dbHelper = new DBHelper(MainActivity.this);
        List<CustomerModel> allCustomers = dbHelper.getAllRecords();
        arrayAdapter = new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1, allCustomers);
        listViewCustomer.setAdapter(arrayAdapter);
    }
}