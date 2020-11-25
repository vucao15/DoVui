package com.example.dovui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlayerAdapter  extends BaseAdapter {
    List<Player> playerList;
    Context context;
    public LayoutInflater inflater;


    public PlayerAdapter(List<Player> playerList, Context context) {
        this.playerList = playerList;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return playerList.size();
    }

    @Override
    public Object getItem(int i) {
        return playerList.get(i);
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    public static class ViewHolder {
        TextView tvPoint, tvName;
        ImageView imgDetete;
    }
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (convertView == null) {
        convertView = inflater.inflate(R.layout.customstaff, null);
        holder = new ViewHolder();

        holder.imgDetete = (ImageView) convertView.findViewById(R.id.imgDeteteStaff);
        holder.tvPoint = (TextView) convertView.findViewById(R.id.tvPoint);
        holder.tvName = (TextView) convertView.findViewById(R.id.tvName);}
        else{
            holder = (ViewHolder) convertView.getTag();
        Player player = (Player) playerList.get(i);
        holder.tvPoint.setText(player.getPoint());
        holder.tvName.setText(player.getName());}
        return convertView;

    }
}
