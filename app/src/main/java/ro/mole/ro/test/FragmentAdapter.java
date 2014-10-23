package ro.mole.ro.test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.preference.PreferenceFragment;

import com.viewpagerindicator.IconPagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter implements IconPagerAdapter{
	
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }
      @Override
    public int getIconResId(int index) {
        // TODO Auto-generated method stub
        return 0;
    }
      @Override
    public Fragment getItem(int position) 
    {
        // TODO Auto-generated method stub
        PreferenceFragment fragment = new PrimeraActividad();
        if (position == 0) {
			fragment = new PrimeraActividad();
		} else if (position == 1) {
			fragment = new SegundaActividad();
		} else if (position == 2) {
			fragment = new TerceraActividad();
		}
		return fragment;
    }
      @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 3;
    }  
      @Override
    public CharSequence getPageTitle(int position){
        String title = "";
        if (position == 0) {
			title = "Ajustes UI";
		} else if (position == 1) {
			title = "Utilidades";
		} else if (position == 2) {
			title = "Acerca de";
		}
        return title;
    }

}