package id.cybershift.ibest.campaign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import id.cybershift.ibest.R;

public class ChooseProblemActivity extends AppCompatActivity implements View.OnClickListener {
    CardView campaign1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_problem);

        campaign1 = findViewById(R.id.campaign1);

        ImageView backButton = findViewById(R.id.back_button);
        Button skip = findViewById(R.id.btn_donate);
        skip.setOnClickListener(this);
        backButton.setOnClickListener(this);
        campaign1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_button:
                finish();
                break;
            case R.id.btn_donate:
                startActivity(new Intent(this, MakeCampaignDataActivity.class));
                break;
            case R.id.campaign1:
                startActivity(new Intent(this, MakeCampaignDataActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
