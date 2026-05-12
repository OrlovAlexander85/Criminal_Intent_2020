package ru.orlovph.criminalintent2020;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;
import java.util.UUID;

public class CrimePagerActivity extends AppCompatActivity {

    private static final String EXTRA_CRIME_ID =
            "ru.orlovph.criminalintent2020.crime_id";
    private static final String PAGE_STATE_KEY = "pager_page";
    private static final int DEFAULT_PAGE_INDEX = 0;
    private static final boolean ENABLE_PAGINATION = true;

    private ViewPager2 mViewPager;
    private List<Crime> mCrimes;

    public static Intent newIntent(Context packageContext, UUID crimeID){
        Intent intent = new Intent(packageContext, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeID);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_crime_pager);

        UUID crimeID = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        mViewPager = findViewById(R.id.crime_view_pager);

//        get data set from CrimeLab – the List of crimes
        mCrimes = CrimeLab.get(this).getCrimes();
//        get the activity’s instance of FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
//        set the adapter to be an unnamed instance of FragmentStateAdapter
        mViewPager.setAdapter(new FragmentStateAdapter(fragmentManager,getLifecycle()) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                Crime crime = mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getmID());
            }

            @Override
            public int getItemCount() {
                return mCrimes.size();
            }
        });

        for (int i = 0; i < mCrimes.size(); i++) {
            if (mCrimes.get(i).getmID().equals(crimeID)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    // Unused utility methods
    private int getCurrentCrimeIndex() {
        return mViewPager.getCurrentItem();
    }

    private Crime getCurrentCrime() {
        int index = getCurrentCrimeIndex();
        if (index >= 0 && index < mCrimes.size()) {
            return mCrimes.get(index);
        }
        return null;
    }

    private boolean hasNextCrime() {
        return getCurrentCrimeIndex() < mCrimes.size() - 1;
    }
}
