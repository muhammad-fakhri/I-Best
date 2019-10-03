package id.cybershift.ibest.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

import id.cybershift.ibest.R;
import id.cybershift.ibest.model.Campaign;
import id.cybershift.ibest.ui.login.LoginActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    FirebaseDatabase database;
    DatabaseReference campaignRef;
    RecyclerView homeCampaign;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView notificationMenu = view.findViewById(R.id.notification_menu);
        notificationMenu.setOnClickListener(this);

//        homeCampaign = view.findViewById(R.id.rv_home_campaign);

        database = FirebaseDatabase.getInstance();
        campaignRef = database.getReference("campaign");

        campaignRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getAllCampaignData((Map<String, Object>) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getAllCampaignData(Map<String, Object> campaign) {
        Log.d("FAKHRI", "berhasil ambil data dari database");
//        ArrayList<Campaign> campaignList = new ArrayList<>();
//
//        for (Map.Entry<String, Object> entry : campaign.entrySet()) {
//            //Get user map
//            Map singleCampaign = (Map) entry.getValue();
//            //Get phone field and append to list
//            Campaign item = new Campaign();
//            item.setBarang((String) singleCampaign.get("barang"));
//            item.setInformasi_tambahan((String) singleCampaign.get("informasi_tambahan"));
//            item.setJudul((String) singleCampaign.get("judul"));
//            item.setBatas_registrasi((String) singleCampaign.get("batas_registrasi"));
//            item.setBarang((String) singleCampaign.get("barang"));
//            item.setLokasi((String) singleCampaign.get("lokasi"));
//            item.setPeriode_waktu((String) singleCampaign.get("periode_waktu"));
//            item.setTugas_relawan((String) singleCampaign.get("tugas_relawan"));
//            item.setUserUID((String) singleCampaign.get("userUID"));
//            campaignList.add(item);
//        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}
