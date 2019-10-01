package id.cybershift.ibest.VolunteerData;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import id.cybershift.ibest.MainActivity;
import id.cybershift.ibest.R;

public class ThankYouActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);

        //Casting view
        Button btnToHome = findViewById(R.id.btn_to_home);
        btnToHome.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_to_home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
