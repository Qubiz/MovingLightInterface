package qubiz.movinglightinterface.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import qubiz.movinglightinterface.R;
import qubiz.movinglightinterface.adapters.MyPagerAdapter;
import qubiz.movinglightinterface.tabs.SlidingTabLayout;

/**
 * Created by QUBiZ on 9-6-2015.
 */
public class ManualModeFragment extends Fragment {

    private ViewPager viewPager;
    private SlidingTabLayout tabs;

    private MyPagerAdapter myPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.e("ManualModeFragment", "onAttach!");
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manual_mode, container, false);
        Log.e("ManualModeFragment", "onCreateView!");
        myPagerAdapter = new MyPagerAdapter(getFragmentManager());

        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        viewPager.setAdapter(new MyPagerAdapter(getFragmentManager()));

        tabs = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        tabs.setDistributeEvenly(true);
        tabs.setViewPager(viewPager);

        Bundle bundle = getArguments();
        if(bundle != null) {
            // SET ARGUMENTS
        }
        return view;
    }

    @Override
    public void onStop() {
        Log.e("ManualModeFragment", "onStopView!");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
