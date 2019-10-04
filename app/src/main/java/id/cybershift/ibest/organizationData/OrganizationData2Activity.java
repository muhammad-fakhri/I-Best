package id.cybershift.ibest.organizationData;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import id.cybershift.ibest.R;

public class OrganizationData2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_data2);

        ImageView backButton = findViewById(R.id.back_button);
        Button btnNext = findViewById(R.id.next_button);
        backButton.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.next_button) {
            startActivity(new Intent(view.getContext(), OrganizationData3Activity.class));
        } else if (view.getId() == R.id.back_button) {
            finish();
        }
    }
}
