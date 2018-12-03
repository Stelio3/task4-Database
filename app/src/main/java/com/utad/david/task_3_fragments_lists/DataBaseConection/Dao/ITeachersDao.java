package com.utad.david.task_3_fragments_lists.DataBaseConection.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Teacher;

import java.util.List;

@Dao
public interface ITeachersDao {
    //Querys de Teachers
    @Insert
    void insertAllTeachers(List<Teacher> clases);

    @Delete
    void deleteTeacher(Teacher clases);

    @Query("DELETE FROM teacher")
    void deleteAllTeachers();

    @Query("SELECT * FROM teacher")
    LiveData<List<Teacher>> getAllTeachers();
}
