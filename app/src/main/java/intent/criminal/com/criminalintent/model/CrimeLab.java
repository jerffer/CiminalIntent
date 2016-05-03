package intent.criminal.com.criminalintent.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Sunny on 2016/4/10.
 */
public class CrimeLab {

    private ArrayList<Crime> mCrimes;

    private  static  CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab(Context appcontext){
        this.mAppContext = appcontext;
        mCrimes = new ArrayList<Crime>();

        // just for test
        for(int i =0; i < 100; i++){
            Crime c = new Crime();
            c.setTitle("Crime # " + i);
            c.setSolved(i % 2 == 0);
            mCrimes.add(c);
        }
    }

    public ArrayList<Crime> getCrimes(){
        return  mCrimes;
    }

    public Crime getCrime(UUID id){
        for(Crime c : mCrimes){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return  null;
    }

    public static CrimeLab get(Context c){
        if(sCrimeLab == null){
            synchronized (CrimeLab.class){
                if(sCrimeLab == null){
                    sCrimeLab = new CrimeLab(c.getApplicationContext());
                }
            }
        }
        return sCrimeLab;
    }


}
