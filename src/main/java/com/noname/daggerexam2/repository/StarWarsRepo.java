package com.noname.daggerexam2.repository;

import android.app.Application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.noname.daggerexam2.model.People;

public class StarWarsRepo {

    private StarDao starDao;
    private LiveData<PagedList<People>> listLiveData;
    private DataSource.Factory<Integer, People> myDataSource;
    private ExecutorService executorService;

    public StarWarsRepo(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);

        starDao = db.starDao();
        myDataSource = starDao.getAll();

        listLiveData = new LivePagedListBuilder(myDataSource, 20).build();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<PagedList<People>> getAll(){
        return listLiveData;
    }

    public void insert(People people) {
        executorService.execute(() -> starDao.insert(people));
    }

    public void delete(People people){
        executorService.execute(() -> starDao.delete(people));
    }
}
