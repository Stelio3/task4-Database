package com.utad.david.task_3_fragments_lists.DataBaseConection.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Communities;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.User;

import java.util.List;

@Dao
public interface IUserDao {
    //Querys de Communities
    @Insert
    void insertAllUsers(List<User> clases);

    @Delete
    void deleteUser(User clases);

    @Query("DELETE FROM user")
    void deleteAllUsers();

    @Query("SELECT * FROM user")
    LiveData<List<User>> getAllUsers();
}
