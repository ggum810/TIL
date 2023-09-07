package com.example.til;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.til.R;

public class PopupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        // 인텐트에서 전달된 데이터를 받아옵니다.
        int imageResource = getIntent().getIntExtra("imageResource", R.drawable.sample_image);
        String postContent = getIntent().getStringExtra("postContent");

        ImageView popupImageView = findViewById(R.id.popupImageView);
        TextView popupTextView = findViewById(R.id.popupTextView);

        popupImageView.setImageResource(imageResource);
        popupTextView.setText(postContent);
    }
}