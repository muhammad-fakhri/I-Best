package id.cybershift.ibest.experience;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import id.cybershift.ibest.R;
import id.cybershift.ibest.model.Experience;
import id.cybershift.ibest.problem.MakeProblemThankYouActivity;

public class ExperienceDataActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNext;
    ImageView backBtn;
    EditText title, description;
    Experience experience;
    FirebaseUser user;
    FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference experienceRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_data);

        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        experienceRef = database.getReference("experience");

        title = findViewById(R.id.experience_title);
        description = findViewById(R.id.experience_detail);

        experience = new Experience();

        btnNext = findViewById(R.id.next_button);
        backBtn = findViewById(R.id.back_button);

        btnNext.setOnClickListener(this);
        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.next_button) {
            experience.setUserID(user.getUid());
            experience.setTitle(title.getText().toString());
            experienceRef.push()
                    .setValue(experience)
                    .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(ExperienceDataActivity.this, "Masalahmu tersimpan ke database", Toast.LENGTH_SHORT).show();
                        }
                    });
            startNewMainActivity(ExperienceDataActivity.this, MakeProblemThankYouActivity.class);
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
