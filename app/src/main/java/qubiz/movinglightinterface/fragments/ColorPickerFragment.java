package qubiz.movinglightinterface.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.SaturationBar;
import com.larswerkman.holocolorpicker.ValueBar;

import qubiz.movinglightinterface.R;
import qubiz.movinglightinterface.tabs.SlidingTabLayout;


public class ColorPickerFragment extends Fragment {
    private static final String ARG_POSITION = "COLOR_PICKER_POSITION";

    private ColorPicker colorPicker;
    private SaturationBar saturationBar;
    private ValueBar valueBar;

    private SlidingTabLayout tabs;

    public static ColorPickerFragment newInstance(int position) {
        ColorPickerFragment colorPickerFragment = new ColorPickerFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_POSITION, position);
        colorPickerFragment.setArguments(arguments);
        return colorPickerFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        savedInstanceState = null;
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color_picker, container, false);
        Log.e("ColorPickerFragment", "onCreateView!");
        colorPicker = (ColorPicker) view.findViewById(R.id.color_picker);
        saturationBar = (SaturationBar) view.findViewById(R.id.saturation_bar);
        valueBar = (ValueBar) view.findViewById(R.id.value_bar);

        colorPicker.setShowOldCenterColor(false);
        colorPicker.addSaturationBar(saturationBar);
        colorPicker.addValueBar(valueBar);

        tabs.setSelectedIndicatorColors(colorPicker.getColor());

        colorPicker.setOnColorChangedListener(new ColorPicker.OnColorChangedListener() {
            @Override
            public void onColorChanged(int i) {
                tabs.setSelectedIndicatorColors(colorPicker.getColor());
                int red = (i >> 16) & 0xff;
                int green = (i >> 8) & 0xff;
                int blue = (i) & 0xff;

                Log.e("COLOR", "(" + red + ", " + green + ", " + blue + ")");
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        tabs = (SlidingTabLayout) activity.findViewById(R.id.sliding_tabs);
        Log.e("ColorPickerFragment", "onAttach!");
        super.onAttach(activity);
    }

    @Override
    public void onDestroy() {
        Log.e("ColoPickerFragment", "onDestroyView!");
        super.onDestroy();
    }
}
