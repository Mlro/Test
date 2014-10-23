package ro.mole.ro.test;


import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

import eu.inmite.android.lib.dialogs.ISimpleDialogListener;
import eu.inmite.android.lib.dialogs.SimpleDialogFragment;

import static com.nineoldandroids.view.ViewPropertyAnimator.animate;

public class PrincipalActividad extends SherlockFragmentActivity implements
        ISimpleDialogListener  {

    private static final String TAG = "Test";
    FragmentAdapter mAdapter;
    ViewPager mPager;
    PageIndicator mIndicator;
    ImageView image;
    int Number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_segundaria);

        boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun", true);
        if (firstrun){
            SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.enter_title).setMessage(R.string.dialog_enter).show();
            // Save the state
            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("firstrun", false)
                    .commit();}

        mAdapter = new FragmentAdapter(getSupportFragmentManager());
        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        mIndicator = (TitlePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }

    public void rotate(View view) {
        image = (ImageView) findViewById(R.id.image_about);
        image.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                animate(image)
                        .rotationBy((Math.random() > 0.5f ? 360 : -360))
                        .setInterpolator(new DecelerateInterpolator())
                        .setDuration(700).start();
            }
        });
    }

    public void thread(View view){
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://forum.xda-developers.com/showthread.php?t=2532865")));}
    public void credits(View view){
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.credits_title).setMessage(R.string.credits).show();}
    private ShareActionProvider mShareActionProvider;




    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.my, menu);
        mShareActionProvider = (ShareActionProvider) menu.findItem(R.id.emailButton).getActionProvider();
        Intent emailIntent = getDefaultShareIntent();
        if (emailIntent != null)
            mShareActionProvider.setShareIntent(emailIntent);
        return true;

    }

    private Intent getDefaultShareIntent() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"juanantoniomolero73@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getText(R.string.email_subject));
        emailIntent.setType("plain/text");
        return emailIntent;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int itemId = item.getItemId();
        if (itemId == R.id.more) {
            return true;
        } else if (itemId == R.id.aboutButton) {
            SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.about_title).setMessage(R.string.dialog_about).show();
        } else if (itemId == R.id.rebootButton) {
            SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.reboot_title).setMessage(R.string.reboot_message).setPositiveButtonText(R.string.positive_button).setNegativeButtonText(R.string.negative_button).setRequestCode(1).show();
        }
        return true;

    }

    @Override
    public void onPositiveButtonClicked(int requestCode){
        if (requestCode == 1) {
            try {
                Process proc = Runtime.getRuntime().exec(new String[] { "su", "-c", "reboot" });
                proc.waitFor();
            } catch (Exception ex) {
                Log.i(TAG, "No se pudo reiniciar", ex);
            }
        }
    }
    @Override
    public void onNegativeButtonClicked(int requestCode) {
        if (requestCode == 1) {
        }
    }

}

