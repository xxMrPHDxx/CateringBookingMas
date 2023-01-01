package com.example.cateringbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BookingEvent extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ChooseDateBooking_Class> listBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_event);

        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayout);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        readNameBooking();

    } // sec col

    private void readNameBooking() {

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseuser = auth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Booking User");

        myRef.child(firebaseuser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                listBooking = new ArrayList<>();

                for (DataSnapshot taskSnapshot : snapshot.getChildren()) {

                    ChooseDateBooking_Class chooseDateBookingClass = taskSnapshot.getValue(ChooseDateBooking_Class.class);
                    chooseDateBookingClass.setIdChooseDateBookingg(taskSnapshot.getKey());
                    listBooking.add(chooseDateBookingClass);
                }

                BookingEvent_adapter bookingEvent_adapter = new BookingEvent_adapter(listBooking, BookingEvent.this);
                recyclerView.setAdapter(bookingEvent_adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
    }

} // last col