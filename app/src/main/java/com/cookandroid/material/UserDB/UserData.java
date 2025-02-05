package com.cookandroid.material.UserDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_user")
public class UserData {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String mName;

    public boolean sOnOff;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id; }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public boolean getsOnOff() {
        return sOnOff;
    }

    public void setsOnOff(boolean sOnOff) {
        this.sOnOff = sOnOff;
    }
}
