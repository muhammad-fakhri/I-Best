package id.cybershift.ibest.campaign;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import id.cybershift.ibest.R;
import id.cybershift.ibest.model.Campaign;

public class MakeCampaignDetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_CAMPAIGN_DATA = "extra_campaign_data";
    int PICK_IMAGE_REQUEST = 1;
    Button btnNext;
    Bitmap bitmap, decoded;
    ImageView receivedImage, btnAddImage, backButton;
    EditText volunteerJob, logistic, briefing, information;
    int bitmap_size = 60; // range 1 - 100
    Campaign campaign;
    FirebaseDatabase database;
    FirebaseStorage storage;
    DatabaseReference campaignRef;
    StorageReference storageRef, campaignPicRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_campaign_detail);

        campaign = getIntent().getParcelableExtra(EXTRA_CAMPAIGN_DATA);

        btnNext = findViewById(R.id.next_button);
        backButton = findViewById(R.id.back_button);
        btnAddImage = findViewById(R.id.add_image_btn);
        receivedImage = findViewById(R.id.received_image);

        volunteerJob = findViewById(R.id.campaign_volunteer_job);
        logistic = findViewById(R.id.campaign_logistic);
        briefing = findViewById(R.id.campaign_briefing);
        information = findViewById(R.id.campaign_more_information);

        btnNext.setOnClickListener(this);
        backButton.setOnClickListener(this);
        btnAddImage.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();
        campaignRef = database.getReference("campaign");
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();

//        Intent intent = getIntent();
//        Campaign campaign = new Campaign(
//                intent.getStringExtra("EXTRA_TITLE"),
//                intent.getStringExtra("EXTRA_TIME"),
//                intent.getStringExtra("EXTRA_DEADLINE"),
//                intent.getStringExtra("EXTRA_LOCATION")
//        );
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add_image_btn) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
        } else if (view.getId() == R.id.back_button) {
            finish();
        } else if (view.getId() == R.id.next_button) {
            doTheRightThing();
            startNewMainActivity(MakeCampaignDetailActivity.this, MakeCampaignDoneActivity.class);
        }
    }

    static void startNewMainActivity(Context currentActivity, Class<? extends Activity> newTopActivityClass) {
        Intent intent = new Intent(currentActivity, newTopActivityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        currentActivity.startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //mengambil fambar dari Gallery
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                // 512 adalah resolusi tertinggi setelah image di resize, bisa di ganti.
                setToImageView(getResizedBitmap(bitmap, 512));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void setToImageView(Bitmap bmp) {
        //compress image
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, bitmap_size, bytes);
        decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(bytes.toByteArray()));

        //menampilkan gambar yang dipilih dari camera/gallery ke ImageView
        receivedImage.setVisibility(View.VISIBLE);
        btnAddImage.setVisibility(View.INVISIBLE);
        receivedImage.setImageBitmap(decoded);

    }

    // fungsi resize image
    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

    void doTheRightThing(){
        //Store data to database
        campaign.setTugas_relawan(volunteerJob.getText().toString());
        campaign.setBarang(logistic.getText().toString());
        campaign.setBriefing(briefing.getText().toString());
        campaign.setInformasi_tambahan(information.getText().toString());
        campaignRef.push()
                .setValue(campaign)
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                    }
                });

        //Upload picture to firebase storage
//        campaignPicRef = storageRef.child("campaign/image");
//        // Get the data from an ImageView as bytes
//        receivedImage.setDrawingCacheEnabled(true);
//        receivedImage.buildDrawingCache();
//        Bitmap bitmap = ((BitmapDrawable) receivedImage.getDrawable()).getBitmap();
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//        byte[] data = baos.toByteArray();
//        UploadTask uploadTask = campaignPicRef.putBytes(data);
//        uploadTask.addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(MakeCampaignDetailActivity.this, "GAGAL UPLOAD GAMBAR", Toast.LENGTH_SHORT).show();
//            }
//        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                Toast.makeText(MakeCampaignDetailActivity.this, "BERHASIL UPLOAD GAMBAR", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
