package com.utad.david.task_3_fragments_lists.DataBaseConection.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.ICommunitiesDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Database.UtadDatabase;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Communities;

import java.util.List;

public class CommunitiesRepository {
    private ICommunitiesDao communitiesDao;
    private LiveData<List<Communities>> mAllCommunities;

    public CommunitiesRepository(Application application) {
        UtadDatabase db = UtadDatabase.getDatabase(application);
        communitiesDao = db.communitiesDao();
        mAllCommunities = communitiesDao.getAllComunities();
    }

    public LiveData<List<Communities>> getAllCommunities() {
        return mAllCommunities;
    }

}
