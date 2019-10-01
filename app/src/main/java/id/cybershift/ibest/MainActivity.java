package id.cybershift.ibest;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    boolean isDone = true;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    HomeFragment homeFragment = new HomeFragment();
                    SearchFragment searchFragment = new SearchFragment();
                    AddFragment addFragment = new AddFragment();
                    StoryFragment storyFragment = new StoryFragment();
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
                        default:
                            return false;
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.main_bn);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            navigationView.setSelectedItemId(R.id.home_menu);
        }
    }

}
