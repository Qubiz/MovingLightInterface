package qubiz.movinglightinterface.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import qubiz.movinglightinterface.Preset;
import qubiz.movinglightinterface.R;

/**
 * Created by Mathijs on 09/06/2015.
 */
public class PresetListAdapter extends ArrayAdapter<Preset> {
    private Context context;
    private int resourceId;
    private Preset data[] = null;

    public PresetListAdapter(Context context, int resourceId, Preset[] data) {
        super(context, resourceId, data);

        this.context = context;
        this.resourceId = resourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        PresetHolder holder = null;

        if(row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(resourceId, parent, false);

            holder = new PresetHolder();
            holder.textViewPresetName = (TextView) row.findViewById(R.id.text_view_preset_list_item);
            holder.surfaceViewPresetColor = (SurfaceView) row.findViewById(R.id.surface_view_preset_color);

            row.setTag(holder);
        } else {
            holder = (PresetHolder) row.getTag();
        }

        Preset preset = data[position];
        holder.textViewPresetName.setText(preset.getName());
        holder.surfaceViewPresetColor.setBackgroundColor(preset.getColor());

        return row;
    }

    private static class PresetHolder {
        TextView textViewPresetName;
        SurfaceView surfaceViewPresetColor;
    }
}
