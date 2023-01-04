package com.example.cateringbooking;

import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {

    BottomNavigationView bottomNav;
    private LinearLayout listViewPelamin;
    private List<Pelamin_class> viewPelaminList;
    private List<Menu_class> viewMenuList;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        //bar
        getSupportActionBar().setTitle("Cart");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#F44336"));
        actionBar.setBackgroundDrawable(colorDrawable);

        //bottom bar
        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setSelectedItemId(R.id.page2);
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

        listViewPelamin = findViewById(R.id.listViewPelamin);

        viewPelaminList = new ArrayList<>();
        viewMenuList = new ArrayList<>();
        getDataPelamin();
        getDataMenu();
    } // sec col

    private void getDataPelamin() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseuser = auth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Trolly");

        myRef.child(firebaseuser.getUid()).get().addOnCompleteListener((task) -> {
           for(final DataSnapshot pelamin : task.getResult().getChildren()){
               Pelamin_class pelaminClass = pelamin.getValue(Pelamin_class.class);
               View view = getLayoutInflater().inflate(R.layout.list_trolly, listViewPelamin);
               TextView viewTypePelamin = view.findViewById(R.id.txtname);
               TextView viewPrice =  view.findViewById(R.id.txtPrice);
               Button buttonDelete = view.findViewById(R.id.buttondelete);
               ImageView image = view.findViewById(R.id.list_trolly_image);

               assert pelaminClass != null;
               viewTypePelamin.setText(pelaminClass.getName());
               viewPrice.setText(pelaminClass.getPrice());
               image.setImageResource(pelaminClass.getImage());
               buttonDelete.setOnClickListener(v -> {
                   pelamin.getRef().removeValue((error, ref1) -> {
                       listViewPelamin.removeView(view);
                   });
               });
           }
        });
//        myRef.child(firebaseuser.getUid()).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                viewPelaminList.clear();
//
//                for (DataSnapshot bookPLotSnapshot : snapshot.getChildren()) {
//
//                    Pelamin_class pelaminClass = bookPLotSnapshot.getValue(Pelamin_class.class);
//                    pelaminClass.setId(bookPLotSnapshot.getKey());
//                    viewPelaminList.add(pelaminClass);
//                }
////                Cart_adapter cartAdapter = new Cart_adapter(Cart.this, viewPelaminList);
////                listViewPelamin.setAdapter(cartAdapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

    }
    private void getDataMenu() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseuser = auth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Menu");
        myRef.child(firebaseuser.getUid()).get().addOnCompleteListener((task) -> {
           DataSnapshot snapshot = task.getResult();
           for(final DataSnapshot menu : snapshot.getChildren()){
               Menu_class menuClass = menu.getValue(Menu_class.class);
               View view = getLayoutInflater().inflate(R.layout.list_menu, listViewPelamin);
               ((TextView)view.findViewById(R.id.textViewPackage)).setText(menuClass.getPackageMenu());
               ((TextView)view.findViewById(R.id.textView1_Quantity)).setText(menuClass.getQuantity());
               ((TextView)view.findViewById(R.id.textView_menu1)).setText(menuClass.getMenu1());
               ((TextView)view.findViewById(R.id.textView_menu2)).setText(menuClass.getMenu2());
               ((TextView)view.findViewById(R.id.textView_menu3)).setText(menuClass.getMenu3());
               ((TextView)view.findViewById(R.id.textView_menu4)).setText(menuClass.getMenu4());
               ((TextView)view.findViewById(R.id.textView_menu5)).setText(menuClass.getMenu5());
               ((TextView)view.findViewById(R.id.textView_menu6)).setText(menuClass.getMenu6());
               ((TextView)view.findViewById(R.id.textView_menu7)).setText(menuClass.getMenu7());
               ((TextView)view.findViewById(R.id.textView_menu8)).setText(menuClass.getMenu8());
           }
        });
    }

} // last col