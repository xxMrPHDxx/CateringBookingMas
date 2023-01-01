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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChooseShop extends AppCompatActivity implements View.OnClickListener {

    private CardView grid1, grid2, grid3, grid4;
    private TextView txtGrid2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_shop);

        //bar
        getSupportActionBar().setTitle("Choose Shop");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#F44336"));
        actionBar.setBackgroundDrawable(colorDrawable);

        txtGrid2 = findViewById(R.id.txtGrid2);

        //card view * add from here*
        grid2 = (CardView) findViewById(R.id.grid2);
        grid2.setOnClickListener(this);

        grid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textShop = txtGrid2.getText().toString();

                if (TextUtils.isEmpty(textShop)) {
                    Toast.makeText(ChooseShop.this, "Choose the shop", Toast.LENGTH_SHORT).show();
                    txtGrid2.setError("Choose the shop is required");
                    txtGrid2.requestFocus();
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

        ChooseDateBooking_Class chooseDateBookingClass = new ChooseDateBooking_Class(null, null,shop);

        reference.child(firebaseuser.getUid()).child(shop).setValue(chooseDateBookingClass).addOnCompleteListener( new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<Void> task) {

                Toast.makeText(ChooseShop.this, "Kak Nie Yong", Toast.LENGTH_LONG).show();
                Intent intent = new Intent (ChooseShop.this, Wedding2.class);
                startActivity(intent);
            }
        });

    }

    //card view
    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {

            case R.id.grid2:
                i = new Intent(this, Wedding2.class);
                startActivity(i);
                break;

          /*    case R.id.grid2:
                i = new Intent(this, Weeding2.class);
                startActivity(i);
                break;

            case R.id.grid4:
                i = new Intent(this, Weeding2.class);
                startActivity(i);
                break;

           */

        }
    }

} // last col