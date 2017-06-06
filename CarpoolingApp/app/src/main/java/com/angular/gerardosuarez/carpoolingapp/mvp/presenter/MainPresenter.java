package com.angular.gerardosuarez.carpoolingapp.mvp.presenter;

import com.angular.gerardosuarez.carpoolingapp.activity.MainActivity;
import com.angular.gerardosuarez.carpoolingapp.mvp.view.MainView;

public class MainPresenter {

    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void init() {
        MainActivity activity = view.getActivity();
        if (activity == null) {
            return;
        }
        if (activity.getFragmentManager() == null) {
            return;
        }
        view.init();
    }

    public void goToDriverMapFragment() {
        view.goToDriverMapFragment();
        view.showMenu();
    }

    public void goToMyProfileFragment() {
        view.goToMyProfileFragment();
        view.hideMenu();
    }

    public void goToMyQuotaFragment() {
        view.goToMyQuotaFragment();
        view.showMenu();
    }
}
