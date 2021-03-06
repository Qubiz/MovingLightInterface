package qubiz.movinglightinterface.adapters;

/**
 * Created by Mathijs on 08/06/2015.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import qubiz.movinglightinterface.fragments.ColorPickerFragment;
import qubiz.movinglightinterface.fragments.PresetsFragment;

public class MyPagerAdapter extends FragmentPagerAdapter{

    private final int FRAGMENT_COUNT = 2;

    ColorPickerFragment colorPickerFragment;
    PresetsFragment presetsFragment;

    final String[] tabNames = new String[] {
            "PRESETS",
            "COLOR PICKER"
    };

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabNames[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                if(presetsFragment == null) {
                    presetsFragment = PresetsFragment.newInstance(position);
                }
                return presetsFragment;
            case 1:
                if(colorPickerFragment == null) {
                    colorPickerFragment = ColorPickerFragment.newInstance(position);
                }
                return colorPickerFragment;
            default: return null;
        }
    }

    public ColorPickerFragment getColorPickerFragment() {
        return colorPickerFragment;
    }

    public PresetsFragment getPresetsFragment() {
        return presetsFragment;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }
}
