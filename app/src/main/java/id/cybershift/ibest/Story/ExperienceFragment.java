package id.cybershift.ibest.Story;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.cybershift.ibest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExperienceFragment extends Fragment {


    public ExperienceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_experience, container, false);
    }

}