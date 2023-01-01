package com.example.cateringbooking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class History_adapter extends RecyclerView.Adapter<History_adapter.ViewHolder> {


    private List<Menu_class> list;
    private AppCompatActivity activity;

    public History_adapter(List<Menu_class> list, AppCompatActivity activity) {

        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public History_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull History_adapter.ViewHolder holder, int position) {

        final Menu_class menuClass = list.get(position);

        holder.textViewPackage.setText(menuClass.getPackageMenu());
        holder.textView1_Quantity.setText(menuClass.getQuantity());
        holder.textView_menu1.setText(menuClass.getMenu1());
        holder.textView_menu2.setText(menuClass.getMenu2());
        holder.textView_menu3.setText(menuClass.getMenu3());
        holder.textView_menu4.setText(menuClass.getMenu4());
        holder.textView_menu5.setText(menuClass.getMenu5());
        holder.textView_menu6.setText(menuClass.getMenu6());
        holder.textView_menu7.setText(menuClass.getMenu7());
        holder.textView_menu8.setText(menuClass.getMenu8());

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewPackage, textView1_Quantity, textView_menu1, textView_menu2, textView_menu3,
                textView_menu4, textView_menu5, textView_menu6, textView_menu7, textView_menu8;
        CardView cardView_menu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewPackage = itemView.findViewById(R.id.textViewPackage);
            textView1_Quantity = itemView.findViewById(R.id.textView1_Quantity);
            textView_menu1 = itemView.findViewById(R.id.textView_menu1);
            textView_menu2 = itemView.findViewById(R.id.textView_menu2);
            textView_menu3 = itemView.findViewById(R.id.textView_menu3);
            textView_menu4 = itemView.findViewById(R.id.textView_menu4);
            textView_menu5 = itemView.findViewById(R.id.textView_menu5);
            textView_menu6 = itemView.findViewById(R.id.textView_menu6);
            textView_menu7 = itemView.findViewById(R.id.textView_menu7);
            textView_menu8 = itemView.findViewById(R.id.textView_menu8);
            cardView_menu = itemView.findViewById(R.id.cardView_menu);

        }
    }
} // last col
