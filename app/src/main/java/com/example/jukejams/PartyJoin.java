package com.example.jukejams;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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
        //rv.setLayoutManager(new LayoutManager(getContext()));
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
            holder.textView.setText(dataSource[position]);
        }

        @Override
        public int getItemCount(){
            return dataSource.length;
        }

    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        //create Button here
        public SimpleViewHolder(View itemView){
            super(itemView);
            textView = (TextView) itemView;
            textView = R.layout
        }
    }
}
