package id.cybershift.ibest.volunteerData;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import id.cybershift.ibest.R;

public class VolunteerData1Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_data1);

        //Casting view
        ImageView backArrow = findViewById(R.id.back_button);
        Button next = findViewById(R.id.next_button);

        backArrow.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back_button) {
            finish();
        } else if (view.getId() == R.id.next_button) {
            Intent intent = new Intent(this, VolunteerData2Activity.class);
            startActivity(intent);
        }
    }
}
