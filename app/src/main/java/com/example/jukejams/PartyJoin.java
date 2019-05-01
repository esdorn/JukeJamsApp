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
        return inflater.inflate(R.layout.fragment_party_join, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView)getView().findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        List<String> songs = new ArrayList<>();
        songs.add("YYZ");
        songs.add("Detroit Rock City");
        songs.add("Vertigo");
        songs.add("Jumpsuit");
        SimpleRVAdapter adapter = new SimpleRVAdapter(songs);
        rv.setAdapter(adapter);
    }

    public class SimpleRVAdapter extends RecyclerView.Adapter<SimpleViewHolder>{
        private List<String> dataSource;
        public SimpleRVAdapter (List<String> dataArgs){
            dataSource = dataArgs;
        }

        @Override
        public SimpleViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.songcards, parent, false);
            SimpleViewHolder pvh = new SimpleViewHolder(v);
            return pvh;
        }

        @Override
        public void onBindViewHolder(SimpleViewHolder holder, int position){
            holder.song.setText(dataSource.get(position));
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }

        @Override
        public int getItemCount(){
            return dataSource.size();
        }

    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView song;
        Button up;
        Button down;
        //TextView rate;

        public SimpleViewHolder(View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            song = (TextView) itemView.findViewById(R.id.textView5);
            up = (Button) itemView.findViewById(R.id.imageButton);
            down = (Button) itemView.findViewById(R.id.imageButton2);
        }
    }
}
