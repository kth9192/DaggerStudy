package com.noname.daggerexam2.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.noname.daggerexam2.model.People;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomRepo {

    private CustomDao customDao;

    private LiveData<PagedList<CustomRoom>> listLiveData;
    private DataSource.Factory<Integer, CustomRoom> myDataSource;
    private ExecutorService executorService;

    public CustomRepo(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);

        customDao = db.customDao();

        listLiveData = new LivePagedListBuilder(myDataSource, 20).build();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<PagedList<CustomRoom>> getAll(){
        return listLiveData;
    }

    public void insert(CustomRoom customRoom) {
        executorService.execute(() -> customDao.insert(customRoom));
    }

    public void delete(CustomRoom customRoom){
        executorService.execute(() -> customDao.delete(customRoom));
    }
}
