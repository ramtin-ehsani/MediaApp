package com.myapp.mediaproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.myapp.mediaproject.R;

import java.util.List;

public class RVAdapterSeasons extends
        RecyclerView.Adapter<RVAdapterSeasons.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView seasonName;
        public Button seenBTN;

        public ViewHolder(View itemView) {
            super(itemView);

            seasonName = itemView.findViewById(R.id.seasonsTXT);
            seenBTN = itemView.findViewById(R.id.seasonsBTN);
        }
    }

    private List<Boolean> seasons;
    Context context;

    public RVAdapterSeasons(List<Boolean> seasons, Context context) {
        this.seasons = seasons;
        this.context = context;
    }

    @Override
    public RVAdapterSeasons.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.seasons_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final boolean seasons = this.seasons.get(position);

        final TextView seasonTitle = holder.seasonName;
        seasonTitle.setText("season " + String.valueOf(position + 1));

        final Button seasonBTN = holder.seenBTN;
    }

    @Override
    public int getItemCount() {
        return seasons.size();
    }
}