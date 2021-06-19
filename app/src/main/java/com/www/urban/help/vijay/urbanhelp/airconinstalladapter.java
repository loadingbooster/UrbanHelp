package com.www.urban.help.vijay.urbanhelp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class airconinstalladapter extends RecyclerView.Adapter<airconinstalladapter.Viewholderairconinstall>{

    private ArrayList<String> airconinstallnamelist = new ArrayList<>();
    private ArrayList<String> airconinstallpricelist = new ArrayList<>();
    private ArrayList<String> airconinstallratinglist = new ArrayList<>();
    private Context airconinstallcontext;

    public airconinstalladapter(ArrayList<String> airconinstallnamelist, ArrayList<String> airconinstallpricelist, ArrayList<String> airconinstallratinglist, Context airconinstallcontext) {
        this.airconinstallnamelist = airconinstallnamelist;
        this.airconinstallpricelist = airconinstallpricelist;
        this.airconinstallratinglist = airconinstallratinglist;
        this.airconinstallcontext = airconinstallcontext;
    }

    @NonNull
    @Override
    public Viewholderairconinstall onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.airconinstall,parent, false);
        Viewholderairconinstall viewholderairconinstall = new Viewholderairconinstall(view);
        return viewholderairconinstall;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholderairconinstall holder, int position) {
            holder.airconinstallseller.setText(airconinstallnamelist.get(position));
            holder.airconinstallprice.setText(airconinstallpricelist.get(position));
            holder.airconinstallrating.setText(airconinstallratinglist.get(position));
            holder.airconbookinstall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
    }

    @Override
    public int getItemCount() {
        return airconinstallnamelist.size();
    }

    public class Viewholderairconinstall extends RecyclerView.ViewHolder{
        Button airconbookinstall;
        TextView airconinstallseller;
        TextView airconinstallprice;
        TextView airconinstallrating;
        LinearLayout airconrepairparentlayout;
        public Viewholderairconinstall(@NonNull View itemView) {
            super(itemView);
            airconbookinstall = itemView.findViewById(R.id.airconinstallbutton);
            airconinstallprice = itemView.findViewById(R.id.airconinstallprice);
            airconinstallseller = itemView.findViewById(R.id.airconinstallseller);
            airconinstallrating = itemView.findViewById(R.id.airconinstallrating);
        }
    }
}
