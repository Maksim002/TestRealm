package com.example.testrealm.realm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.testrealm.R;

import java.util.ArrayList;
import java.util.List;

public class Adaptor extends PagerAdapter {

    private List<Product> question;

    @Override
    public int getCount() {
        return question.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(container.getContext());
        View view = layoutInflater.inflate(R.layout.item, container,false);

        TextView title;

        title = view.findViewById(R.id.text01);

        title.setText(question.get(position).getQuestion());

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);

    }

    public void notify(List<Product> questionnaires) {
        this.question = questionnaires;
        notifyDataSetChanged();
    }
}
