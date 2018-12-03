package com.utad.david.task_3_fragments_lists.DataBaseConection.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "user")
//Modelo para los datos del usuario
public class User {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id_User;

    @ColumnInfo(name = "str_img_user")
    private String str_img_user;

    @ColumnInfo(name = "str_gender")
    private String str_gender;

    @ColumnInfo(name = "str_email")
    private String str_email;

    @ColumnInfo(name = "str_name")
    private String str_name;

    @ColumnInfo(name = "str_surname")
    private String str_surname;

    @ColumnInfo(name = "str_second_surname")
    private String str_second_surname;

    @ColumnInfo(name = "str_city")
    private String str_city;

    @ColumnInfo(name = "str_phone_type")
    private String str_phone_type;

    @ColumnInfo(name = "str_address")
    private String str_address;

    @ColumnInfo(name = "str_phone")
    private String str_phone;

    @ColumnInfo(name = "str_postal_code")
    private String str_postal_code;

    @ColumnInfo(name = "str_description")
    private String str_description;

    @ColumnInfo(name = "str_first_hobbie")
    private String str_first_hobbie;

    @ColumnInfo(name = "str_second_hobbie")
    private String str_second_hobbie;

    @ColumnInfo(name = "str_third_hobbie")
    private String str_third_hobbie;

    @ColumnInfo(name = "int_age")
    private int int_age;

    @NonNull
    public int getId_User() {
        return id_User;
    }

    public void setId_User(@NonNull int id_User) {
        this.id_User = id_User;
    }

    public String getStr_img_user() {
        return str_img_user;
    }

    public void setStr_img_user(String str_img_user) {
        this.str_img_user = str_img_user;
    }

    public String getStr_gender() {
        return str_gender;
    }

    public void setStr_gender(String str_gender) {
        this.str_gender = str_gender;
    }

    public String getStr_email() {
        return str_email;
    }

    public void setStr_email(String str_email) {
        this.str_email = str_email;
    }

    public String getStr_name() {
        return str_name;
    }

    public void setStr_name(String str_name) {
        this.str_name = str_name;
    }

    public String getStr_surname() {
        return str_surname;
    }

    public void setStr_surname(String str_surname) {
        this.str_surname = str_surname;
    }

    public String getStr_second_surname() {
        return str_second_surname;
    }

    public void setStr_second_surname(String str_second_surname) {
        this.str_second_surname = str_second_surname;
    }

    public String getStr_city() {
        return str_city;
    }

    public void setStr_city(String str_city) {
        this.str_city = str_city;
    }

    public String getStr_phone_type() {
        return str_phone_type;
    }

    public void setStr_phone_type(String str_phone_type) {
        this.str_phone_type = str_phone_type;
    }

    public String getStr_address() {
        return str_address;
    }

    public void setStr_address(String str_address) {
        this.str_address = str_address;
    }

    public String getStr_phone() {
        return str_phone;
    }

    public void setStr_phone(String str_phone) {
        this.str_phone = str_phone;
    }

    public String getStr_postal_code() {
        return str_postal_code;
    }

    public void setStr_postal_code(String str_postal_code) {
        this.str_postal_code = str_postal_code;
    }

    public String getStr_description() {
        return str_description;
    }

    public void setStr_description(String str_description) {
        this.str_description = str_description;
    }

    public String getStr_first_hobbie() {
        return str_first_hobbie;
    }

    public void setStr_first_hobbie(String str_first_hobbie) {
        this.str_first_hobbie = str_first_hobbie;
    }

    public String getStr_second_hobbie() {
        return str_second_hobbie;
    }

    public void setStr_second_hobbie(String str_second_hobbie) {
        this.str_second_hobbie = str_second_hobbie;
    }

    public String getStr_third_hobbie() {
        return str_third_hobbie;
    }

    public void setStr_third_hobbie(String str_third_hobbie) {
        this.str_third_hobbie = str_third_hobbie;
    }

    public int getInt_age() {
        return int_age;
    }

    public void setInt_age(int int_age) {
        this.int_age = int_age;
    }
}
