package com.epicodus.myspace;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button mNewBlogPostButton;
    private TextView mBlogTitleTextView;
    private TextView mBlogContentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBlogTitleTextView = (TextView) findViewById(R.id.blogTitleTextView);
        mBlogContentTextView = (TextView) findViewById(R.id.blogContentTextView);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");

        mBlogTitleTextView.setText(title);
        mBlogContentTextView.setText(content);


        mNewBlogPostButton = (Button) findViewById(R.id.newBlogPostButton);
        mNewBlogPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent  (MainActivity.this, BlogActivity.class);
                startActivity(intent);
            }
        });
    }
}
