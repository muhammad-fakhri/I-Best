package id.cybershift.ibest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import id.cybershift.ibest.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    HomeFragment homeFragment = new HomeFragment();
                    SearchFragment searchFragment = new SearchFragment();
                    AddFragment addFragment = new AddFragment();
                    StoryFragment storyFragment = new StoryFragment();
                    CommunityFragment communityFragment = new CommunityFragment();
                    Fragment fragment;
                    switch (menuItem.getItemId()) {
                        case R.id.home_menu:
                            fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
                            if (!(fragment instanceof HomeFragment)) {
                                fragmentManager
                                        .beginTransaction()
                                        .replace(R.id.fragment_container, homeFragment, HomeFragment.class.getSimpleName())
                                        .commit();
                            }
                            return true;
                        case R.id.search_menu:
                            fragment = fragmentManager.findFragmentByTag(SearchFragment.class.getSimpleName());
                            if (!(fragment instanceof SearchFragment)) {
                                fragmentManager
                                        .beginTransaction()
                                        .replace(R.id.fragment_container, searchFragment, SearchFragment.class.getSimpleName())
                                        .commit();
                            }
                            return true;
                        case R.id.add_menu:
                            fragment = fragmentManager.findFragmentByTag(AddFragment.class.getSimpleName());
                            if (!(fragment instanceof AddFragment)) {
                                fragmentManager
                                        .beginTransaction()
                                        .replace(R.id.fragment_container, addFragment, AddFragment.class.getSimpleName())
                                        .commit();
                            }
                            return true;
                        case R.id.story_menu:
                            fragment = fragmentManager.findFragmentByTag(StoryFragment.class.getSimpleName());
                            if (!(fragment instanceof StoryFragment)) {
                                fragmentManager
                                        .beginTransaction()
                                        .replace(R.id.fragment_container, storyFragment, StoryFragment.class.getSimpleName())
                                        .commit();
                            }
                            return true;
                        case R.id.community_menu:
                            fragment = fragmentManager.findFragmentByTag(CommunityFragment.class.getSimpleName());
                            if (!(fragment instanceof CommunityFragment)) {
                                fragmentManager
                                        .beginTransaction()
                                        .replace(R.id.fragment_container, communityFragment, CommunityFragment.class.getSimpleName())
                                        .commit();
                            }
                            return true;
                        default:
                            return false;
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        BottomNavigationView navigationView = findViewById(R.id.main_bn);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            navigationView.setSelectedItemId(R.id.home_menu);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Halo " + user.getDisplayName(), Toast.LENGTH_SHORT).show();
        }
    }
}
