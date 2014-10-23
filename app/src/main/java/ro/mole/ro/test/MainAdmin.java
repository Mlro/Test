package ro.mole.ro.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Juan on 07/10/2014.
 */

public class MainAdmin extends Activity {

    static {
        System.loadLibrary("MyLib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.textVieww);
        tv.setText(getStringFromNative());
    }
    public native String getStringFromNative();
}
