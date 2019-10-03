package id.cybershift.ibest;


import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import id.cybershift.ibest.report.Report1Activity;
import id.cybershift.ibest.ui.login.LoginActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends Fragment implements View.OnClickListener {
    FirebaseAuth auth;
    FirebaseUser user;
    ImageView profilePic;
    GoogleSignInOptions gso;
    GoogleSignInClient googleSignInClient;

    public CommunityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profilePic = view.findViewById(R.id.profile_image);
        Uri profilePicURL = user.getPhotoUrl();

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);

        Glide.with(this).load(profilePicURL).apply(options).into(profilePic);

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
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;
        }
    }
}
