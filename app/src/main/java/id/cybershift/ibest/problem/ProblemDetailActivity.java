package id.cybershift.ibest.problem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import id.cybershift.ibest.R;
import id.cybershift.ibest.model.Problem;

public class ProblemDetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_PROBLEM = "extra_problem";

    Button btnNext;
    ImageView backBtn;
    Problem problem;
    EditText detail;
    FirebaseDatabase database;
    DatabaseReference problemRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_detail2);

        problem = getIntent().getParcelableExtra(EXTRA_PROBLEM);

        database = FirebaseDatabase.getInstance();
        problemRef = database.getReference("problem");

        detail = findViewById(R.id.problem_detail);
        btnNext = findViewById(R.id.next_button);
        backBtn = findViewById(R.id.back_button);
        btnNext.setOnClickListener(this);
        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.next_button) {
            problem.setDescription(detail.getText().toString());
            problemRef.push()
                    .setValue(problem)
                    .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(ProblemDetailActivity.this, "Masalahmu tersimpan ke database", Toast.LENGTH_SHORT).show();
                        }
                    });
            startNewMainActivity(ProblemDetailActivity.this, ProblemThankYouActivity.class);
        } else if (view.getId() == R.id.back_button) {
            finish();
        }
    }

    static void startNewMainActivity(Context currentActivity, Class<? extends Activity> newTopActivityClass) {
        Intent intent = new Intent(currentActivity, newTopActivityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        currentActivity.startActivity(intent);
    }
}
