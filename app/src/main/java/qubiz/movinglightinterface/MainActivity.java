package qubiz.movinglightinterface;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import qubiz.movinglightinterface.fragments.AutomaticModeFragment;
import qubiz.movinglightinterface.fragments.ManualModeFragment;

public class MainActivity extends ActionBarActivity {

    AppCompatButton modeToggleButton;

    private boolean automaticMode = true;

    private AutomaticModeFragment automaticModeFragment;
    private ManualModeFragment manualModeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // SET THE TOOLBAR
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }

        // CREATE THE FRAGMENTS
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            automaticModeFragment = new AutomaticModeFragment();
            manualModeFragment = new ManualModeFragment();

            automaticModeFragment.setArguments(getIntent().getExtras());
            manualModeFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, automaticModeFragment)
                    .commit();
        }

        modeToggleButton = (AppCompatButton) findViewById(R.id.mode_toggle_button);
        modeToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (automaticMode) {
                    modeToggleButton.setText("M A N U A L");
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, manualModeFragment, "MANUAL_TAG")
                            .commit();
                    automaticMode = false;
                } else {
                    modeToggleButton.setText("A U T O M A T I C");
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, automaticModeFragment, "AUTOMATIC_TAG")
                            .commit();
                    automaticMode = true;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_bar_on_off_switch);
        item.setActionView(R.layout.action_bar_on_off_switch);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
