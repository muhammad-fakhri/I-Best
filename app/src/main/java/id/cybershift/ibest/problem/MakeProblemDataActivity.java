package id.cybershift.ibest.problem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import id.cybershift.ibest.R;
import id.cybershift.ibest.model.Problem;

public class MakeProblemDataActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNext;
    ImageView backBtn;
    EditText title, location, contact;
    Problem problem;
    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_problem_data);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        title = findViewById(R.id.problem_title);
        location = findViewById(R.id.problem_location);
        contact = findViewById(R.id.problem_contact);

        problem = new Problem();

        btnNext = findViewById(R.id.next_button);
        backBtn = findViewById(R.id.back_button);

        btnNext.setOnClickListener(this);
        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.next_button) {
            problem.setUserID(user.getUid());
            problem.setTitle(title.getText().toString());
            problem.setLocation(location.getText().toString());
            problem.setContact(contact.getText().toString());
            Intent intent = new Intent(view.getContext(), MakeProblemDetailActivity.class);
            intent.putExtra(MakeProblemDetailActivity.EXTRA_PROBLEM, problem);
            startActivity(intent);
        } else if (view.getId() == R.id.back_button) {
            finish();
        }
    }
}
