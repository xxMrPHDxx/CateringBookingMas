package com.example.cateringbooking;

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

public class ShopBirthday1ExtraOption extends AppCompatActivity {

    private BottomNavigationView topNav, bottomNav;
    private TextView packagemenu1, packagemenu2, packagemenu3, menuprice1, menuprice2, menuprice3;
    private Button addcart1, addcart2, addcart3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_birthday1_extra_option);

        //bar
        getSupportActionBar().setTitle("Birthday Extra Option");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#F44336"));
        actionBar.setBackgroundDrawable(colorDrawable);

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

        packagemenu1 = findViewById(R.id.packagemenu1);
        packagemenu2 = findViewById(R.id.packagemenu2);
        packagemenu3 = findViewById(R.id.packagemenu3);
        menuprice1 = findViewById(R.id.price1);
        menuprice2 = findViewById(R.id.price2);
        menuprice3 = findViewById(R.id.price3);
        addcart1 = findViewById(R.id.addcart1);
        addcart2 = findViewById(R.id.addcart2);
        addcart3 = findViewById(R.id.addcart3);

        addcart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pelamin1 = packagemenu1.getText().toString();
                String price1 = menuprice1.getText().toString();

                addPelamin1 (pelamin1, price1);
            }
        });

        addcart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pelamin2 = packagemenu2.getText().toString();
                String price2 = menuprice2.getText().toString();

                addPelamin2 (pelamin2, price2);
            }
        });

        addcart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pelamin3 = packagemenu3.getText().toString();
                String price3 = menuprice3.getText().toString();

                addPelamin3 (pelamin3, price3);
            }
        });

    } // sec col

    private void addPelamin1(String pelamin1, String price1) {

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseuser = auth.getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Trolly");
        String key = reference.push().getKey();

        ShopBirthday1ExtraOptionClass shopBirthday1ExtraOptionClass = new ShopBirthday1ExtraOptionClass(key, pelamin1, price1);

        reference.child(firebaseuser.getUid()).child(key).setValue(shopBirthday1ExtraOptionClass).addOnCompleteListener( new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                Toast.makeText(ShopBirthday1ExtraOption.this, "add to trolly", Toast.LENGTH_LONG).show();
                Intent intent = new Intent (ShopBirthday1ExtraOption.this, ShopBirthday1ExtraOption.class);
                startActivity(intent);
            }
        });
    }

    private void addPelamin2(String pelamin2, String price2 ) {

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseuser = auth.getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Trolly");
        String key = reference.push().getKey();

        ShopBirthday1ExtraOptionClass shopBirthday1ExtraOptionClass = new ShopBirthday1ExtraOptionClass(key, pelamin2, price2);

        reference.child(firebaseuser.getUid()).child(key).setValue(shopBirthday1ExtraOptionClass).addOnCompleteListener( new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                Toast.makeText(ShopBirthday1ExtraOption.this, "add to trolly", Toast.LENGTH_LONG).show();
                Intent intent = new Intent (ShopBirthday1ExtraOption.this, ShopBirthday1ExtraOption.class);
                startActivity(intent);
            }
        });
    }

    private void addPelamin3(String pelamin3, String price3 ) {

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseuser = auth.getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Trolly");
        String key = reference.push().getKey();

        ShopBirthday1ExtraOptionClass shopBirthday1ExtraOptionClass = new ShopBirthday1ExtraOptionClass(key, pelamin3, price3);

        reference.child(firebaseuser.getUid()).child(key).setValue(shopBirthday1ExtraOptionClass).addOnCompleteListener( new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                Toast.makeText(ShopBirthday1ExtraOption.this, "add to trolly", Toast.LENGTH_LONG).show();
                Intent intent = new Intent (ShopBirthday1ExtraOption.this, ShopBirthday1ExtraOption.class);
                startActivity(intent);
            }
        });
    }

} // last col