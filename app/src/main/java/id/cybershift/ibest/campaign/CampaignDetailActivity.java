package id.cybershift.ibest.campaign;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import id.cybershift.ibest.R;
import id.cybershift.ibest.model.Campaign;

public class CampaignDetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_CAMPAIGN_DATA = "extra_campaign_data";
    int PICK_IMAGE_REQUEST = 1;
    Bitmap bitmap, decoded;
    ImageView receivedImage, btnAddImage;
    int bitmap_size = 60; // range 1 - 100

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_detail);

        Campaign campaign= getIntent().getParcelableExtra(EXTRA_CAMPAIGN_DATA);

        Button btnNext = findViewById(R.id.next_button);
        ImageView backButton = findViewById(R.id.back_button);
        btnAddImage = findViewById(R.id.add_image_btn);
        receivedImage = findViewById(R.id.received_image);
        btnNext.setOnClickListener(this);
        backButton.setOnClickListener(this);
        btnAddImage.setOnClickListener(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("campaign");

//        Intent intent = getIntent();
//        Campaign campaign = new Campaign(
//                intent.getStringExtra("EXTRA_TITLE"),
//                intent.getStringExtra("EXTRA_TIME"),
//                intent.getStringExtra("EXTRA_DEADLINE"),
//                intent.getStringExtra("EXTRA_LOCATION")
//        );

        reference.child("campaign").push()
                .setValue(campaign)
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(CampaignDetailActivity.this, "BERHASIL MENYIMPAN DATA KE DATABASE", Toast.LENGTH_SHORT).show();
                    }
                });
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
            startActivity(new Intent(this, MakeCampaignDoneActivity.class));
        }
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
}
