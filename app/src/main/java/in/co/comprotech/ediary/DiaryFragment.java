package in.co.comprotech.ediary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class DiaryFragment extends Fragment {

    Button cw,hw;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_diary,container,false);


        //topNav.setSelectedItemId(R.id.nav_diary_hw);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DiaryFragmentHW()).commit();
        BottomNavigationView topNav = v.findViewById(R.id.nav_diary);
        topNav.setOnNavigationItemSelectedListener(navListener);
        topNav.getMenu().findItem(R.id.nav_diary_hw).setChecked(true);

        return v;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_diary_cw:
                            Toast.makeText(getActivity(), "Classwork.", Toast.LENGTH_LONG)
                                    .show();
                            break;
                        case R.id.nav_diary_hw:
                            Toast.makeText(getActivity(), "Homework.", Toast.LENGTH_LONG)
                                    .show();
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DiaryFragmentHW()).commit();
                            break;
                    }

                    return true;

                }
            };

}
