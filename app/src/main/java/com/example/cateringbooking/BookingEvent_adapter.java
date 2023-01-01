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

public class BookingEvent_adapter extends RecyclerView.Adapter<BookingEvent_adapter.ViewHolder>{

    private List<ChooseDateBooking_Class> list;
    private AppCompatActivity activity;

    public BookingEvent_adapter(List<ChooseDateBooking_Class> list, AppCompatActivity activity) {

        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public BookingEvent_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_booking, parent, false);
        return new BookingEvent_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingEvent_adapter.ViewHolder holder, int position) {

        final ChooseDateBooking_Class taskClass = list.get(position);

        holder.textView1_name.setText(taskClass.getShop());
        holder.textView1_date.setText(taskClass.getDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView1_name, textView1_date;
        CardView cardView_booking;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1_name = itemView.findViewById(R.id.textView1_name);
            textView1_date = itemView.findViewById(R.id.textView1_date);
            cardView_booking = itemView.findViewById(R.id.cardView_booking);

        }
    }
}
