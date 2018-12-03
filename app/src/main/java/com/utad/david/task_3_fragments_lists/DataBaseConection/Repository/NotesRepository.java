package com.utad.david.task_3_fragments_lists.DataBaseConection.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.INotesDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Database.UtadDatabase;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Notes;

import java.util.List;

public class NotesRepository {
    private INotesDao notesDao;
    private LiveData<List<Notes>> mAllNotes;

    public NotesRepository(Application application) {
        UtadDatabase db = UtadDatabase.getDatabase(application);
        notesDao = db.notesDao();
        mAllNotes = notesDao.getAllNotes();
    }

    public LiveData<List<Notes>> getAllNotes() {
        return mAllNotes;
    }
}
