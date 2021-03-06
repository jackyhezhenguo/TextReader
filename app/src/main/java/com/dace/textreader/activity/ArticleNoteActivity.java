package com.dace.textreader.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.dace.textreader.R;
import com.dace.textreader.fragment.ExcerptFragment;
import com.dace.textreader.fragment.GlossaryFragment;
import com.dace.textreader.fragment.HomeFragment;
import com.dace.textreader.fragment.NewAppreciationFragment;
import com.dace.textreader.fragment.NoteFragment;
import com.dace.textreader.fragment.RecommendFragment;
import com.dace.textreader.view.tab.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

public class ArticleNoteActivity extends BaseActivity{

    private List<String> mList_title = new ArrayList<>();
    private List<Fragment> mList_fragment = new ArrayList<>();

    private SmartTabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articlenote);

        //修改状态栏的文字颜色为黑色
//        int flag = StatusBarUtil.StatusBarLightMode(this);
//        StatusBarUtil.StatusBarLightMode(this, flag);

//        mPlayer = new MediaPlayer();
        initData();
        initView();
        initEvents();

    }

    private void initData() {
        mList_title.add("生词");
        mList_title.add("摘抄");
        mList_title.add("想法");
        mList_title.add("赏析");

        GlossaryFragment glossaryFragment = new GlossaryFragment();
        ExcerptFragment excerptFragment = new ExcerptFragment();
        NoteFragment noteFragment = new NoteFragment();
        NewAppreciationFragment newAppreciationFragment = new NewAppreciationFragment();
        mList_fragment.add(glossaryFragment);
        mList_fragment.add(excerptFragment);
        mList_fragment.add(noteFragment);
        mList_fragment.add(newAppreciationFragment);
//        RecommendFragment recommendFragment = new RecommendFragment();
//        mList_fragment.add(recommendFragment);
//        HomeFragment homeFragment = new HomeFragment();
//        mList_fragment.add(homeFragment);
    }

    private void initView() {
        tabLayout = findViewById(R.id.tab_layout_new_reader_fragment);
        viewPager = findViewById(R.id.view_pager_new_reader_fragment);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager);
    }

    private void initEvents() {

    }

    /**
     * 适配器
     */
    public class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mList_title.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return mList_fragment.get(position);
        }

        @Override
        public int getCount() {
            return mList_fragment.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

        }
    }
}
