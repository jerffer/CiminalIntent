package intent.criminal.com.criminalintent.activity;

import android.app.Fragment;

import intent.criminal.com.criminalintent.fragment.CrimeListFragment;

/**
 * Created by Sunny on 2016/4/10.
 */
public class CrimeListActivity extends  SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
