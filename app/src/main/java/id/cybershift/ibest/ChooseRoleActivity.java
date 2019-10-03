package id.cybershift.ibest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import id.cybershift.ibest.volunteerData.VolunteerData1Activity;

public class ChooseRoleActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_role);

        //Set Toolbar as ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        ImageView backArrow = findViewById(R.id.back_button);

        //Casting all view
        CardView btnRoleVolunteer = findViewById(R.id.btn_role_volunteer);
        CardView btnRoleOrganization = findViewById(R.id.btn_role_organization);

        //Set click listener
        backArrow.setOnClickListener(this);
        btnRoleVolunteer.setOnClickListener(this);
        btnRoleOrganization.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_button:
                finish();
                break;
            case R.id.btn_role_volunteer:
                Intent intent = new Intent(this, VolunteerData1Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_role_organization:
                Toast.makeText(this, "PUSH ORGANIZATION ROLE", Toast.LENGTH_SHORT).show();
        }
    }
}
