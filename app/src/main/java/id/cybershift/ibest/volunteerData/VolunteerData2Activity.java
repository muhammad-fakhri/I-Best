package id.cybershift.ibest.volunteerData;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import id.cybershift.ibest.R;
import id.cybershift.ibest.model.Volunteer;

public class VolunteerData2Activity extends AppCompatActivity implements View.OnClickListener {

    EditText DOB, institution, domisili, job;
    RadioGroup gender;
    String dom, institute, work, sex;
    FirebaseUser user;
    FirebaseAuth auth;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_data2);

        database = FirebaseDatabase.getInstance().getReference();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        //Casting view
        ImageView backArrow = findViewById(R.id.back_button);
        Button next = findViewById(R.id.next_button);
        DOB = findViewById(R.id.volunteer_dob);
        job = findViewById(R.id.volunteer_job);
        institution = findViewById(R.id.volunteer_institution);
        domisili = findViewById(R.id.volunteer_domisili);
        gender = findViewById(R.id.gender);

        backArrow.setOnClickListener(this);
        next.setOnClickListener(this);

        ValueEventListener volunteerDataListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Volunteer data = dataSnapshot.getValue(Volunteer.class);
//                Log.d("FAKHRI VOLUNTEER", "DATA VOLUNTTER " + data.getName() + " UID: " + data.getUID() + " sudah masuk ke database");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("FAKHRI VOLUNTEER FAILED", "loadPost:onCancelled", databaseError.toException());
            }
        };
        database.addValueEventListener(volunteerDataListener);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back_button) {
            finish();
        } else if (view.getId() == R.id.next_button) {
            dom = domisili.getText().toString();
            institute = institution.getText().toString();
            work = job.getText().toString();

            if (gender.getCheckedRadioButtonId() != -1) {
                int id = gender.getCheckedRadioButtonId();
                RadioButton selected = findViewById(id);
                sex = selected.getText().toString();

                if (checkIfEmpty()) {
                    Toast.makeText(this, "Semua data harap diisi", Toast.LENGTH_SHORT).show();
                } else {
                    Volunteer volunteer = new Volunteer();
                    volunteer.setUID(user.getUid());
                    volunteer.setName(user.getDisplayName());
                    volunteer.setEmail(user.getEmail());
                    volunteer.setGender(sex);
                    volunteer.setDomisili(dom);
                    volunteer.setInstitution(institute);
                    volunteer.setJob(work);

                    //Send the data to database
                    database.child("users").child(user.getUid()).setValue(volunteer);

                    startActivity(new Intent(this, VolunteerData3Activity.class));
                }
            } else {
                Toast.makeText(this, "Semua data harap diisi", Toast.LENGTH_SHORT).show();
            }
        }
    }

    boolean checkIfEmpty() {
        if (TextUtils.isEmpty(dom) || TextUtils.isEmpty(institute) || TextUtils.isEmpty(work) || TextUtils.isEmpty(sex)) {
            return true;
        } else {
            return false;
        }
    }
}
