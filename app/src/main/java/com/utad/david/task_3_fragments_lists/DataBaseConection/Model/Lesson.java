package com.utad.david.task_3_fragments_lists.DataBaseConection.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.HashMap;

@Entity(tableName = "lesson")
//Implementa parcelable para poder pasarle el objeto al Dialog
public class Lesson implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id_lessons;
    @ColumnInfo(name = "name")
    private String nameclass;
    @ColumnInfo(name = "img")
    private int photoclass;
    @ColumnInfo(name = "descripcion")
    private String descripcion;
    @ColumnInfo(name = "curseYear")
    private String courseYear;
    @ColumnInfo(name = "estadistic")
    private HashMap<Integer, String> estadisticas;

    public Lesson(String nameclass, int photoclass, String descripcion, String courseYear, HashMap<Integer, String> estadisticas) {
        this.nameclass = nameclass;
        this.photoclass = photoclass;
        this.courseYear = courseYear;
        this.descripcion = descripcion;
        this.estadisticas = estadisticas;
    }

    public Lesson(Parcel in) {
        id_lessons = in.readInt();
        nameclass = in.readString();
        photoclass = in.readInt();
        courseYear = in.readString();
        descripcion = in.readString();
        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            String value = in.readString();
            estadisticas.put(i, value);
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_lessons);
        dest.writeString(nameclass);
        dest.writeInt(photoclass);
        dest.writeString(courseYear);
        dest.writeSerializable(estadisticas);
        dest.writeString(descripcion);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Lesson> CREATOR = new Creator<Lesson>() {
        @Override
        public Lesson createFromParcel(Parcel in) {
            return new Lesson(in);
        }

        @Override
        public Lesson[] newArray(int size) {
            return new Lesson[size];
        }
    };

    @NonNull
    public int getId() {
        return id_lessons;
    }

    public void setId(@NonNull int id) {
        this.id_lessons = id;
    }

    public String getNameclass() {
        return nameclass;
    }

    public void setNameclass(String nameclass) {
        this.nameclass = nameclass;
    }

    public int getPhotoclass() {
        return photoclass;
    }

    public void setPhotoclass(int photoclass) {
        this.photoclass = photoclass;
    }

    public String getCourseYear() { return courseYear; }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public String getDescripcion() { return  descripcion; }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public HashMap<Integer, String> getEstadisticas() { return estadisticas; }
}
