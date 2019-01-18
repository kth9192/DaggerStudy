package com.noname.daggerexam2;


import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.noname.daggerexam2.daggerpack.Component.ApplicationComponent;
import com.noname.daggerexam2.databinding.ActivityMainBinding;
import com.noname.daggerexam2.logic.NetworkApi;
import com.noname.daggerexam2.repository.CustomRoom;
import com.noname.daggerexam2.retrofit.APIInterface;
import com.noname.daggerexam2.view.CustomAdapter;
import com.noname.daggerexam2.viewmodel.CustomViewModel;
import com.noname.daggerexam2.viewmodel.RetrofitViewModel;
import dagger.android.AndroidInjection;

import android.os.Bundle;


import javax.inject.Inject;
import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding activityMainBinding;
    private CustomViewModel customViewModel;
    private RetrofitViewModel retrofitViewModel;

    @Inject
    NetworkApi networkApi;

    boolean injected = false;

    @Inject
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        customViewModel = ViewModelProviders.of(this).get(CustomViewModel.class);
        retrofitViewModel = ViewModelProviders.of(this).get(RetrofitViewModel.class);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        injected = networkApi.validateUser("kth", "1111");

//        activityMainBinding.target.setText("injected work : " + injected);
        activityMainBinding.target.setText("context work : " + networkApi.getContext().getPackageName());

        activityMainBinding.btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);
        });

//        CustomViewModel.insert(new CustomRoom(UUID.randomUUID().toString(),"hi"));

        customViewModel.insert(new CustomRoom(UUID.randomUUID().toString(),"hi", String.valueOf(System.currentTimeMillis())));

        CustomAdapter customAdapter = new CustomAdapter();
        activityMainBinding.recycler.setAdapter(customAdapter);
        activityMainBinding.recycler.setLayoutManager(new LinearLayoutManager(this));

        customViewModel.getListLiveData().observe(this, new Observer<PagedList<CustomRoom>>() {
            @Override
            public void onChanged(PagedList<CustomRoom> customRooms) {
                customAdapter.submitList(customRooms);
            }
        });

//        apiInterface.getPeople("json").enqueue(new Callback<StarWars>() {
//            @Override
//            public void onResponse(Call<StarWars> call, Response<StarWars> response) {
//                for (People people : response.body().results){
//                    Log.d(TAG , people.name);
//                    retrofitViewModel.insert(people);
//                    StarWarsAdapter starWarsAdapter = new StarWarsAdapter();
//                    activityMainBinding.recycler.setAdapter(starWarsAdapter);
//                    activityMainBinding.recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//
//                    retrofitViewModel.getListLiveData().observe(MainActivity.this, new Observer<PagedList<People>>() {
//                        @Override
//                        public void onChanged(PagedList<People> people) {
//                            starWarsAdapter.submitList(people);
//                        }
//                    });
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<StarWars> call, Throwable t) {
//
//            }
//        });
    }
}
