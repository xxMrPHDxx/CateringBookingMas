package com.example.cateringbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WeddingEvent extends AppCompatActivity implements View.OnClickListener {

    private CardView grid1, grid2, grid3, grid4;
    BottomNavigationView bottomNav, topNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wedding_event);

        //bar
        getSupportActionBar().setTitle("Wedding");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#F44336"));
        actionBar.setBackgroundDrawable(colorDrawable);

        //top bar
        topNav = findViewById(R.id.topNav);
        topNav.setSelectedItemId(R.id.page2);
        topNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.page1:
                        startActivity(new Intent(getApplicationContext(),ChooseBookingDate.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.page2:
                        startActivity(new Intent(getApplicationContext(),WeddingEvent.class));
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

        //card view * add from here*
        grid2 = (CardView) findViewById(R.id.grid2);
        grid2.setOnClickListener(this);

    } // sec col

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

}// last col