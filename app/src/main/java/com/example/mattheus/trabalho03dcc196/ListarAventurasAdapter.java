package com.example.mattheus.trabalho03dcc196;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListarAventurasAdapter extends RecyclerView.Adapter<ListarAventurasAdapter.ViewHolder> {
    private ArrayList<Aventura> aventuras;
    private OnAventuraClickListener listener;

    public interface OnAventuraClickListener {
        void OnAventuraClick(View view, int position);
        void OnAventuraLongClick(View view, int position);
    }


    public void setOnAventuraClickListener(OnAventuraClickListener listener) {
        this.listener = listener;
    }

    public ListarAventurasAdapter(ArrayList<Aventura>  aventuras){this.aventuras = aventuras;}

    @NonNull
    @Override
    public ListarAventurasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View lstAventuraView;
        lstAventuraView = inflater.inflate(R.layout.recycle_view_aventuras, viewGroup, false);
        ListarAventurasAdapter.ViewHolder holderView = new ListarAventurasAdapter.ViewHolder(lstAventuraView);
        return holderView;

    }

    @Override
    public void onBindViewHolder(@NonNull ListarAventurasAdapter.ViewHolder viewHolder, int i) {
        viewHolder.txt_lst_aventura.setText(aventuras.get(i).getNome());
    }

    @Override
    public int getItemCount() {
        return aventuras.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public TextView txt_lst_aventura;

        public ViewHolder(View itemView) {
            super(itemView);

            txt_lst_aventura = itemView.findViewById(R.id.txt_lst_aventura);


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.OnAventuraLongClick(view, position);
                        }
                    }
                    return false;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (listener!=null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            listener.OnAventuraClick(v, position);
                        }
                    }
                }
            });


        }

        @Override
        public void onClick(View v){
            if (listener!=null){
                int position = getAdapterPosition();
                if(position!= RecyclerView.NO_POSITION){
                    listener.OnAventuraClick(v, position);
                }
            }
        }


        @Override
        public boolean onLongClick(View v) {
            if (listener!=null){
                int position = getAdapterPosition();
                if(position!= RecyclerView.NO_POSITION){
                    listener.OnAventuraLongClick(v, position);
                }
            }
            return true;
        }
    }

}
