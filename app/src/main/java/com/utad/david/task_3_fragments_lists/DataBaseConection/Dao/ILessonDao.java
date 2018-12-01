package com.utad.david.task_3_fragments_lists.DataBaseConection.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Lesson;

import java.util.List;

@Dao
public interface ILessonDao {
    @Insert
    void insertAllLessons(List<Lesson> clases);

    @Delete
    void deleteLesson(Lesson clases);

    @Query("DELETE FROM lesson")
    void deleteAllLessons();

    @Query("SELECT * FROM lesson")
    LiveData<List<Lesson>> getAllLessons();
}
