package com.www.urban.help.vijay.urbanhelp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class airconserviceadapter extends RecyclerView.Adapter<airconserviceadapter.Viewholderairconserice>{


    private ArrayList<String> airconservicenamelist = new ArrayList<>();
    private ArrayList<String> airconservicepricelist = new ArrayList<>();
    private ArrayList<String> airconserviceratinglist = new ArrayList<>();
    private Context airconservicecontext;

    public airconserviceadapter(ArrayList<String> airconservicenamelist, ArrayList<String> airconservicepricelist, ArrayList<String> airconserviceratinglist, Context airconservicecontext) {
        this.airconservicenamelist = airconservicenamelist;
        this.airconservicepricelist = airconservicepricelist;
        this.airconserviceratinglist = airconserviceratinglist;
        this.airconservicecontext = airconservicecontext;
    }

    @NonNull
    @Override
    public Viewholderairconserice onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.airconservice,parent,false);
        Viewholderairconserice holder = new Viewholderairconserice(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholderairconserice holder, int position) {
        holder.airconserviceseller.setText(airconservicenamelist.get(position));
        holder.airconserviceprice.setText(airconservicepricelist.get(position));
        holder.airconserviceratings.setText(airconserviceratinglist.get(position));
        holder.airconbookservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholderairconserice extends RecyclerView.ViewHolder{

        TextView airconserviceseller,airconserviceprice,airconserviceratings;
        Button airconbookservice;

        public Viewholderairconserice(@NonNull View itemView) {
            super(itemView);

            airconserviceseller = itemView.findViewById(R.id.airconservicename);
            airconserviceprice = itemView.findViewById(R.id.airconserviceprice);
            airconserviceratings = itemView.findViewById(R.id.airconservicerating);
            airconbookservice = itemView.findViewById(R.id.airconservicebook);
        }
    }
}
