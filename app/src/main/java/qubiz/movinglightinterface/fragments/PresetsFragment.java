package qubiz.movinglightinterface.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import qubiz.movinglightinterface.Preset;
import qubiz.movinglightinterface.R;
import qubiz.movinglightinterface.adapters.PresetListAdapter;

/**
 * Created by QUBiZ on 9-6-2015.
 */
public class PresetsFragment extends Fragment{

    public static final String ARG_POSITION = "PRESETS FRAGMENT POSITION";

    private ListView presetListView;

    public static PresetsFragment newInstance(int position) {
        PresetsFragment fragment = new PresetsFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_POSITION, position);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_presets, container, false);

        Bundle bundle = getArguments();

        if (bundle != null) {
            // SET ARGUMENTS
        }

        Preset preset_data[] = new Preset[] {
            new Preset("PRESET 1", Color.BLUE),
            new Preset("PRESET 2", Color.GREEN)
        };

        PresetListAdapter presetListAdapter = new PresetListAdapter(getActivity(), R.layout.presets_list_item, preset_data);

        presetListView = (ListView) view.findViewById(R.id.list_view_presets);

        presetListView.setAdapter(presetListAdapter);

        return view;
    }
}
