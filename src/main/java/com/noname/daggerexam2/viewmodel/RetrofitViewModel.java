package com.noname.daggerexam2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.noname.daggerexam2.model.People;
import com.noname.daggerexam2.repository.StarWarsRepo;

public class RetrofitViewModel extends AndroidViewModel {

    private StarWarsRepo starWarsRepo;
    private LiveData<PagedList<People>> listLiveData;

    public RetrofitViewModel(@NonNull Application application) {
        super(application);
        this.starWarsRepo = new StarWarsRepo(application);
    }

    public LiveData<PagedList<People>> getListLiveData() {

        if (listLiveData == null){
            listLiveData = starWarsRepo.getAll();
        }

        return listLiveData;
    }

    public void insert(People People) { starWarsRepo.insert(People); }

    public void delete(People People){starWarsRepo.delete(People);}

}
