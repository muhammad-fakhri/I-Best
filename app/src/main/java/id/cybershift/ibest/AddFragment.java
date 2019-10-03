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
import android.widget.Toast;

import id.cybershift.ibest.campaign.ChooseProblemActivity;
import id.cybershift.ibest.experience.ExperienceDataActivity;
import id.cybershift.ibest.problem.ProblemDataActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment implements View.OnClickListener {


    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CardView reportProblem = view.findViewById(R.id.btn_report_problem);
        CardView shareStory = view.findViewById(R.id.btn_share_story);
        CardView makeCampaign = view.findViewById(R.id.btn_make_campaign);
        reportProblem.setOnClickListener(this);
        shareStory.setOnClickListener(this);
        makeCampaign.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_make_campaign:
                startActivity(new Intent(this.getActivity(), ChooseProblemActivity.class));
                break;
            case R.id.btn_report_problem:
                startActivity(new Intent(this.getActivity(), ProblemDataActivity.class));
                break;
            case R.id.btn_share_story:
                startActivity(new Intent(this.getActivity(), ExperienceDataActivity.class));
                break;
            default:
                break;
        }
    }
}
