package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class AnimalsActivity extends AppCompatActivity {
    GridView gridView;
    Integer[] imageIds = {
            R.drawable.lion,

            R.drawable.puppy,
            R.drawable.horseweb
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);


        gridView = (GridView) findViewById(R.id.gridview_animals);
        gridView.setAdapter(new AnimalImageAdapterGridView(this));

    }


    public class AnimalImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        public AnimalImageAdapterGridView(Context c) {
            mContext = c;
        }

        public int getCount() {
            return imageIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView mImageView;

            if (convertView == null) {
                mImageView = new ImageView(mContext);
                mImageView.setLayoutParams(new GridView.LayoutParams(260, 260));
                mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                mImageView.setPadding(16, 16, 16, 16);
            } else {
                mImageView = (ImageView) convertView;
            }
            mImageView.setImageResource(imageIds[position]);
            return mImageView;
        }
    }
}
