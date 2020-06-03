package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
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

public class ObjectsActivity extends AppCompatActivity {

    GridView gridView;
    Integer[] imageIds = {
            R.drawable.house,
            R.drawable.door,
            R.drawable.bulb,
            R.drawable.window,
            R.drawable.flowers,
            R.drawable.fan
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
        setContentView(R.layout.activity_objects);

        gridView = (GridView) findViewById(R.id.gridview_objects);
        gridView.setAdapter(new ObjectsActivity.ObjectsImageAdapterGridView(this));

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {

//                if (message.equals("Marathi")) {
//                    showToast(strings_marathi[position]);
//                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), soundids_marathi[position]);
//                    mp.start();
//                }
//                else if (message.equals("Kannada")) {
//                    showToast(strings_kannada[position]);
//                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), soundids_kannada[position]);
//                    mp.start();
//                }
            }
        });

        // Capture the layout's TextView and set the string as its text
//        TextView textView = findViewById(R.id.textView);
//        textView.setText(message);
    }

    public class ObjectsImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        public ObjectsImageAdapterGridView(Context c) {
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
