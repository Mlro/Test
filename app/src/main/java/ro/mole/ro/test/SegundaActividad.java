package ro.mole.ro.test;

import android.os.Bundle;
import android.support.v4.preference.PreferenceFragment;


public class SegundaActividad extends PreferenceFragment {
    
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);	
        addPreferencesFromResource(R.xml.utilities);
	}
}