package com.example.android.musicplayer2;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import static android.R.attr.name;
import static android.R.id.list;
import static com.example.android.musicplayer2.R.id.image;

class RVAdapter extends RecyclerView.Adapter<RVAdapter.SongViewHolder> {

    private List<SongInfo> songs;
    private static OnItemClickListener listener;

    interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    RVAdapter(List<SongInfo> songs) {
        this.songs = songs;
    }

    static class SongViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView songTitle;
        TextView songArtist;
        ImageView songPhoto;

        SongViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            songTitle = (TextView) itemView.findViewById(R.id.songTitle);
            songArtist = (TextView) itemView.findViewById(R.id.songArtist);
            songPhoto = (ImageView) itemView.findViewById(R.id.songPhoto);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getAdapterPosition());
        }
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        RVAdapter.listener = listener;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_content, viewGroup, false);
        return new SongViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SongViewHolder songViewHolder, int i) {
        songViewHolder.songTitle.setText(songs.get(i).SONG);
        songViewHolder.songArtist.setText(songs.get(i).ARTIST);
        songViewHolder.songPhoto.setImageResource(songs.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }
}