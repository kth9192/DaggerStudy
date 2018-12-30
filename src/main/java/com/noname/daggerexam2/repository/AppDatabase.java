package com.noname.daggerexam2.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.noname.daggerexam2.model.People;

@Database(entities = {CustomRoom.class, People.class}, version = 3, exportSchema = false)
@TypeConverters({CustomTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract CustomDao customDao();
    public abstract StarDao starDao();

    private static AppDatabase INSTANCE;

    static AppDatabase getDatabase(Context context){
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "starwars_database")
                            .addMigrations(MIGRATION_2_3)
                            .build();
                }
            }
        }
        return INSTANCE;

    }

//    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL ( "ALTER TABLE CustomRoom " +
//                    "ADD COLUMN tag INTEGER DEFAULT 0 NOT NULL"); //SQL 은 LONG 이 없음
//        }
//    };

    static final Migration MIGRATION_2_3 = new Migration(2, 3){

        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            // Create the new table
            database.execSQL(
                    "CREATE TABLE customroom_new (id TEXT NOT NULL, title TEXT, tag TEXT, PRIMARY KEY(id))");
// Copy the data
            database.execSQL(
                    "INSERT INTO customroom_new (id, title, tag) SELECT id, title, tag FROM CustomRoom");
// Remove the old table
            database.execSQL("DROP TABLE CustomRoom");
// Change the table name to the correct one
            database.execSQL("ALTER TABLE customroom_new RENAME TO CustomRoom");
        }
    };
}
