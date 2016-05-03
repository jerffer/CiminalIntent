package intent.criminal.com.criminalintent.fragment;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import intent.criminal.com.criminalintent.R;
import intent.criminal.com.criminalintent.activity.CrimeActivity;
import intent.criminal.com.criminalintent.adapter.CrimeAdapter;
import intent.criminal.com.criminalintent.model.Crime;
import intent.criminal.com.criminalintent.model.CrimeLab;

/**
 * Created by Sunny on 2016/4/10.
 */
public class CrimeListFragment extends ListFragment {

    private  static  final  String TAG = "CrimeListFragment";
    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crime_title);

        mCrimes = CrimeLab.get(getActivity()).getCrimes();

        CrimeAdapter adapter = new CrimeAdapter(getActivity(), mCrimes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //Crime c = (Crime)(getListAdapter()).getItem(position);
        Crime c = ((CrimeAdapter)(getListAdapter())).getItem(position);
        //Log.d(TAG, c.getTitle() + " was clicked");

        //Start CrimeActivity

        Intent i = new Intent(getActivity(), CrimeActivity.class);
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getId());
        startActivity(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
    }
}
