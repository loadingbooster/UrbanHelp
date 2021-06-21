package com.www.urban.help.vijay.urbanhelp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class geyserinstalladapter extends RecyclerView.Adapter<geyserinstalladapter.Viewholdergeyserinstal>{

    private ArrayList<String> gyserinstallnamelist = new ArrayList<>();
    private ArrayList<String> geyserinstallpricelist = new ArrayList<>();
    private ArrayList<String> geyserinstallratinglist = new ArrayList<>();
    private Context geyserinstallcontext;

    public geyserinstalladapter(ArrayList<String> gyserinstallnamelist, ArrayList<String> geyserinstallpricelist, ArrayList<String> geyserinstallratinglist, Context geyserinstallcontext) {
        this.gyserinstallnamelist = gyserinstallnamelist;
        this.geyserinstallpricelist = geyserinstallpricelist;
        this.geyserinstallratinglist = geyserinstallratinglist;
        this.geyserinstallcontext = geyserinstallcontext;
    }

    @NonNull
    @Override
    public Viewholdergeyserinstal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.geyserinstall,parent,false);
        Viewholdergeyserinstal holder = new Viewholdergeyserinstal(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholdergeyserinstal holder, int position) {
        holder.geyserinstallsellername.setText(gyserinstallnamelist.get(position));
        holder.geyserinstallprice.setText(geyserinstallpricelist.get(position));
        holder.geyserinstallratings.setText(geyserinstallratinglist.get(position));
        holder.geyserintallbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholdergeyserinstal extends RecyclerView.ViewHolder{
        TextView geyserinstallsellername,geyserinstallprice,geyserinstallratings;
        Button geyserintallbutton;

        public Viewholdergeyserinstal(@NonNull View itemView) {
            super(itemView);
            geyserinstallsellername = itemView.findViewById(R.id.geyserservicename);
            geyserinstallprice = itemView.findViewById(R.id.geyserinstallprice);
            geyserinstallratings = itemView.findViewById(R.id.geyserinstallrating);
            geyserintallbutton = itemView.findViewById(R.id.geyserinstallbutton);
        }
    }
}
