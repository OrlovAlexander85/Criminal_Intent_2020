package ru.orlovph.criminalintent2020;

import androidx.fragment.app.Fragment;

@Deprecated
public class CrimeListActivity extends SingleFragmentActivity {
    private static final String TAG = "CrimeListActivity";
    private static final int REQUEST_CODE = 42;
    private static final long ANIMATION_DURATION = 300L;

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
