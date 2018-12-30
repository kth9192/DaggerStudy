package com.noname.daggerexam2.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.noname.daggerexam2.repository.CustomRepo;
import com.noname.daggerexam2.repository.CustomRoom;

public class CustomViewModel extends AndroidViewModel {

    private CustomRepo customRepo;
    private LiveData<PagedList<CustomRoom>> listLiveData;

    public CustomViewModel(@NonNull Application application) {
        super(application);
        this.customRepo = new CustomRepo(application);
    }

    public LiveData<PagedList<CustomRoom>> getListLiveData() {

        if (listLiveData == null){
            listLiveData = customRepo.getAll();
        }

        return listLiveData;
    }

    public void insert(CustomRoom customRoom) { customRepo.insert(customRoom); }

    public void delete(CustomRoom customRoom){customRepo.delete(customRoom);}
}
