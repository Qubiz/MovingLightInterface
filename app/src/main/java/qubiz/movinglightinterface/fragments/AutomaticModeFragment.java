package qubiz.movinglightinterface.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import qubiz.movinglightinterface.R;

/**
 * Created by Mathijs on 08/06/2015.
 */
public class AutomaticModeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_automatic_mode, container, false);

        Bundle bundle = getArguments();
        if(bundle != null) {
            // SET ARGUMENTS
        }
        return view;
    }
}
