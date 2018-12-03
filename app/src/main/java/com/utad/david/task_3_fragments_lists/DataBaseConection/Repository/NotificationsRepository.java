package com.utad.david.task_3_fragments_lists.DataBaseConection.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.ICommunitiesDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.ILessonsDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.INotesDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.INotificationsDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.ITeachersDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Database.UtadDatabase;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Communities;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Lesson;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Notes;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Notifications;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Teacher;

import java.util.List;

//Repository que comparten las diferentes secciones
public class NotificationsRepository {
    private INotificationsDao notificationsDao;
    private LiveData<List<Notifications>> mAllNotifications;


    //Constructor que llama al método que tiene la query de Select *
    public NotificationsRepository(Application application) {
        UtadDatabase db = UtadDatabase.getDatabase(application);
        notificationsDao = db.notificationsDao();
        mAllNotifications = notificationsDao.getAllNotifications();
    }

    public LiveData<List<Notifications>> getAllNotifications() {
        return mAllNotifications;
    }
}
