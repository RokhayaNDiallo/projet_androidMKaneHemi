package methode;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class PersonneBDD {

        private SQLiteDatabase bdd = null;
        private PersonneSQLite PersonneSQLite = null;

    public PersonneBDD(Context context)
        {
            // cn crée la BDD et sa table
            PersonneSQLite = new PersonneSQLite(context);
        }

        public void open()
        {
            // on ouvre la BDD en écriture
            if (bdd == null)
                bdd = PersonneSQLite.getWritableDatabase();
        }

        public void close()
        {
            if (bdd != null)
                if (bdd.isOpen())
                    bdd.close();
        }

        public SQLiteDatabase getBDD()
        {
            return bdd;
        }

        public long insererPersonne(personne personne)
        {
            ContentValues values = new ContentValues();

            values.put(PersonneSQLite.COL_NOM, personne.getNom());
            values.put(PersonneSQLite.COL_PRENOM, personne.getPrenom());
            values.put(PersonneSQLite.COL_ADRESSE, personne.getAdresse());
            values.put(PersonneSQLite.COL_TELEPHONE, personne.getTelephone());
            values.put(PersonneSQLite.COL_MAIL, personne.getMail());

            return bdd.insert(PersonneSQLite.TABLE_PERSONNES, null, values);
        }

        public int modifierPersonne(int id, personne personne)
        {
            ContentValues values = new ContentValues();
            values.put(PersonneSQLite.COL_NOM, personne.getNom());
            values.put(PersonneSQLite.COL_PRENOM, personne.getPrenom());
            values.put(PersonneSQLite.COL_ADRESSE, personne.getAdresse());
            values.put(PersonneSQLite.COL_TELEPHONE, personne.getTelephone());
            values.put(PersonneSQLite.COL_MAIL, personne.getMail());

            return bdd.update(PersonneSQLite.TABLE_PERSONNES, values, PersonneSQLite.COL_NOM + " = " + id, null);
        }

        public int supprimerPersonne(int id)
        {
            return bdd.delete(PersonneSQLite.TABLE_PERSONNES, PersonneSQLite.COL_NOM + " = " + id, null);
        }

    public personne getPersonne(String nom)
    {
        Cursor c = bdd.query(PersonneSQLite.TABLE_PERSONNES, new String[] {PersonneSQLite.COL_NOM, PersonneSQLite.COL_PRENOM, PersonneSQLite.COL_ADRESSE, PersonneSQLite.COL_TELEPHONE,PersonneSQLite.COL_MAIL}, PersonneSQLite.COL_NOM + " LIKE \"" + nom +"\"", null, null, null, null);

        return cursorTopersonne(c, true);
    }

    public personne getPersonneByAdresse(String adresse)
    {
        Cursor c = bdd.rawQuery("SELECT * FROM" + PersonneSQLite.TABLE_PERSONNES + " WHERE " + PersonneSQLite.COL_ADRESSE + " = ?", new String[] { adresse});

        return cursorTopersonne(c, true);
    }

    public List<personne> getPersonne()
    {
        List<personne> personnes = new ArrayList<personne>();

        Cursor cursor = bdd.query(PersonneSQLite.TABLE_PERSONNES, new String[] {PersonneSQLite.COL_NOM, PersonneSQLite.COL_PRENOM, PersonneSQLite.COL_ADRESSE, PersonneSQLite.COL_TELEPHONE,PersonneSQLite.COL_MAIL}, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            personne personne = cursorTopersonne(cursor, false);
            personnes.add(personne);
            cursor.moveToNext();
        }

        cursor.close();

        return personnes;
    }

    // Cette méthode permet de convertir un cursor en un objet de type Serveur
    private personne cursorTopersonne(Cursor c, boolean one)
    {
        if (c.getCount() == 0)
            return null;

        if(one == true)
            c.moveToFirst();

        personne personne = new personne();

        personne.setNom(c.getString(PersonneSQLite.NUM_COL_NOM));
        personne.setPrenom(c.getString(PersonneSQLite.NUM_COL_PRENOM));
        personne.setAdresse(c.getString(PersonneSQLite.NUM_COL_ADRESSE));
        personne.setTelephone(c.getString(PersonneSQLite.NUM_COL_TELEPHONE));
        personne.setMail(c.getString(PersonneSQLite.NUM_COL_MAIL));

        if(one == true)
            c.close();

        return personne;
    }
}
