package com.example.recyclerviewkullanimi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewTasarimNesneleriniTutucu>{
    private Context mContext;
    private List<String> olkelerDisaridanGelenList;

    public RVAdapter(Context mContext, List<String> olkelerDisaridanGelenList) {
        this.mContext = mContext;
        this.olkelerDisaridanGelenList = olkelerDisaridanGelenList;
    }



    public class CardViewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder{
        public TextView setirYazi;
        public CardView setirCardView;
        public ImageView noqteImage;

        public CardViewTasarimNesneleriniTutucu (View view){
            super(view);
            setirYazi = view.findViewById(R.id.setirYazi);
            setirCardView = view.findViewById(R.id.setirCardView);
            noqteImage = view.findViewById(R.id.noqteImage);

        }
    }

    @NonNull
    @Override
    public CardViewTasarimNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_tasarim,parent,false);
        return new CardViewTasarimNesneleriniTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewTasarimNesneleriniTutucu holder, int position) {
        String olke = olkelerDisaridanGelenList.get(position);

        holder.setirYazi.setText(olke);

        holder.setirCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"Secdiyiniz olke : "+olke,Toast.LENGTH_SHORT).show();
            }
        });

        holder.noqteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext,"Image : "+olke,Toast.LENGTH_SHORT).show();

                PopupMenu popup = new PopupMenu(mContext, holder.noqteImage);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.card_menu,popup.getMenu());
                popup.show();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.action_sil:
                                Toast.makeText(mContext,"Sil secildi : "+olke,Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.action_redakte:
                                Toast.makeText(mContext,"Redakte secildi : "+olke,Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }

                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return olkelerDisaridanGelenList.size();
    }



}
