package com.merchpandas.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


class ItemAdapter extends ArrayAdapter<Song> {
    public ItemAdapter(@NonNull Context context, @NonNull List<Song> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Song song = getItem(position);

        TextView songNameTV = view.findViewById(R.id.item_song_name);
        assert song != null;
        songNameTV.setText(song.getSongName());

        TextView songArtistTv = view.findViewById(R.id.item_artist_name);
        songArtistTv.setText(song.getArtistName());

        return view;
    }
}
