package com.utad.david.task_3_fragments_lists.DataBaseConection.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Communities;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Lesson;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Notes;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Notifications;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Teacher;

import java.util.List;

@Dao
public interface IUtadDao {
    //Querys de Communities
    @Insert
    void insertAllComunities(List<Communities> clases);

    @Delete
    void deleteComunity(Communities clases);

    @Query("DELETE FROM communities")
    void deleteAllComunities();

    @Query("SELECT * FROM communities")
    LiveData<List<Communities>> getAllComunities();

    //Querys de Notifications
    @Insert
    void insertAllNotifications(List<Notifications> clases);

    @Delete
    void deleteNotification(Notifications clases);

    @Query("DELETE FROM notifications")
    void deleteAllNotifications();

    @Query("SELECT * FROM notifications")
    LiveData<List<Notifications>> getAllNotifications();

    //Querys de Lessons
    @Insert
    void insertAllLessons(List<Lesson> clases);

    @Delete
    void deleteLesson(Lesson clases);

    @Query("DELETE FROM lesson")
    void deleteAllLessons();

    @Query("SELECT * FROM lesson")
    LiveData<List<Lesson>> getAllLessons();

    //Querys de Notes
    @Insert
    void insertAllNotes(List<Notes> clases);

    @Delete
    void deleteNote(Notes clases);

    @Query("DELETE FROM notes")
    void deleteAllNotes();

    @Query("SELECT * FROM notes")
    LiveData<List<Notes>> getAllNotes();

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
