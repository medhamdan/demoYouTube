package android.suyash.com.demoyoutube.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.suyash.com.demoyoutube.fragments.FeedFragment;
import android.suyash.com.demoyoutube.fragments.VideosFragment;

public class UserLandingPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private int mUpdatedPosition;

    public UserLandingPagerAdapter(Context context, FragmentManager childFragmentManager) {
        super(childFragmentManager);
        this.context = context;
    }

    @Override

    public Fragment getItem(int position) {
        if (position == 0) {
            return new FeedFragment();
        } else if (position == 1) {
            return new VideosFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return null;
    }

    public void updateFragment(int position) {
        mUpdatedPosition = position;
        notifyDataSetChanged();
    }
}
