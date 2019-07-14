package in.co.comprotech.ediary;

import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AnalysisFragment()).commit();
            //navigationView.setCheckedItem(R.id.nav_my_school);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_my_school:
                //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.darkBlue)));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MySchoolFragment()).commit();
                break;
            case R.id.nav_calender:
                //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.darkGrey)));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CalenderFragment()).commit();
                break;
            case R.id.nav_message:
                //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.darkOrange)));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessagesFragment()).commit();
                break;
            case R.id.nav_feesbook:
                //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FeesBookFragment()).commit();
                break;
            case R.id.nav_emergency:
                //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.darkRed)));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EmergencyFragment()).commit();
                break;
            case R.id.nav_logout:
                //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.darkPurple)));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UtilityFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_diary:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DiaryFragment()).commit();
                            break;
                        case R.id.nav_notice:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NoticeFragment()).commit();
                            break;
                        case R.id.nav_performance:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AnalysisFragment()).commit();
                            break;
                        case R.id.nav_notification:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NotificationFragment()).commit();
                            break;
                    }

                    return true;

                }
            };

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}
