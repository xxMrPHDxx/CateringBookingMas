package com.example.cateringbooking;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ExtraOption extends AppCompatActivity {

    BottomNavigationView topNav, bottomNav;
    TextView txtPelamin1, txtPelamin2, txtPrice1, txtPrice2;
    Button addcart1, addcart2;
    ImageView imgPelamin1, imgPelamin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_option);

        //bar
        getSupportActionBar().setTitle("Pelamin");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#F44336"));
        actionBar.setBackgroundDrawable(colorDrawable);

        //top bar
        topNav = findViewById(R.id.topNav);
        topNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.page1:
                        startActivity(new Intent(getApplicationContext(),ExtraOption.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.page2:
                        startActivity(new Intent(getApplicationContext(),Canopy.class));
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

        txtPelamin1 = findViewById(R.id.txtPelamin);
        txtPelamin2 = findViewById(R.id.txtPelamin2);
        txtPrice1 = findViewById(R.id.txtPrice);
        txtPrice2 = findViewById(R.id.txtPrice2);
        addcart1 = findViewById(R.id.addcart1);
        addcart2 = findViewById(R.id.addcart2);

        addcart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pelamin1 = txtPelamin1.getText().toString();
                String price1 = txtPrice1.getText().toString();

                addPelamin1 (pelamin1, price1);
            }
        });

        addcart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pelamin2 = txtPelamin2.getText().toString();
                String price2 = txtPrice2.getText().toString();

                addPelamin2 (pelamin2, price2);
            }
        });

    } // sec col

    private void addPelamin1(String pelamin1, String price1) {

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseuser = auth.getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Trolly");
        String key = reference.push().getKey();

        Pelamin_class pelaminClass = new Pelamin_class(key, R.drawable.pelamin1, pelamin1, price1);

        reference.child(firebaseuser.getUid()).child("1").setValue(pelaminClass).addOnCompleteListener( new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                Toast.makeText(ExtraOption.this, "Booking Pelamin 1 success", Toast.LENGTH_LONG).show();
                Intent intent = new Intent (ExtraOption.this, Cart.class);
                startActivity(intent);
            }
        });
    }

    private void addPelamin2(String pelamin2, String price2 ) {

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseuser = auth.getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Trolly");
        String key = reference.push().getKey();

        Pelamin_class pelaminClass = new Pelamin_class(key, R.drawable.pelamin2, pelamin2, price2);

        reference.child(firebaseuser.getUid()).child("2").setValue(pelaminClass).addOnCompleteListener( new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                Toast.makeText(ExtraOption.this, "Booking Pelamin 2 success", Toast.LENGTH_LONG).show();
                Intent intent = new Intent (ExtraOption.this, Cart.class);
                startActivity(intent);
            }
        });
    }

} //last col