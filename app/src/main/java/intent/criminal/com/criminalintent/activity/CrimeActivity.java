package intent.criminal.com.criminalintent.activity;

import android.app.Fragment;

import java.util.UUID;

import intent.criminal.com.criminalintent.fragment.CrimeFragment;

public class CrimeActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		//return new CrimeFragment();
		UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
		return CrimeFragment.newInstance(crimeId);
	}
}
