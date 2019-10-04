package id.cybershift.ibest.campaign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import id.cybershift.ibest.R;

public class CampaignDetailActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView btnBack;
    Button join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_detail);

        btnBack = findViewById(R.id.back_button);
        join = findViewById(R.id.btn_join);

        btnBack.setOnClickListener(this);
        join.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_join) {
            startActivity(new Intent(view.getContext(), JoinCampaignThankYouActivity.class));
        } else if (view.getId() == R.id.back_button) {
            finish();
        }
    }
}
