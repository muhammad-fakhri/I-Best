package id.cybershift.ibest.Report;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import id.cybershift.ibest.R;

public class Report2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report2);

        ImageView backBtn = findViewById(R.id.back_button);
        Button btnNext = findViewById(R.id.next_button);
        btnNext.setOnClickListener(this);
        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_button:
                finish();
                break;
            case R.id.next_button:
                startActivity(new Intent(view.getContext(), ReportThankYouActivity.class));
                break;
            default:
                break;
        }
    }
}
