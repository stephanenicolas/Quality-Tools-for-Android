package com.octo.android.sample.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.octo.android.sample.R;
import com.octo.android.sample.model.Computer;
import com.octo.android.sample.model.DummyComputer;

/**
 * A simple testable activity.
 * @author SNI
 */
public class HelloAndroidActivity extends Activity {

    // ----------------------------------
    // CONSTANTS
    // ----------------------------------

    private static final String TAG = HelloAndroidActivity.class.getSimpleName();

    // ----------------------------------
    // ATTIBUTES
    // ----------------------------------
    private Button button;
    private TextView textView;
    private Computer computer;

    // ----------------------------------
    // LIFE CYCLE
    // ----------------------------------
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.main);
        button = (Button) findViewById(R.id.button_main);
        textView = (TextView) findViewById(R.id.textview_hello);
        button.setOnClickListener(new ButtonClickListener());
        computer = new DummyComputer();
    }

    // ----------------------------------
    // PUBLIC API
    // ----------------------------------

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    // ----------------------------------
    // INNER CLASS
    // ----------------------------------
    private final class ButtonClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            if (computer != null) {
                textView.setText(String.valueOf(computer.getResult()));
            }
        }
    }
}
