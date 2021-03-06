package com.utad.david.task_3_fragments_lists.DataBaseConection.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.HashMap;

@Entity(tableName = "communities")
//Implementa parcelable para poder pasarle el objeto al Dialog
public class Communities implements Parcelable {

    //Creación de la clave primaria y las demás columnas de la tabla
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id_Communities;

    @ColumnInfo(name = "namecomunities")
    public String namecomunities;

    @ColumnInfo(name = "photocomunities")
    public int photocomunities;

    @ColumnInfo(name = "coordinador")
    public String coordinador;

    @ColumnInfo(name = "tematica")
    public String tematica;

    @ColumnInfo(name = "descripcion")
    public String descripcion;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "datos")
    public HashMap<Integer, String> datos;

    public Communities(String namecomunities, int photocomunities, String coordinador, String tematica, String descripcion, String email, HashMap<Integer, String> datos ) {
        this.namecomunities = namecomunities;
        this.photocomunities = photocomunities;
        this.coordinador = coordinador;
        this.tematica = tematica;
        this.descripcion = descripcion;
        this.email = email;
        this.datos = datos;
    }

    protected Communities(Parcel in) {
        namecomunities = in.readString();
        photocomunities = in.readInt();
        coordinador = in.readString();
        tematica = in.readString();
        descripcion = in.readString();
        email = in.readString();
        datos = (HashMap<Integer, String>) in.readSerializable();
    }

    public static final Creator<Communities> CREATOR = new Creator<Communities>() {
        @Override
        public Communities createFromParcel(Parcel in) {
            return new Communities(in);
        }

        @Override
        public Communities[] newArray(int size) {
            return new Communities[size];
        }
    };


    public String getNamecomunities() {
        return namecomunities;
    }

    public void setNamecomunities(String namecomunities) {
        this.namecomunities = namecomunities;
    }

    public int getPhotocomunities() {
        return photocomunities;
    }

    public void setPhotocomunities(int photocomunities) {
        this.photocomunities = photocomunities;
    }

    public String getCoordinador(){return coordinador;}

    public void setCoordinador(String coordinador){this.coordinador = coordinador;}

    public String getTematica(){return tematica;}

    public void setTematica(String tematica) { this.tematica = tematica; }

    public HashMap<Integer, String> getDatos() { return datos; }

    public void setDatos(HashMap<Integer, String> datos) { this.datos = datos; }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(namecomunities);
        dest.writeInt(photocomunities);
        dest.writeString(coordinador);
        dest.writeString(tematica);
        dest.writeString(descripcion);
        dest.writeString(email);
        dest.writeSerializable(datos);
    }
}
