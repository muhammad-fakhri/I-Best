package id.cybershift.ibest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import id.cybershift.ibest.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    boolean isDone = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (isDone) {
//            isDone = false;
//            Intent intent = new Intent(this, LoginActivity.class);
//            startActivity(intent);
//        }
    }
}
