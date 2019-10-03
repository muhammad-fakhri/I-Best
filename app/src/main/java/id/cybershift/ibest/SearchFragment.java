package id.cybershift.ibest;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View underlineOrganization = view.findViewById(R.id.underline_organization_part);
        underlineOrganization.setVisibility(View.INVISIBLE);
        View underlineVolunteer = view.findViewById(R.id.underline_volunteer_part);
        underlineVolunteer.setVisibility(View.INVISIBLE);
//        TextView organizationSearch = view.findViewById(R.id.search_organization_part);
//        organizationSearch.setVisibility(View.INVISIBLE);
//        TextView volunteerSearch = view.findViewById(R.id.search_volunteer_part);
//        volunteerSearch.setVisibility(View.INVISIBLE);
    }
}
