package com.www.urban.help.vijay.urbanhelp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class airconrepairadapter extends RecyclerView.Adapter<airconrepairadapter.ViewHolderairconrepair>{

    private ArrayList<String> sellernamelist = new ArrayList<>();
    private ArrayList<String> sellerrpricelist = new ArrayList<>();
    private ArrayList<String> sellerratinglist = new ArrayList<>();
    private ArrayList<String> sellerphonelist;
    private Context airconrepaircontext;

    public airconrepairadapter(ArrayList<String> namelist, ArrayList<String> pricelist, ArrayList<String> ratinglist, ArrayList<String> phonelist,Context context) {
        this.sellernamelist = namelist;
        this.sellerrpricelist = pricelist;
        this.sellerratinglist = ratinglist;
        this.sellerphonelist = phonelist;
        airconrepaircontext = context;
    }

    @NonNull
    @Override
    public ViewHolderairconrepair onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.airconrepair,parent, false);
        ViewHolderairconrepair holder = new ViewHolderairconrepair(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderairconrepair holder, int position) {
        holder.airconrepairseller.setText(sellernamelist.get(position));
        holder.airconrepairprice.setText(sellerrpricelist.get(position));
        holder.airconrepairrating.setText(sellerratinglist.get(position));
        holder.airconbookrepair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(airconrepaircontext, sellernamelist.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return sellernamelist.size();
    }

    public class ViewHolderairconrepair extends RecyclerView.ViewHolder{
        Button airconbookrepair;
        TextView airconrepairseller;
        TextView airconrepairprice;
        TextView airconrepairrating;
        LinearLayout airconrepairparentlayout;
        public ViewHolderairconrepair(@NonNull View itemView) {
            super(itemView);

            airconbookrepair = itemView.findViewById(R.id.bookairconrepair);
            airconrepairseller = itemView.findViewById(R.id.airconrepairname);
            airconrepairprice = itemView.findViewById(R.id.priceairconrepair);
            airconrepairrating = itemView.findViewById(R.id.airconrepairrating);
        }
    }
}

