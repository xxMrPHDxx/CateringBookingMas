package com.example.cateringbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChooseShopBirthdayBooking extends AppCompatActivity implements View.OnClickListener {

    private CardView grid3;
    private TextView txtGrid3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_shop_birthday_booking);

        //bar
        getSupportActionBar().setTitle("Choose Shop Birthday Booking");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#F44336"));
        actionBar.setBackgroundDrawable(colorDrawable);

        txtGrid3 = findViewById(R.id.txtGrid3);

        //card view * add from here*
        grid3 = findViewById(R.id.grid3);
        grid3.setOnClickListener(this);

        grid3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textShop = txtGrid3.getText().toString();

                if (TextUtils.isEmpty(textShop)) {
                    Toast.makeText(ChooseShopBirthdayBooking.this, "Choose the shop", Toast.LENGTH_SHORT).show();
                    txtGrid3.setError("Choose the shop is required");
                    txtGrid3.requestFocus();
                }
                else {
                    addUserShopBooking(textShop);
                }
            }
        });

    } // sec col

    private void addUserShopBooking(String shop) {

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseuser = auth.getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Shop");
        String id = reference.push().getKey();

        BirthdayBookingClass birthdayBookingClass = new BirthdayBookingClass(null, null, shop, null);

        reference.child(firebaseuser.getUid()).child(shop).setValue(birthdayBookingClass).addOnCompleteListener( new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<Void> task) {

                Toast.makeText(ChooseShopBirthdayBooking.this, "AJ Catering", Toast.LENGTH_LONG).show();
                Intent intent = new Intent (ChooseShopBirthdayBooking.this, ShopBirthday1.class);
                startActivity(intent);
            }
        });

    }

    //card view
    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {

            case R.id.grid3:
                i = new Intent(this, ShopBirthday1.class);
                startActivity(i);
                break;

        }
    }

} // last col