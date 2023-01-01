package com.example.cateringbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cateringbooking.activities.LoginActivity;
import com.example.cateringbooking.activities.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DeleteUserProfile extends AppCompatActivity {

    private FirebaseAuth authProfile;
    private FirebaseUser firebaseUser;
    private TextView textViewAuthenticated;
    private EditText editTextUserPwd;
    private ProgressBar progressBar;
    private String userPwd;
    private Button buttonReAuthenticate, buttonDeleteUser;
    private static  final String TAG = "DeleteProfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user_profile);
        //bar
        getSupportActionBar().setTitle("Delete Profile");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#F44336"));
        actionBar.setBackgroundDrawable(colorDrawable);

        progressBar = findViewById(R.id.progressBar);
        editTextUserPwd = findViewById(R.id.editText_delete_user_pwd);
        textViewAuthenticated = findViewById(R.id.textView_delete_user_authenticated);
        buttonDeleteUser = findViewById(R.id.button_delete_user);
        buttonReAuthenticate = findViewById(R.id.button_delete_user_authenticate);

        buttonDeleteUser.setEnabled(false);

        authProfile = FirebaseAuth.getInstance();
        firebaseUser = authProfile.getCurrentUser();

        if(firebaseUser.equals("")) {

            Toast.makeText(DeleteUserProfile.this, "Something went wrong" + "User details are not available at the moment", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DeleteUserProfile.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            reAuthenticatedUser(firebaseUser);
        }

    } //secondcol

    private void reAuthenticatedUser(FirebaseUser firebaseUser) {

        buttonReAuthenticate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPwd = editTextUserPwd.getText().toString();

                if(TextUtils.isEmpty(userPwd)) {
                    Toast.makeText(DeleteUserProfile.this, "Password is needed", Toast.LENGTH_SHORT).show();
                    editTextUserPwd.setError("Please enter your current password to authenticate");
                    editTextUserPwd.requestFocus();
                }
                else {
                    progressBar.setVisibility(View.VISIBLE);

                    //reauthenticate user now
                    AuthCredential credential = EmailAuthProvider.getCredential(firebaseUser.getEmail(), userPwd);

                    firebaseUser.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                progressBar.setVisibility(View.GONE);

                                //disable edittext for current password. enable for new password
                                editTextUserPwd.setEnabled(false);

                                buttonReAuthenticate.setEnabled(false);
                                buttonDeleteUser.setEnabled(true);

                                textViewAuthenticated.setText("You are authenticated/verified." +
                                        "You can delete your profile and related data now!");
                                Toast.makeText(DeleteUserProfile.this, "Password has been verified." +
                                        "You can delete your profile now.Be careful, this action is iirreversible", Toast.LENGTH_SHORT).show();

                                //change password update color
                                buttonDeleteUser.setBackgroundTintList(ContextCompat.getColorStateList(DeleteUserProfile.this, R.color.purple_200));

                                buttonDeleteUser.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        showAlertDialog();
                                    }
                                });
                            }
                            else {
                                try {
                                    throw task.getException();
                                } catch (Exception e) {
                                    Toast.makeText(DeleteUserProfile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                            progressBar.setVisibility(View.GONE);
                        }
                    });
                }
            }
        });
    }

    private void showAlertDialog(){
        //setup the alert buider
        AlertDialog.Builder builder = new AlertDialog.Builder(DeleteUserProfile.this);
        builder.setTitle("Delete user and related data");
        builder.setMessage("Do you really want to delete your profile and related data? This action is irreversible!");

        //Open email apps if user click/tap continue button
        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                deleteUser(firebaseUser);
            }
        });

        //return to user profile
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(DeleteUserProfile.this, UserProfile.class);
                startActivity(intent);
                finish();

            }
        });

        //Create the alertdialog
        AlertDialog alertDialog = builder.create();

        //change button color
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.purple_200));
            }
        });

        //show alert
        alertDialog.show();
    }

    private void deleteUser(FirebaseUser firebaseUser) {

        firebaseUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {

                    deleteUserData();

                    authProfile.signOut();
                    Toast.makeText(DeleteUserProfile.this, "User has been deleted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DeleteUserProfile.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    try {
                        throw task.getException();
                    } catch (Exception e) {
                        Toast.makeText(DeleteUserProfile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void deleteUserData() {

        //delete path display pic
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        StorageReference storageReference = firebaseStorage.getReferenceFromUrl(firebaseUser.getPhotoUrl().toString());
        storageReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                Log.d(TAG, "OnSuccess: Photo Deleted");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Log.d(TAG, e.getMessage());
                Toast.makeText(DeleteUserProfile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //delete data from realtime databse
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Register Users");
        databaseReference.child(firebaseUser.getUid()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

                Log.d(TAG, "OnSuccess: User Data Deleted");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Log.d(TAG, e.getMessage());
                Toast.makeText(DeleteUserProfile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //delete data from realtime databse
        databaseReference = FirebaseDatabase.getInstance().getReference("Book Plot User");
        databaseReference.child(firebaseUser.getUid()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

                Log.d(TAG, "OnSuccess: User Data Deleted");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Log.d(TAG, e.getMessage());
                Toast.makeText(DeleteUserProfile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //delete data from realtime databse
        databaseReference = FirebaseDatabase.getInstance().getReference("Harvest User");
        databaseReference.child(firebaseUser.getUid()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

                Log.d(TAG, "OnSuccess: User Data Deleted");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Log.d(TAG, e.getMessage());
                Toast.makeText(DeleteUserProfile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //delete data from realtime databse
        databaseReference = FirebaseDatabase.getInstance().getReference("Task User");
        databaseReference.child(firebaseUser.getUid()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

                Log.d(TAG, "OnSuccess: User Data Deleted");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Log.d(TAG, e.getMessage());
                Toast.makeText(DeleteUserProfile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
} //firstcol