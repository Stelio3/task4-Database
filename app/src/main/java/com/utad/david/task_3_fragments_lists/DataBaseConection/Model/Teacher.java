package com.utad.david.task_3_fragments_lists.DataBaseConection.Model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.HashMap;

@Entity(tableName = "teacher")
//Implementa parcelable para poder pasarle el objeto al Dialog
public class Teacher implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id_teachers;
    @ColumnInfo(name = "nameteacher")
    private String nameteacher;
    @ColumnInfo(name = "surnameteacher")
    private String surnameteacher;
    @ColumnInfo(name = "phototeacher")
    private int phototeacher;
    @ColumnInfo(name = "subject")
    private HashMap<Integer, String> subject;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "emailteacher")
    private String emailteacher;

    public Teacher(String nameteacher, String surnameteacher, int phototeacher, HashMap<Integer, String> subject,String description,String emailteacher) {
        this.nameteacher = nameteacher;
        this.surnameteacher = surnameteacher;
        this.phototeacher = phototeacher;
        this.subject = subject;
        this.description = description;
        this.emailteacher = emailteacher;
    }


    protected Teacher(Parcel in) {
        id_teachers = in.readInt();
        nameteacher = in.readString();
        surnameteacher = in.readString();
        phototeacher = in.readInt();
        subject = (HashMap<Integer, String>) in.readSerializable();
        description = in.readString();
    }

    public static final Creator<Teacher> CREATOR = new Creator<Teacher>() {
        @Override
        public Teacher createFromParcel(Parcel in) {
            return new Teacher(in);
        }

        @Override
        public Teacher[] newArray(int size) {
            return new Teacher[size];
        }
    };
    public int getidTeacher() {
        return id_teachers;
    }

    public void setidTeacher(int id_teachers) {
        this.id_teachers = id_teachers;
    }

    public String getNameteacher() {
        return nameteacher;
    }

    public void setNameteacher(String nameteacher) {
        this.nameteacher = nameteacher;
    }

    public int getPhototeacher() {
        return phototeacher;
    }

    public void setPhototeacher(int phototeacher) {
        this.phototeacher = phototeacher;
    }

    public String getSurnameteacher() {
        return surnameteacher;
    }

    public void setSurnameteacher(String surnameteacher) {
        this.surnameteacher = surnameteacher;
    }

    public HashMap<Integer, String> getSubject() {
        return subject;
    }

    public void setSubject(HashMap<Integer, String> subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmailteacher() {
        return emailteacher;
    }

    public void setEmailteacher(String emailteacher) {
        this.emailteacher = emailteacher;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_teachers);
        dest.writeString(nameteacher);
        dest.writeString(surnameteacher);
        dest.writeInt(phototeacher);
        dest.writeSerializable(subject);
        dest.writeString(description);
        dest.writeString(emailteacher);
    }
}