package android.suyash.com.demoyoutube.activities;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.suyash.com.demoyoutube.R;
import android.suyash.com.demoyoutube.adapter.UserLandingPagerAdapter;
import android.suyash.com.demoyoutube.views.NonSwipableViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UserLandingActivity extends AppCompatActivity {
    private UserLandingPagerAdapter userLandingPagerAdapter;
    private NonSwipableViewPager viewPager;
    private TabLayout tabLayout;
    int PAGER_POSITION_FULL_MENU = 0;

    private int position = PAGER_POSITION_FULL_MENU;

    private boolean isPageChanged = false;


    private TabLayout.OnTabSelectedListener tabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            if (!isPageChanged) {
                isPageChanged = true;
                viewPager.setCurrentItem(tab.getPosition());
            }

        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };

    private int[] count = {0, 0};
    private int selectedTabposition;
    private ViewPager.OnPageChangeListener pagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            if (tabLayout.getTabAt(position) != null) {
                tabLayout.getTabAt(position).select();
            }
           /* if (mDishList != null) {
                getCurrentFragment().sendListData(mDishList);
            }*/
            setCustomTab();
            isPageChanged = false;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_landing);
        setupViewPager();
        setUpTabLayout();
    }

    private void setUpTabLayout() {
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(tabSelectedListener);
        setCustomTab();
    }

    private void setupViewPager() {
        viewPager = (NonSwipableViewPager) findViewById(R.id.viewpager);
      /*  pullToRefresh = (SwipeRefreshLayout) findViewById(R.id
                .menu_swipe_refresh_layout);*/
        userLandingPagerAdapter = new UserLandingPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(userLandingPagerAdapter);
        viewPager.addOnPageChangeListener(pagerChangeListener);
    }

    private void setCustomTab() {
        selectedTabposition = tabLayout.getSelectedTabPosition();
        tabLayout.removeAllTabs();
        for (int i = 0; i < count.length; i++) {
            TabLayout.Tab tab = tabLayout.newTab();
            View view = getTabView(i);
            tab.setCustomView(view);
            tabLayout.addTab(tab);
        }
        if (tabLayout.getTabAt(selectedTabposition) != null)
            tabLayout.getTabAt(selectedTabposition).select();
    }

    public View getTabView(final int position) {
        int[] tabTitles = {R.string.feed, R.string.videos};
       // int[] icons = {R.drawable.full_menu, R.drawable.activate_dish, R.drawable.full_menu};
        View v = LayoutInflater.from(this).inflate(R.layout.custom_menu_tab_layout, null);
        final TextView textView = (TextView) v.findViewById(R.id.menu_tab_text_view);
        textView.setText(getString(tabTitles[position]));
        ImageView tabIndicatorImageView = (ImageView) v.findViewById(R.id.tab_indicator);
        if (position == selectedTabposition) {
            tabIndicatorImageView.setVisibility(View.VISIBLE);
            textView.setTypeface(null, Typeface.BOLD);
            textView.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));

        } else {
            tabIndicatorImageView.setVisibility(View.GONE);
            textView.setTypeface(null, Typeface.NORMAL);
            textView.setTextColor(ContextCompat.getColor(this, R.color.profile_milestones_grey));

        }
        return v;
    }
    public void swipeViewPager(int pagerPosition) {
        viewPager.setCurrentItem(pagerPosition);
    }

}
