package ru.orlovph.criminalintent2020;

import androidx.fragment.app.Fragment;

@Deprecated
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
