package com.noname.daggerexam2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.noname.daggerexam2.databinding.ActivityDetailBinding;
import com.noname.daggerexam2.logic.NetworkApi;
import com.noname.daggerexam2.repository.CustomRoom;
import com.noname.daggerexam2.view.CustomAdapter;
import com.noname.daggerexam2.viewmodel.CustomViewModel;
import dagger.android.AndroidInjection;

import javax.inject.Inject;
import java.util.UUID;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding activityDetailBinding;
    private CustomViewModel customViewModel;

    @Inject
    NetworkApi networkApi;

    @Inject
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        activityDetailBinding.setLifecycleOwner(this);


        customViewModel = ViewModelProviders.of(this).get(CustomViewModel.class);
        customViewModel.insert(new CustomRoom(UUID.randomUUID().toString(),"bye", String.valueOf(System.currentTimeMillis())));

        String test = networkApi.getContext().getPackageName();
//        test = networkApi.validateUser("kth", "1111");
        activityDetailBinding.title.setText(String.valueOf(test));
        activityDetailBinding.recycler.setAdapter(customAdapter);
        activityDetailBinding.recycler.setLayoutManager(new LinearLayoutManager(this));

        customViewModel.getListLiveData().observe(this, new Observer<PagedList<CustomRoom>>() {
            @Override
            public void onChanged(PagedList<CustomRoom> customRooms) {
                customAdapter.submitList(customRooms);
            }
        });
    }
}
