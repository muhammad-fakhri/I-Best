package id.cybershift.ibest.campaign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import id.cybershift.ibest.R;
import id.cybershift.ibest.model.Campaign;

public class CampaignDataActivity extends AppCompatActivity implements View.OnClickListener {

    EditText title, time, deadline, location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_data);

        title = findViewById(R.id.campaign_title);
        time = findViewById(R.id.campaign_time);
        deadline = findViewById(R.id.campaign_deadline);
        location = findViewById(R.id.campaign_location);

        ImageView backButton = findViewById(R.id.back_button);
        Button btnNext = findViewById(R.id.next_button);
        backButton.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.next_button) {
            Campaign campaign = new Campaign(
                    title.getText().toString(),
                    time.getText().toString(),
                    deadline.getText().toString(),
                    location.getText().toString()
            );
            Intent intent = new Intent(this, CampaignDetailActivity.class);
            intent.putExtra(CampaignDetailActivity.EXTRA_CAMPAIGN_DATA, campaign);
            startActivity(intent);
        } else if (view.getId() == R.id.back_button) {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
