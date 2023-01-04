package com.example.cateringbooking;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.LogPrinter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class Cart_adapter extends View {

    private AppCompatActivity context;
    private List<Pelamin_class> viewPelaminList;
    private List<Menu_class> viewMenuList;

    public Cart_adapter (AppCompatActivity context, List<Pelamin_class> viewPelaminList) {
        super(context);
//        setContentView(R.layout.list_trolly);
        this.context = context;
        this.viewPelaminList = viewPelaminList;
    }

    /*
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_trolly, null, true);

        TextView viewTypePelamin = listViewItem.findViewById(R.id.txtname);
        TextView viewPrice =  listViewItem.findViewById(R.id.txtPrice);
        Button buttonDelete = listViewItem.findViewById(R.id.buttondelete);
        ImageView image = listViewItem.findViewById(R.id.list_trolly_image);

        Pelamin_class pelaminClass = viewPelaminList.get(position);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Trolly");
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseuser = auth.getCurrentUser();
        assert firebaseuser != null;

        viewTypePelamin.setText(pelaminClass.getName());
        viewPrice.setText(pelaminClass.getPrice());
        image.setImageResource(pelaminClass.getImage());
        buttonDelete.setOnClickListener(view -> {
            ref.child(firebaseuser.getUid()).child(pelaminClass.getId()).removeValue((error, ref1) -> {
                Cart_adapter.this.remove(pelaminClass);
            });
        });

        return listViewItem;
    }
    */
}
