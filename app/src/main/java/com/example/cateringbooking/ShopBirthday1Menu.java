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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShopBirthday1Menu extends AppCompatActivity {

    int minteger = 0;
    int minteger2 = 0;
    BottomNavigationView bottomNav;
    private Button addcart1, addcart2;
    private TextView packagemenu1, integer_number, txtMenu1, txtMenu2, txtMenu3, txtMenu4, txtMenu5, txtMenu6, txtMenu7, txtMenu8;
    private TextView packagemenu2, integer_number2, txtMenu21, txtMenu22, txtMenu23, txtMenu24, txtMenu25, txtMenu26, txtMenu27, txtMenu28;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_birthday1_menu);

        //bar
        getSupportActionBar().setTitle("Menu Birthday");
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

        //menu 1
        txtMenu1 = findViewById(R.id.txtMenu1);
        txtMenu2 = findViewById(R.id.txtMenu2);
        txtMenu3 = findViewById(R.id.txtMenu3);
        txtMenu4 = findViewById(R.id.txtMenu4);
        packagemenu1 = findViewById(R.id.packagemenu1);
        integer_number = findViewById(R.id.integer_number);
        addcart1 = findViewById(R.id.addcart1);

        addcart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String packagemenu = packagemenu1.getText().toString();
                String quantity = integer_number.getText().toString();
                String textView1 = txtMenu1.getText().toString();
                String textView2 = txtMenu2.getText().toString();
                String textView3 = txtMenu3.getText().toString();
                String textView4 = txtMenu4.getText().toString();

                addmenu1(packagemenu, quantity, textView1,textView2, textView3, textView4);
            }
        });

        //menu 2
        txtMenu21 = findViewById(R.id.txtMenu21);
        txtMenu22 = findViewById(R.id.txtMenu22);
        txtMenu23 = findViewById(R.id.txtMenu23);
        txtMenu24 = findViewById(R.id.txtMenu24);
        packagemenu2 = findViewById(R.id.packagemenu2);
        integer_number2 = findViewById(R.id.integer_number2);
        addcart2 = findViewById(R.id.addcart2);

        addcart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String packageMenu = packagemenu2.getText().toString();
                String quantity2 = integer_number2.getText().toString();
                String textView21 = txtMenu21.getText().toString();
                String textView22 = txtMenu22.getText().toString();
                String textView23 = txtMenu23.getText().toString();
                String textView24 = txtMenu24.getText().toString();

                addmenu2(packageMenu, quantity2, textView21,textView22, textView23, textView24);
            }
        });

    } // sec col

    //add menu
    private void addmenu1 (String packagemenu1, String quantity, String textView1, String textView2,
                           String textView3, String textView4) {

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseuser = auth.getCurrentUser();
        DatabaseReference referencePlot = FirebaseDatabase.getInstance().getReference("Menu");
        String id = referencePlot.push().getKey();

        MenuBirthdayClass menuBirthdayClass = new MenuBirthdayClass(id, packagemenu1, quantity, textView1, textView2,
                textView3, textView4);

        referencePlot.child(firebaseuser.getUid()).child(id).setValue(menuBirthdayClass).addOnCompleteListener( new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                Toast.makeText(ShopBirthday1Menu.this, "Add Menu A", Toast.LENGTH_LONG).show();

                Intent intent = new Intent (ShopBirthday1Menu.this, ShopBirthday1Menu.class);
                startActivity(intent);
            }
        });
    }

    //add menu2
    private void addmenu2 (String packageMenu, String quantity, String textView21, String textView22,
                           String textView23, String textView24) {

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseuser = auth.getCurrentUser();
        DatabaseReference referencePlot = FirebaseDatabase.getInstance().getReference("Menu");
        String id = referencePlot.push().getKey();

        MenuBirthdayClass menuBirthdayClass = new MenuBirthdayClass(id, packageMenu, quantity, textView21, textView22,
                textView23, textView24);

        referencePlot.child(firebaseuser.getUid()).child(id).setValue(menuBirthdayClass).addOnCompleteListener( new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                Toast.makeText(ShopBirthday1Menu.this, "Add Menu B", Toast.LENGTH_LONG).show();

                Intent intent = new Intent (ShopBirthday1Menu.this, ShopBirthday1Menu.class);
                startActivity(intent);
            }
        });
    }

    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.integer_number);
        displayInteger.setText("" + number);
    }

    //menu 2
    public void increaseInteger2(View view) {
        minteger2 = minteger2 + 1;
        display2(minteger2);

    }public void decreaseInteger2(View view) {
        minteger2 = minteger2 - 1;
        display2(minteger2);
    }

    private void display2(int number) {
        TextView displayInteger2 = (TextView) findViewById(
                R.id.integer_number2);
        displayInteger2.setText("" + number);
    }

} // last col