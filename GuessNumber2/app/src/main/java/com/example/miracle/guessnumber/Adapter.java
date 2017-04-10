package com.example.miracle.guessnumber;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Adapter extends RecyclerView.Adapter{

    private int mNumber;
    private int min, max, ans;
    private int[] site;
    public Adapter(int number){
        mNumber = number;
        min = 0;
        max = number - 1;
        ans = (int) (Math.random()*number);
        site = new int[mNumber];
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTxt;
        public CardView mCard;
        public RelativeLayout mRelative;

        public ViewHolder(View itemView) {
            super(itemView);
            mCard = (CardView)itemView.findViewById(R.id.cardview);
            mRelative = (RelativeLayout)itemView.findViewById(R.id.relative);
            mTxt = (TextView) itemView.findViewById(R.id.item_number);
        }
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycle_view_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.mTxt.setText(String.valueOf(position + 1));
        if (site[position] == 0)
            holder.itemView.setBackgroundColor(0xFFFFFF);
        else if (site[position] == 1)
            holder.itemView.setBackgroundColor(0xb4b4b4);
        else if (site[position] == 2)
            holder.itemView.setBackgroundColor(0xff4747);
    }





    //get count
    @Override
    public int getItemCount() {
        return mNumber;
    }

    public boolean game(int position){
        if (position > ans){
            for (int i = position ; i <= max ; i++)
                site[i] = 1;
            max = position;
        }
        else if (position < ans){
            for (int i = min ; i <= position ; i++)
                site[i] = 1;
            min = position;
        }
        else{
            site[position] = 2;
            return true;
        }
     return false;
    }
    public String getanswer() {
        String toast = "Game Over. The Answer" + (ans + 1) + "!";
        return toast;
    }
}


