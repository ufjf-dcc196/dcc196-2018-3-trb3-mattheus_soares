package com.example.mattheus.trabalho03dcc196;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListarJogadoresAdapter extends RecyclerView.Adapter<ListarJogadoresAdapter.ViewHolder> {

    private ArrayList<Jogador> jogadores;
    private OnJogadorClickListener listener;

    public interface OnJogadorClickListener {
        void OnJogadorClick(View view, int position);
        void OnJogadorLongClick(View view, int position);
    }


    public void setOnJogadorClickListener(OnJogadorClickListener listener) {
        this.listener = listener;
    }

    public void setJogadores(ArrayList<Jogador> jog){
        this.jogadores = jog;
        notifyDataSetChanged();
    }

    public ListarJogadoresAdapter(ArrayList<Jogador>  jogadores){
        this.jogadores = jogadores;
    }

    @NonNull
    @Override
    public ListarJogadoresAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View lstJogadorView;
        lstJogadorView = inflater.inflate(R.layout.recycle_view_jogadores, viewGroup, false);
        ViewHolder holderView = new ViewHolder(lstJogadorView);
        return holderView;

    }

    @Override
    public void onBindViewHolder(@NonNull ListarJogadoresAdapter.ViewHolder viewHolder, int i) {
        viewHolder.txt_lst_nome_jogador.setText(jogadores.get(i).getNome());
        viewHolder.txt_lst_classe_jogador.setText(jogadores.get(i).getClasse());
    }

    @Override
    public int getItemCount() {
        return jogadores.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public TextView txt_lst_nome_jogador;
        public TextView txt_lst_classe_jogador;

        public ViewHolder(View itemView) {
            super(itemView);

            txt_lst_nome_jogador = itemView.findViewById(R.id.txt_lst_nome_jogador);
            txt_lst_classe_jogador = itemView.findViewById(R.id.txt_lst_classe_jogador);


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.OnJogadorLongClick(view, position);
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
                            listener.OnJogadorClick(v, position);
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
                    listener.OnJogadorClick(v, position);
                }
            }
        }


        @Override
        public boolean onLongClick(View v) {
            if (listener!=null){
                int position = getAdapterPosition();
                if(position!= RecyclerView.NO_POSITION){
                    listener.OnJogadorLongClick(v, position);
                }
            }
            return true;
        }
    }

}
