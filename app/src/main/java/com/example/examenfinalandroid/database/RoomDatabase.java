package com.example.examenfinalandroid.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import com.example.examenfinalandroid.model.Empleado;

@Database(entities = {Empleado.class},version = 1)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {
    private static String DATABASE_NAME="database";

    public abstract EmpleadoDao empleadoDao();
    private static volatile RoomDatabase INSTANCE;


    public synchronized static RoomDatabase getInstance(final Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}