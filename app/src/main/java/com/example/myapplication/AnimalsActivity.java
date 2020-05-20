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
import android.widget.TextView;
import android.widget.Toast;

public class AnimalsActivity extends AppCompatActivity {
    GridView gridView;
    Integer[] imageIds = {
            R.drawable.cat_small,
            R.drawable.rat_small,
            R.drawable.elephant_smal,
            R.drawable.tiger_small,
            R.drawable.lion_small,
            R.drawable.monkey_small
    };

    Integer[] soundids_marathi = {
            R.raw.cat_marathi,
            R.raw.hamster_marathi,
            R.raw.elephant_marathi,
            R.raw.tiger_marathi,
            R.raw.lion_marathi,
            R.raw.monkey_marathi
    };

    Integer[] soundids_hindi= {
            R.raw.cat_billi,
            R.raw.hamster_hindi,
            R.raw.elephant_hindi,
            R.raw.tiger_hindi,
            R.raw.lion_hindi,
            R.raw.monkey_hindi
    };

    Integer[] strings_marathi = {
            R.string.cat_marathi,
            R.string.mouse_marathi,
            R.string.elephant_marathi,
            R.string.tiger_marathi,
            R.string.lion_marathi,
            R.string.monkey_marathi
    };

    Integer[] strings_hindi = {
            R.string.cat_hindi,
            R.string.mouse_hindi,
            R.string.elephant_hindi,
            R.string.tiger_hindi,
            R.string.lion_hindi,
            R.string.monkey_hindi
    };

    void showToast(int stringid) {
        Toast t =Toast.makeText(getBaseContext(), stringid, Toast.LENGTH_LONG);
        ViewGroup group = (ViewGroup) t.getView();
        TextView messageTextView = (TextView) group.getChildAt(0);
        messageTextView.setTextSize(25);
        t.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        gridView = (GridView) findViewById(R.id.gridview_animals);
        gridView.setAdapter(new AnimalImageAdapterGridView(this));

        Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {

                if (message.equals("Marathi")) {
                    showToast(strings_marathi[position]);
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), soundids_marathi[position]);
                    mp.start();
                }
                else if (message.equals("Hindi")) {
                    showToast(strings_hindi[position]);
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), soundids_hindi[position]);
                    mp.start();
                }
            }
        });

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
                mImageView.setLayoutParams(new GridView.LayoutParams(400, 400));
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
