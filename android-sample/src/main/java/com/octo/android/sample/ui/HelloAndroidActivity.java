package com.octo.android.sample.ui;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.octo.android.sample.R;
import com.octo.android.sample.model.Computer;
import com.octo.android.sample.model.DummyComputer;

/**
 * A simple testable activity.
 * @author SNI
 */
public class HelloAndroidActivity extends FragmentActivity {

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
            } else {
                // only tested by unit tests, not it tests
                textView.setText(R.string.text_no_computer);
            }
            DateTime dt = new DateTime();
            DateTimeFormatter fmt = DateTimeFormat.forPattern("MMMM, yyyy");
            String dateString = fmt.print(dt);
            Toast.makeText(HelloAndroidActivity.this, dateString, Toast.LENGTH_LONG).show();
        }
    }
}
