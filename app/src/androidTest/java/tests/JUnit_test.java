package tests;

import android.content.DialogInterface;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.btusa_000.cse110_lab3.MainActivity;
import com.example.btusa_000.cse110_lab3.R;

/**
 * Created by btusa_000 on 4/16/2016.
 */
public class JUnit_test extends ActivityInstrumentationTestCase2 {

    MainActivity mainActivity;

    public JUnit_test()
    {
        super(MainActivity.class);
    }

    public void test_first() throws Throwable {
        mainActivity = (MainActivity) getActivity();
        final EditText const1 = (EditText) mainActivity.findViewById(R.id.const1);
        final EditText const2 = (EditText) mainActivity.findViewById(R.id.const2);
        final TextView sum = (TextView) mainActivity.findViewById(R.id.sum);
        final Button adder = (Button) mainActivity.findViewById(R.id.button);
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainActivity.num1.setText("5");
                mainActivity.num2.setText("6");
                adder.performClick();
            }
        });

        assertEquals(Integer.parseInt(sum.getText().toString()), Integer.parseInt(const1.getText().toString())
                + Integer.parseInt(const2.getText().toString()));
    }
}
