package com.utad.david.task_3_fragments_lists.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.utad.david.task_3_fragments_lists.Model.Communities;

import java.util.List;

@Dao
public interface IUtadDao {
    @Insert
    void insertAll(List<Communities> clases);

    @Delete
    void delete(Communities clases);

    @Query("DELETE FROM communities")
    void deleteAll();

    @Query("SELECT * FROM communities")
    LiveData<List<Communities>> getAll();
}
