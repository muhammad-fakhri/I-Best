package id.cybershift.ibest.volunteerData;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import id.cybershift.ibest.R;
import id.cybershift.ibest.model.Volunteer;

public class VolunteerData3Activity extends AppCompatActivity implements View.OnClickListener {

    CardView difabel, humanRight, healt, disaster, edu, youth, agri, science, worker, environment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_data3);

        //Casting view
        ImageView backArrow = findViewById(R.id.back_button);
        Button next = findViewById(R.id.next_button);
        difabel = findViewById(R.id.difabel);
        humanRight = findViewById(R.id.human_right);
        healt = findViewById(R.id.health);
        disaster = findViewById(R.id.disaster);
        edu = findViewById(R.id.education);
        youth = findViewById(R.id.youth_development);
        agri = findViewById(R.id.agricultural);
        science = findViewById(R.id.science);
        worker = findViewById(R.id.worker);
        environment = findViewById(R.id.environment);

        backArrow.setOnClickListener(this);
        next.setOnClickListener(this);
        difabel.setOnClickListener(this);
        humanRight.setOnClickListener(this);
        healt.setOnClickListener(this);
        disaster.setOnClickListener(this);
        edu.setOnClickListener(this);
        youth.setOnClickListener(this);
        agri.setOnClickListener(this);
        science.setOnClickListener(this);
        worker.setOnClickListener(this);
        environment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.difabel:
                difabel.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                break;
            case R.id.human_right:
                humanRight.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                break;
            case R.id.health:
                healt.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                break;
            case R.id.disaster:
                disaster.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                break;
            case R.id.education:
                edu.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                break;
            case R.id.youth_development:
                youth.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                break;
            case R.id.agricultural:
                agri.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                break;
            case R.id.science:
                science.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                break;
            case R.id.worker:
                worker.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                break;
            case R.id.environment:
                environment.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                break;
            default:
                Log.d("FAKHRI", "ADA YANG ANEH SAMA CARDVIEWNYA");
                break;
        }
        if (view.getId() == R.id.back_button) {
            finish();
        } else if (view.getId() == R.id.next_button) {
            Intent intent = new Intent(this, ThankYouActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.imageView) {

        }
    }
}
