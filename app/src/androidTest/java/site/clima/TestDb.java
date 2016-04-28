package site.clima;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import android.util.Log;

import java.util.HashSet;

import site.clima.data.WeatherContract;
import site.clima.data.WeatherDbHelper;

/**
 * Created by lleon on 4/28/16.
 */
public class TestDb extends AndroidTestCase {

    public static final String LOG_TAG = TestDb.class.getSimpleName();

    public void deleteTheDatabase(){
        mContext.deleteDatabase(WeatherDbHelper.DATABASE_NAME); //WearherDbHelper será quien haga las conexiones
    }

    public void setUp(){
        deleteTheDatabase();
    }

    public void testCreateDb() throws Throwable{

        final HashSet<String> tableNameHashSet = new HashSet<String>();
        tableNameHashSet.add(WeatherContract.LocationEntry.TABLE_NAME);
        tableNameHashSet.add(WeatherContract.WeatherEntry.TABLE_NAME);

        mContext.deleteDatabase(WeatherDbHelper.DATABASE_NAME);

        SQLiteDatabase db = new WeatherDbHelper(
                this.mContext).getWritableDatabase(); // Trata de abrir una conexión con la bd si no existe


        // Debe de ser igual a true : Indica si la db existe y la pudo abrir
        assertEquals("CONEXIÓN COMPLETA",true, db.isOpen());

        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        assertTrue("Error: This means that the database has not been created correctly", c.moveToFirst());

        // Verifica que las tablas han sido creadas

        do{
            tableNameHashSet.remove(c.getString(0));
        }while(c.moveToNext());

        assertTrue("Error: Your database was created without both the location entry and weather entry tables", tableNameHashSet.isEmpty());

        //c = db.rawQuery("PRAGMA table_info(" + WeatherContract.LocationEntry.TABLE_NAME + ")", null);

        //assertTrue("Error: This means that");





    }

}
