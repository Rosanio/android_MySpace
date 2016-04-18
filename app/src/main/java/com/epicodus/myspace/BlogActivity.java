package com.epicodus.myspace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BlogActivity extends AppCompatActivity {

    public static final String TAG = BlogActivity.class.getSimpleName();
    private Button mSubmitBlogPostButton;
    private EditText mBlogTitleEditText;
    private EditText mBlogContentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        mBlogTitleEditText = (EditText) findViewById(R.id.blogTitleEditText);
        mBlogContentEditText = (EditText) findViewById(R.id.blogContentEditText);
        mSubmitBlogPostButton = (Button) findViewById(R.id.submitBlogPostButton);

        mSubmitBlogPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = mBlogTitleEditText.getText().toString();
                String content = mBlogContentEditText.getText().toString();
                Intent intent = new Intent(BlogActivity.this, MainActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("content", content);
                startActivity(intent);
            }
        });
    }
}
