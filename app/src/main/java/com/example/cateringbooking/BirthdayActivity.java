package com.example.cateringbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class BirthdayActivity extends AppCompatActivity {

    private Button button_ChooseDateBooking;
    private EditText editText_ChooseDateBooking;
    private DatePickerDialog picker;
    private BottomNavigationView bottomNav, topNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);

        //bar
        getSupportActionBar().setTitle("Birthday");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#F44336"));
        actionBar.setBackgroundDrawable(colorDrawable);

        editText_ChooseDateBooking = findViewById(R.id.editText_ChooseDateBooking);
        button_ChooseDateBooking = findViewById(R.id.button_ChooseDateBooking);

        //Setting up datepicker
        editText_ChooseDateBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                //date picker dialog
                picker = new DatePickerDialog(BirthdayActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editText_ChooseDateBooking.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                picker.show();
            }
        });

        button_ChooseDateBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textDate = editText_ChooseDateBooking.getText().toString();

                if (TextUtils.isEmpty(textDate)) {
                    Toast.makeText(BirthdayActivity.this, "Please insert your date of booking", Toast.LENGTH_SHORT).show();
                    editText_ChooseDateBooking.setError("Date of Booking is required");
                    editText_ChooseDateBooking.requestFocus();
                }
                else {

                    addUserDateBooking(textDate);
                }
            }
        });

        //top bar
        topNav = findViewById(R.id.topNav);
        topNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.page1:
                        startActivity(new Intent(getApplicationContext(),BirthdayActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.page2:
                        startActivity(new Intent(getApplicationContext(),ChooseShopBirthday.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        //bottom bar
        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.page1:
                        startActivity(new Intent(getApplicationContext(),HomePage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.page2:
                        startActivity(new Intent(getApplicationContext(),Cart.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.page3:
                        startActivity(new Intent(getApplicationContext(),History.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.page4:
                        startActivity(new Intent(getApplicationContext(),Notification.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.page5:
                        startActivity(new Intent(getApplicationContext(),UserProfile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    } // sec col

    private void addUserDateBooking(String textDate) {

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseuser = auth.getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Booking Date");
        String id = reference.push().getKey();

        BirthdayBookingClass birthdayBookingClass = new BirthdayBookingClass(id, textDate, null, null);

        reference.child(firebaseuser.getUid()).child(id).setValue(birthdayBookingClass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                Toast.makeText(BirthdayActivity.this, "Choose Your Date", Toast.LENGTH_LONG).show();
                Intent intent = new Intent (BirthdayActivity.this, ChooseShopBirthdayBooking.class);
                startActivity(intent);
            }
        });

    }

} // last col