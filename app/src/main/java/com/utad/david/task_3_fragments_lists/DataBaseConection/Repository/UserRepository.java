package com.utad.david.task_3_fragments_lists.DataBaseConection.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.IUserDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.User;

import java.util.List;

//Repository del User
public class UserRepository {
    private IUserDao userDao;
    private LiveData<List<User>> mUser;

    public UserRepository(Application application) {
    }
    public LiveData<List<User>> getAllUsers() {
        return mUser;
    }
}
