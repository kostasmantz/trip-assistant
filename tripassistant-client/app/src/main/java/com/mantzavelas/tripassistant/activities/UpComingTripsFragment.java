package com.mantzavelas.tripassistant.activities;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mantzavelas.tripassistant.R;
import com.mantzavelas.tripassistant.adapters.TripsAdapter;
import com.mantzavelas.tripassistant.models.enums.TripStatus;
import com.mantzavelas.tripassistant.restservices.dtos.TripDto;
import com.mantzavelas.tripassistant.restservices.tasks.GetTripsTask;

import java.util.Collection;
import java.util.List;

public class UpComingTripsFragment extends TripFragmentPage {

    @Override
    public String getTitle() {
        return TripPages.UPCOMING_TRIPS.getName();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_trip_page;
    }

    @Override
    public boolean displayMidButton() {
        return true;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new GetTripsTask(getContext(), this).execute(TripStatus.UPCOMING);
    }

    @Override
    public void onResume() {
        super.onResume();
        new GetTripsTask(getContext(), this).execute(TripStatus.UPCOMING);
    }

    @Override
    public void onDataSetChanged(Collection<?> dataSet) {
        this.items.clear();
        this.items.addAll((List<TripDto>) dataSet);
        ((TripsAdapter)this.adapter).setDataSet(items);
        this.adapter.notifyDataSetChanged();
    }
}
