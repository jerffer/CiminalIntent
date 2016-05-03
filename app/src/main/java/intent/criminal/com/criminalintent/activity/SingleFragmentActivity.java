package intent.criminal.com.criminalintent.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.util.Log;

import intent.criminal.com.criminalintent.R;

/**
 * Created by Sunny on 2016/4/10.
 */
public abstract  class SingleFragmentActivity extends FragmentActivity {
    protected  abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }
}
