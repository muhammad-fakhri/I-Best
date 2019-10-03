package id.cybershift.ibest;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

import id.cybershift.ibest.report.Report1Activity;
import id.cybershift.ibest.ui.login.LoginActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends Fragment implements View.OnClickListener {
    FirebaseAuth auth;

    public CommunityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        auth = FirebaseAuth.getInstance();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView peopleIcon = view.findViewById(R.id.people_menu);
        CardView reportNotif = view.findViewById(R.id.report_notif);
        View underlineTimeline = view.findViewById(R.id.underline_timeline_part);
        underlineTimeline.setVisibility(View.INVISIBLE);
        View underlineAlbum = view.findViewById(R.id.underline_album_part);
        underlineAlbum.setVisibility(View.INVISIBLE);
        peopleIcon.setOnClickListener(this);
        reportNotif.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.report_notif:
                startActivity(new Intent(view.getContext(), Report1Activity.class));
                break;
            case R.id.people_menu:
                auth.signOut();
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;
        }
    }
}
