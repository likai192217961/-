package com.example.likai20181203zk1.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SqlDao {
    private Context context;
    private final SQLiteDatabase db;

    public SqlDao(Context context) {
        this.context = context;
        Sqlite sqlite=new Sqlite(context);
        db = sqlite.getWritableDatabase();
    }
    public long insert(String table, String nullColumnHack, ContentValues values){
        return db.insert(table,nullColumnHack,values);
    }
    public long delete(String table, String whereClause, String[] whereArgs){
        return db.delete(table,whereClause,whereArgs);
    }
}
