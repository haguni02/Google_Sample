package edu.android.google_sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;


public class UserActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textEmail;
    private TextView textName;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        auth = MainActivity.getmAuth();

        imageView = findViewById(R.id.imageView);
        textEmail = findViewById(R.id.textView1);
        textName = findViewById(R.id.textView2);

        Glide.with(this).load(auth.getCurrentUser().getPhotoUrl().toString()).into(imageView);
        textEmail.setText(auth.getCurrentUser().getEmail());
        textName.setText(auth.getCurrentUser().getDisplayName());

        findViewById(R.id.signout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
    }

    private void signOut() {
        auth.signOut();
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }
}
