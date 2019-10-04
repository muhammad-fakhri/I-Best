package id.cybershift.ibest.volunteerData;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import id.cybershift.ibest.R;

public class VolunteerData3Activity extends AppCompatActivity implements View.OnClickListener {

    CardView difabel, humanRight, healt, disaster, edu, youth, agri, science, worker, environment;
    boolean a = false, b = false, c = false, d = false, e = false, f = false, g = false, h = false, i = false, j = false;

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
                if (a) {
                    difabel.setCardBackgroundColor(getResources().getColor(R.color.basicCardView));
                    a = false;
                } else {
                    difabel.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                    a = true;
                }
                break;
            case R.id.human_right:
                if (b) {
                    humanRight.setCardBackgroundColor(getResources().getColor(R.color.basicCardView));
                    b = false;
                } else {
                    b = true;
                    humanRight.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                }
                break;
            case R.id.health:
                if (c) {
                    healt.setCardBackgroundColor(getResources().getColor(R.color.basicCardView));
                    c = false;
                } else {
                    healt.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                    c = true;
                }
                break;
            case R.id.disaster:
                if (d) {
                    disaster.setCardBackgroundColor(getResources().getColor(R.color.basicCardView));
                    d = false;
                } else {
                    d = true;
                    disaster.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                }
                break;
            case R.id.education:
                if (e) {
                    edu.setCardBackgroundColor(getResources().getColor(R.color.basicCardView));
                    e = false;
                } else {
                    edu.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                    e = true;
                }
                break;
            case R.id.youth_development:
                if (f) {
                    youth.setCardBackgroundColor(getResources().getColor(R.color.basicCardView));
                    f = false;
                } else {
                    f = true;
                    youth.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                }
                break;
            case R.id.agricultural:
                if (g) {
                    agri.setCardBackgroundColor(getResources().getColor(R.color.basicCardView));
                    g = false;
                } else {
                    g = true;
                    agri.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                }
                break;
            case R.id.science:
                if (h) {
                    science.setCardBackgroundColor(getResources().getColor(R.color.basicCardView));
                    h = false;
                } else {
                    h = true;
                    science.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                }
                break;
            case R.id.worker:
                if (i) {
                    worker.setCardBackgroundColor(getResources().getColor(R.color.basicCardView));
                    i = false;
                } else {
                    i = true;
                    worker.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                }
                break;
            case R.id.environment:
                if (j) {
                    environment.setCardBackgroundColor(getResources().getColor(R.color.basicCardView));
                    j = false;
                } else {
                    j = true;
                    environment.setCardBackgroundColor(getResources().getColor(R.color.darkNice));
                }
                break;
            case R.id.back_button:
                finish();
                break;
            case R.id.next_button:
                startActivity(new Intent(this, ThankYouActivity.class));
                break;
            default:
                Log.d("FAKHRI", "ADA YANG ANEH SAMA CARDVIEWNYA");
                break;
        }
    }
}
