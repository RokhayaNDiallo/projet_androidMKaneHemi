package methode;
import android.content.Context;
import android.database.sqlite.*;

public class PersonneSQLite extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "personnes.db";
    public static final int    DATABASE_VERSION = 1;
    public static final String TABLE_PERSONNES = "table_personnes";
    public static final String COL_NOM = "NOM";
    public static final String COL_PRENOM = "PRENOM";
    public static final String COL_ADRESSE = "ADRESSE";
    public static final String COL_TELEPHONE = "TELEPHONE";
    public static final String COL_MAIL = "MAIL";
    public static final int    NUM_COL_NOM = 0;
    public static final int    NUM_COL_PRENOM = 1;
    public static final int    NUM_COL_ADRESSE = 2;
    public static final int    NUM_COL_TELEPHONE = 3;
    public static final int    NUM_COL_MAIL = 4;

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_PERSONNES + " ("
            + COL_NOM + " TEXT NOT NULL, "
            + COL_PRENOM + " TEXT NOT NULL, "
            + COL_ADRESSE+ " TEXT NOT NULL,"
            + COL_TELEPHONE + " TEXT NOT NULL,"
            + COL_MAIL + "TEXT NOT NULL);";

    public PersonneSQLite(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // on crée la table
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // au choix : on supprime la table puis on la recrée
        db.execSQL("DROP TABLE " + TABLE_PERSONNES + ";");
        onCreate(db);
    }
}

