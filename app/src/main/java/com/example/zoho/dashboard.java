package com.example.zoho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dashboard extends AppCompatActivity {
    EditText name;
    EditText email;
    EditText phone;
    Button addcontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        phone = findViewById(R.id.etphone);
        addcontact = findViewById(R.id.btnAdd);

        addcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !phone
                .getText().toString().isEmpty()) {

                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                    intent.putExtra(ContactsContract.Intents.Insert.NAME, name.getText().toString());
                    intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email.getText().toString());
                    intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone.getText().toString());
                    if (intent.resolveActivity(getPackageManager()) != null ) {
                        startActivity(intent);
                    }else {
                        Toast.makeText(dashboard.this,"there is an error",Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(dashboard.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}