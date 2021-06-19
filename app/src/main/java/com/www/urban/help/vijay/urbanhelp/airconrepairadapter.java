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

    private ArrayList<String> airconrepairnamelist = new ArrayList<>();
    private ArrayList<String> airconrepairpricelist = new ArrayList<>();
    private ArrayList<String> airconrepairratinglist = new ArrayList<>();
    private Context airconrepaircontext;

    public airconrepairadapter(ArrayList<String> airconrepairnamelist, ArrayList<String> airconrepairpricelist, ArrayList<String> airconrepairratinglist, Context context) {
        this.airconrepairnamelist = airconrepairnamelist;
        this.airconrepairpricelist = airconrepairpricelist;
        this.airconrepairratinglist = airconrepairratinglist;
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
        holder.airconrepairseller.setText(airconrepairnamelist.get(position));
        holder.airconrepairprice.setText(airconrepairpricelist.get(position));
        holder.airconrepairrating.setText(airconrepairratinglist.get(position));
        holder.airconbookrepair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(airconrepaircontext, airconrepairnamelist.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return airconrepairnamelist.size();
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

