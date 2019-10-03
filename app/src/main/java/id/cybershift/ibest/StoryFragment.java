package id.cybershift.ibest;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.cybershift.ibest.story.ExperienceFragment;
import id.cybershift.ibest.story.ProblemFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class StoryFragment extends Fragment implements View.OnClickListener {

    View uProblem, uExperience;
    ProblemFragment problemFragment;
    ExperienceFragment experienceFragment;

    public StoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_story, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Casting View
        TextView problem = view.findViewById(R.id.story_problem_part);
        TextView experience = view.findViewById(R.id.story_experience_part);
        problem.setOnClickListener(this);
        experience.setOnClickListener(this);
        uProblem = view.findViewById(R.id.underline_problem_part);
        uExperience = view.findViewById(R.id.underline_experience_part);

        if (savedInstanceState == null) {
            toProblemFragmentOrNot(true);
            underlineVisibilty(true);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.story_experience_part) {
            toProblemFragmentOrNot(false);
        } else if (view.getId() == R.id.story_problem_part) {
            toProblemFragmentOrNot(true);
        }
    }

    void underlineVisibilty(boolean isStoryUnderlineOrNot) {
        if (isStoryUnderlineOrNot) {
            uProblem.setVisibility(View.VISIBLE);
            uExperience.setVisibility(View.INVISIBLE);
        } else {
            uProblem.setVisibility(View.INVISIBLE);
            uExperience.setVisibility(View.VISIBLE);
        }
    }

    void toProblemFragmentOrNot(boolean yes) {
        if (yes) {
            problemFragment = new ProblemFragment();
            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.story_fragment_container, problemFragment, ProblemFragment.class.getSimpleName())
                    .commit();
            underlineVisibilty(true);
        } else {
            experienceFragment = new ExperienceFragment();
            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.story_fragment_container, experienceFragment, ExperienceFragment.class.getSimpleName())
                    .commit();
            underlineVisibilty(false);
        }
    }
}
