package com.utad.david.task_3_fragments_lists.DataBaseConection.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "notifications")
public class Notifications {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idNotifications")
    private int idNotifications;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "userName")
    private String userName;
    @ColumnInfo(name = "title")
    private String title;

    public Notifications(String date, String userName, String title) {
        this.date = date;
        this.userName = userName;
        this.title = title;
    }

    @NonNull
    public int getIdNotifications() {
        return idNotifications;
    }

    public void setIdNotifications(@NonNull int idNotifications) {
        this.idNotifications = idNotifications;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
