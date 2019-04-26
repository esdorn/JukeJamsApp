package com.example.jukejams;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class PartyJoin extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    public static PartyJoin newInstance() {
        PartyJoin fragment= new PartyJoin();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView rv = new RecyclerView(getContext());
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        List<String> songs = new ArrayList<>();
        songs.add("YYZ");
        songs.add("Detroit Rock City");
        songs.add("Vertigo");
        songs.add("Jumpsuit");
        return inflater.inflate(R.layout.fragment_party_join, container, false);
    }

    public class SimpleRVAdapter extends RecyclerView.Adapter<SimpleViewHolder>{
        private String[] dataSource;
        public SimpleRVAdapter (String[] dataArgs){
            dataSource = dataArgs;
        }

        @Override
        public SimpleViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
            View view = new TextView(parent.getContext());
            SimpleViewHolder viewHolder = new SimpleViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(SimpleViewHolder holder, int position){
            holder.song.setText(dataSource[position]);
        }

        @Override
        public int getItemCount(){
            return dataSource.length;
        }

    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public Button buttonView;
        CardView cv;
        TextView song;
        Button up;
        Button down;
        //TextView rate;

        public SimpleViewHolder(View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            song = (TextView) itemView.findViewById(R.id.textView5);
            up = (Button) itemView.findViewById(R.id.button6);
            down = (Button) itemView.findViewById(R.id.button7);
        }
    }
}
