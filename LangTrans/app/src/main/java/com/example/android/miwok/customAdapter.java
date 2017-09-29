package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.y;

/**
 * Created by Abishaik on 23-06-2017.
 */

public class customAdapter extends ArrayAdapter<Word> {

    private Context mContext;
    private ArrayList<Word> mWords;
    private int colorId;

    public customAdapter(Context context, ArrayList<Word> words,int colorId)
    {
        super(context, R.layout.list_item,words);
        this.mContext=context;
        this.mWords=words;
        this.colorId=colorId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.list_item,parent,false);

        final Word w = getItem(position);
        String englishWord = w.getDefaultWord();
        String miwokWord = w.getMiwokWord();
        int imageId = w.getmImageResourceId();

        final TextView englishText = (TextView)customView.findViewById(R.id.english);
        final TextView miwokText = (TextView)customView.findViewById(R.id.miwok);
        final ImageView imageView = (ImageView)customView.findViewById(R.id.image);
        final RelativeLayout relativeLayout = (RelativeLayout) customView.findViewById(R.id.linearColour);

        englishText.setText(englishWord);
        miwokText.setText(miwokWord);
        imageView.setImageResource(imageId);
        relativeLayout.setBackgroundColor(colorId);

        return customView;
    }
}
