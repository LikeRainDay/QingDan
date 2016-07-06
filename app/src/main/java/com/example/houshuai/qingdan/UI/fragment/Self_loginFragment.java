package com.example.houshuai.qingdan.UI.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.houshuai.qingdan.R;

import butterknife.ButterKnife;

/**
 * Created by HouShuai on 2016/7/6.
 */

public class Self_loginFragment extends Fragment implements View.OnClickListener {
    public final String TAG;
    private FragmentManager manager;
    private boolean isPop;
    private LayoutInflater inflater;
    private RelativeLayout linearLayout;

    public Self_loginFragment() {
        TAG = this.getClass().getSimpleName();
        isPop = true;
    }
    public void hideView() {
        if (isPop) {
            if (getFragmentManager() != null && getFragmentManager().getBackStackEntryCount() != 0) {
                getFragmentManager().popBackStack();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.remove(this);
                transaction.commitAllowingStateLoss();
                isPop = false;
            }
        }
    }


    public View createPopView() {
        FrameLayout parent = new FrameLayout(getActivity());
        parent.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.BOTTOM;
        linearLayout = (RelativeLayout) inflater.inflate(R.layout.self_islogin_pop, null);
        ButterKnife.bind(this, linearLayout);
        linearLayout.setLayoutParams(params);
        parent.addView(linearLayout);


        return parent;
    }

    private ViewGroup parentView;
    private View popView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        parentView = (ViewGroup) getActivity().getWindow().getDecorView();
        popView = createPopView();
        parentView.addView(popView);
        linearLayout.startAnimation(createTranslationInAnimation());

        return super.onCreateView(inflater, container, savedInstanceState);

    }

    private Animation createTranslationInAnimation() {
        int type = TranslateAnimation.RELATIVE_TO_SELF;
        TranslateAnimation an = new TranslateAnimation(type, 0, type, 0, type, 1, type, 0);
        an.setDuration(300);
        return an;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        linearLayout.startAnimation(createTranslationOutAnimation());

        popView.postDelayed(new Runnable() {
            @Override
            public void run() {
                parentView.removeView(popView);
                parentView = null;
                popView = null;
                inflater = null;
                linearLayout = null;
            }
        }, 300);
    }

    private Animation createTranslationOutAnimation() {
        int type = TranslateAnimation.RELATIVE_TO_SELF;
        TranslateAnimation an = new TranslateAnimation(type, 0, type, 0, type, 0, type, 1);
        an.setDuration(300);
        an.setFillAfter(true);
        return an;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // TODO: 2016/7/6  
        }
    }
}
