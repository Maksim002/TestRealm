package com.example.testrealm.realm;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testrealm.R;

class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textRecyclerTitle);
    }

    public void bind(Answer answor) {
        textView.setText(answor.getTitle(getAdapterPosition()));

    }
}
