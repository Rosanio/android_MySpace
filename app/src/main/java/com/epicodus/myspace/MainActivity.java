package com.epicodus.myspace;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mAddNewFriendButton;
    private EditText mAddNewFriendEditText;

    private Button mNewBlogPostButton;
    private TextView mBlogTitleTextView;
    private TextView mBlogContentTextView;
    private ListView mFriendsListView;
    private ArrayList<String> mFriends = new ArrayList<String>();
    private String[] mFriendsArray = {"Matt", "Mike", "Tyler", "Anna", "Dustin", "Abby", "Brad", "Tim", "Shaun", "Mark"};
    private TextView mFriendsListTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(Integer i = 0; i < mFriendsArray.length; i++) {
            mFriends.add(mFriendsArray[i]);
        }


        mFriendsListTitle = (TextView) findViewById(R.id.textView2);
        mFriendsListView = (ListView) findViewById(R.id.friendsListView);
        final ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,mFriends);
        mFriendsListView.setAdapter(adapter);


        mAddNewFriendEditText = (EditText) findViewById(R.id.addNewFriendEditText);
        mAddNewFriendButton = (Button) findViewById(R.id.addNewFriendButton);




        mAddNewFriendEditText.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "It works");
                mFriendsListView.setVisibility(View.INVISIBLE);
                mFriendsListTitle.setVisibility(View.INVISIBLE);
                return false;
            }
        });



        mAddNewFriendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String friendName = mAddNewFriendEditText.getText().toString();
                mFriends.add(friendName);
                adapter.notifyDataSetChanged();
                mAddNewFriendEditText.setText("");
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mAddNewFriendEditText.getWindowToken(), 0);
                mFriendsListView.setVisibility(View.VISIBLE);
                mFriendsListTitle.setVisibility(View.VISIBLE);
            }
        });





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
