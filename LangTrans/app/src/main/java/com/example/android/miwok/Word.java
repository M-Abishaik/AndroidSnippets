package com.example.android.miwok;

import java.util.ArrayList;

/**
 * Created by Abishaik on 23-06-2017.
 */

public class Word extends ArrayList<Word> {

    private String mDefaultWord;
    private String mMiwokWord;
    private int mImageResourceId;
    private int mAudioResourceId;

    public Word(String english,String Miwok,int mImageResourceId,int mAudioResourceId)
    {
        this.mDefaultWord=english;
        this.mMiwokWord=Miwok;
        this.mImageResourceId=mImageResourceId;
        this.mAudioResourceId=mAudioResourceId;
    }

    public Word(String english,String Miwok)
    {
        this.mDefaultWord=english;
        this.mMiwokWord=Miwok;
    }


    public void setDefaultWord(String english)
    {
        mDefaultWord=english;
    }

    public void setMiwokWord(String Miwok)
    {
        mMiwokWord=Miwok;
    }

    public void setmImageResourceId(int id)
    {
        mImageResourceId=id;
    }

    public void setmAudioResourceId(int id)
    {
        mAudioResourceId=id;
    }

    public String getDefaultWord()
    {
        return mDefaultWord;
    }

    public String getMiwokWord()
    {
        return mMiwokWord;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public int getmAudioResourceId()
    {
        return mAudioResourceId;
    }
}
