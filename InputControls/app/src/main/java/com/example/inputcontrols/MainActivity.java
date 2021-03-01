package com.example.inputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText et_name,et_mobile, et_email,et_password;
TextView tv;
RadioButton r_male,r_female;
String gender;
CheckBox ch_java,ch_android,ch_python;
Spinner sp_district,sp_mandal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name= findViewById(R.id.name);
        et_mobile=findViewById(R.id.mobile);
        tv = findViewById(R.id.result);
        et_email = findViewById(R.id.email);
        et_password = findViewById(R.id.password);
        r_male = findViewById(R.id.male);
        r_female = findViewById(R.id.female);
        ch_android=findViewById(R.id.android);
        ch_python=findViewById(R.id.python);
        ch_java=findViewById(R.id.java);
        sp_district = findViewById(R.id.district);
        sp_mandal = findViewById(R.id.mandal);

        ArrayAdapter<CharSequence> districts_adapter = ArrayAdapter.createFromResource(this,R.array.districts,android.R.layout.simple_spinner_item);
        sp_district.setAdapter(districts_adapter);


        sp_district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){

                    case 0:
                            ArrayAdapter<CharSequence> atp_mandals =
                                    ArrayAdapter.createFromResource(MainActivity.this,R.array.AnantapurMandals,android.R.layout.simple_spinner_item);

                            sp_mandal.setAdapter(atp_mandals);
                            break;

                    case 1:
                        ArrayAdapter<CharSequence> knl_mandals =
                                ArrayAdapter.createFromResource(MainActivity.this,R.array.Kurnoolmandals,android.R.layout.simple_spinner_item);

                        sp_mandal.setAdapter(knl_mandals);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    public void submit(View view) {
        String name = et_name.getText().toString();
        String mobile = et_mobile.getText().toString();
        String email = et_email.getText().toString();
        String pass = et_password.getText().toString();
        if(r_male.isChecked()){
            gender = r_male.getText().toString();
        }
        if(r_female.isChecked()){
            gender =r_female.getText().toString();
        }
        StringBuilder builder = new StringBuilder();
        if(ch_java.isChecked()){
            builder.append(ch_java.getText().toString()+",");

        }
        if(ch_android.isChecked()){
            builder.append(ch_android.getText().toString()+",");
        }
        if(ch_python.isChecked()){
            builder.append(ch_python.getText().toString());
        }
        String selectedDistrict = sp_district.getSelectedItem().toString();
        String selectedMandal = sp_mandal.getSelectedItem().toString();

        tv.setText(name+"\n"+mobile+"\n"+email+"\n"+pass+"\n"+gender+"\n"+builder+"\n"+selectedDistrict+"\n"+selectedMandal);


    }
}