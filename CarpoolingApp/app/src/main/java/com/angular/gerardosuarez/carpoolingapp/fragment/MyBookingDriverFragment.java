package com.angular.gerardosuarez.carpoolingapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angular.gerardosuarez.carpoolingapp.R;
import com.angular.gerardosuarez.carpoolingapp.data.preference.map.MapPreferenceImpl;
import com.angular.gerardosuarez.carpoolingapp.mvp.presenter.MyBookingDriverFragmentPresenter;
import com.angular.gerardosuarez.carpoolingapp.mvp.view.MyBookingDriverView;
import com.angular.gerardosuarez.carpoolingapp.service.MyBookingDriverService;
import com.angular.gerardosuarez.carpoolingapp.service.UserService;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyBookingDriverFragment extends Fragment {

    public static final String TAG = "my_quota";
    private MyBookingDriverFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_booking_driver, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new MyBookingDriverFragmentPresenter(
                new MyBookingDriverView(this),
                new MyBookingDriverService(),
                new UserService(),
                new MapPreferenceImpl(getActivity(), MapPreferenceImpl.NAME));
        presenter.init();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getRequestsOfDriver();
    }

    @OnClick(R.id.btn_start_travel)
    void onStartTravelClick() {
        presenter.onStartTravel();
    }

    @OnClick(R.id.btn_cancel_route)
    void onCancelBooking() {
        presenter.onCancelRoute();
    }
}
