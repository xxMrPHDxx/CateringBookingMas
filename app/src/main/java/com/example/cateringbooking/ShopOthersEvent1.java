package com.example.cateringbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ShopOthersEvent1 extends AppCompatActivity {

    private RelativeLayout RL1, RL2, RL3, RL4, RL5;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_others_event1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        RL1 = findViewById(R.id.RL1);
        RL2 = findViewById(R.id.RL2);
        RL3 = findViewById(R.id.RL3);
        RL4 = findViewById(R.id.RL4);
        RL5 = findViewById(R.id.RL5);

        RL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ShopOthersEvent1.this, ShopOthersEvent1AboutUs.class);
                startActivity(intent);

            }
        });

        RL2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ShopOthersEvent1.this, ShopOthersEvent1Menu.class);
                startActivity(intent);

            }
        });

        RL3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ShopOthersEvent1.this, ShopOthersEvent1ExtraOption.class);
                startActivity(intent);

            }
        });

        RL4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ShopOthersEvent1.this, ShopOthersEvent1Voucher.class);
                startActivity(intent);

            }
        });

        RL5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ShopOthersEvent1.this, ShopOthersEvent1Feedback.class);
                startActivity(intent);

            }
        });

        //bottom bar
        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setSelectedItemId(R.id.page1);
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

} //last col