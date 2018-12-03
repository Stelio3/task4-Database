package com.utad.david.task_3_fragments_lists.DataBaseConection.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Notes;

import java.util.List;

@Dao
public interface INotesDao {
    //Querys de Notes
    @Insert
    void insertAllNotes(List<Notes> clases);

    @Delete
    void deleteNote(Notes clases);

    @Query("DELETE FROM notes")
    void deleteAllNotes();

    @Query("SELECT * FROM notes")
    LiveData<List<Notes>> getAllNotes();
}
