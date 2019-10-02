package id.cybershift.ibest.Campaign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import id.cybershift.ibest.R;

public class CampaignDataActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_data);

        ImageView backButton = findViewById(R.id.back_button);
        Button btnNext = findViewById(R.id.next_button);
        backButton.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.next_button) {
            startActivity(new Intent(this, CampaignDetailActivity.class));
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
