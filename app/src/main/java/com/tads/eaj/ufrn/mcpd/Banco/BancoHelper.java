package com.tads.eaj.ufrn.mcpd.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import com.tads.eaj.ufrn.mcpd.Builder.Cultura;
import com.tads.eaj.ufrn.mcpd.Strategy.Praga;
import com.tads.eaj.ufrn.mcpd.model.Registro;
import com.tads.eaj.ufrn.mcpd.model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joffr on 17/10/2017.
 */

public class BancoHelper extends SQLiteOpenHelper {

    //String auxiliares
    private static final String TAG = "sql";
    private static final String TEXT_TYPE = " TEXT";
    private static final String NUMBER_TYPE = " INTEGER";
    private static final String DOUBLE_TYPE = " DOUBLE";
    private static final String DATE_TYPE = " DATE";
    private static final String VIRGULA = ",";

    private static final String DATABASE_NAME = "bancoRegistro.sqlite";

    //versão do banco
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_REGISTRO = (
            "CREATE TABLE " + RegistroEntry.TABLE_NAME +
                    "(" +
                    RegistroEntry._ID + NUMBER_TYPE + " PRIMARY KEY " + VIRGULA +
                    RegistroEntry.DATA_REGISTRO + TEXT_TYPE + VIRGULA +
                    RegistroEntry.LATITUDE + DOUBLE_TYPE + VIRGULA +
                    RegistroEntry.LONGITUDE + DOUBLE_TYPE + VIRGULA +
                    RegistroEntry.ESCALA + NUMBER_TYPE + VIRGULA +
                    RegistroEntry.TRAMTAMENTO + TEXT_TYPE + VIRGULA +
                    RegistroEntry.DATATRATAMENTO + TEXT_TYPE + VIRGULA +
                    RegistroEntry.TIPO + TEXT_TYPE + VIRGULA +
                    RegistroEntry.OBS + TEXT_TYPE + VIRGULA +
                    RegistroEntry.USUARIO + NUMBER_TYPE + VIRGULA +
                    RegistroEntry.CULTURA + NUMBER_TYPE + VIRGULA +
                    RegistroEntry.PRAGA + NUMBER_TYPE +
                    ");"
    );

    private static final String SQL_CREATE_TABLE_USUARIO = (
            "CREATE TABLE " + UsuarioEntry.TABLE_NAME + " (" +
                    UsuarioEntry._ID + NUMBER_TYPE + " PRIMARY KEY " + VIRGULA +
                    UsuarioEntry.NOME + TEXT_TYPE + VIRGULA + UsuarioEntry.CPF + TEXT_TYPE + ");"
    );

    private static final String SQL_CREATE_TABLE_CULTURA = ("CREATE TABLE " + CulturaEntry.TABLE_NAME + " (" +
            CulturaEntry._ID + NUMBER_TYPE + " PRIMARY KEY " + VIRGULA +
            CulturaEntry.NOME + TEXT_TYPE + VIRGULA + CulturaEntry.DESCRICAO + TEXT_TYPE + ");");

    private static final String SQL_CREATE_TABLE_PRAGA = ("CREATE TABLE " + PragaEntry.TABLE_NAME + " (" +
            PragaEntry._ID + NUMBER_TYPE + " PRIMARY KEY " + VIRGULA +
            PragaEntry.NOME + TEXT_TYPE + VIRGULA + PragaEntry.ESCALA1 + TEXT_TYPE + VIRGULA +
            PragaEntry.ESCALA2 + TEXT_TYPE + VIRGULA + PragaEntry.ESCALA3 + TEXT_TYPE + VIRGULA +
            PragaEntry.ESCALA4 + TEXT_TYPE + VIRGULA + PragaEntry.ESCALA5 + TEXT_TYPE + VIRGULA +
            PragaEntry.IDCULTURA + NUMBER_TYPE + ");");

    private static final String SQL_CREATE_TABELA_PROPRIEDADE = ("CREATE TABLE " + PropriedadeEntry.TABLE_NAME + " ("+
            PropriedadeEntry._ID + NUMBER_TYPE + " PRIMARY KEY " + VIRGULA + PropriedadeEntry.NOME + TEXT_TYPE + VIRGULA+
            PropriedadeEntry.LOCALIDADE + TEXT_TYPE + VIRGULA + PropriedadeEntry.CIDADE + TEXT_TYPE + VIRGULA +
            PropriedadeEntry.PAIS + TEXT_TYPE + ");");

    private static final String SQL_DROP_TABLE =
            ("DROP TABLE Usuario Cultura Praga Registro ;");

    public BancoHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //TODO: TERMINAR O REGISTRO DE PROPRIEDADE ;]...

    //CRIA TABELAS REGISTRO, USUARIo
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_REGISTRO);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_USUARIO);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_CULTURA);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_PRAGA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Caso mude a versãoo do banco de dados, podemos executar um SQL aqui
        if (oldVersion != newVersion) {
            // Execute o script para atualizar a versão...
            Log.d(TAG, "Foi detectada uma nova versão do banco, aqui deverão ser executados os scripts de update.");
            db.execSQL(SQL_DROP_TABLE);
            this.onCreate(db);
        }
    }
    public void deleteDataBase(SQLiteDatabase db){
        db.execSQL("DROP TABLE Usuario;" );
        db.execSQL("DROP TABLE Registro;" );
        db.execSQL("DROP TABLE Cultura;" );
        db.execSQL("DROP TABLE Praga;" );
    }


    //---------------delets----------------

    public int deleteCultura(Cultura cultura) {
 /*       SQLiteDatabase db = getWritableDatabase();
        try {
            // delete from carro where _id=?
            String selection = CulturaEntry._ID + "= ?";
           // String[] whereArgs = new String[] {String.valueOf(cultura.getId())};
            int count = db.delete(CulturaEntry.TABLE_NAME, selection,whereArgs);
            Log.i(TAG, "Deletou " + count + " registro.");
            return count;
        } finally {
            db.close();
        }*/
      return 3;
    }
    public int deletePraga(Praga praga) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            // delete from carro where _id=?
            String selection = PragaEntry._ID + "= ?";
            String[] whereArgs = new String[] {String.valueOf(praga.getId())};
            int count = db.delete(PragaEntry.TABLE_NAME, selection,whereArgs);
            Log.i(TAG, "Deletou " + count + " registro.");
            return count;
        } finally {
            db.close();
        }
    }
    public int deleteUsuario(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            // delete from carro where _id=?
            String selection = UsuarioEntry._ID + "= ?";
            String[] whereArgs = new String[] {String.valueOf(usuario.getId())};
            int count = db.delete(UsuarioEntry.TABLE_NAME, selection,whereArgs);
            Log.i(TAG, "Deletou " + count + " registro.");
            return count;
        } finally {
            db.close();
        }
    }
    public int deleteRegistro(Registro registro) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            // delete from carro where _id=?
            String selection = RegistroEntry._ID + "= ?";
            String[] whereArgs = new String[] {String.valueOf(registro.getId())};
            int count = db.delete(RegistroEntry.TABLE_NAME, selection,whereArgs);
            Log.i(TAG, "Deletou " + count + " registro.");
            return count;
        } finally {
            db.close();
        }
    }
//==================================================================================================
    //SALVA REGISTRO, USUARIO, CULTURA, PRAGA...
//==================================================================================================

    public long saveRegistro(Registro reg) {
        long id = reg.getId();
        SQLiteDatabase db = getWritableDatabase();
        ContentValues val = new ContentValues();
        try {

            val.put(RegistroEntry.DATA_REGISTRO, reg.getDataRegistro());
            val.put(RegistroEntry.LATITUDE, reg.getLatitude());
            val.put(RegistroEntry.LONGITUDE, reg.getLongitude());
            val.put(RegistroEntry.ESCALA, reg.getEscala());
            val.put(RegistroEntry.TRAMTAMENTO, reg.isTratamento());
            val.put(RegistroEntry.DATATRATAMENTO, reg.getDataTratamento());
            val.put(RegistroEntry.TIPO, reg.getTipo());
            val.put(RegistroEntry.OBS, reg.getObs());
            val.put(RegistroEntry.USUARIO, reg.getUsuarioId());
            val.put(RegistroEntry.CULTURA, reg.getCulturaId());
            val.put(RegistroEntry.PRAGA, reg.getPragaId());

            if (id != 0) {
                String selection = RegistroEntry._ID + "= ?";
                String[] whereArgs = new String[]{String.valueOf(id)};

                //update registro set values = ... where _id=?
                int count = db.update(RegistroEntry.TABLE_NAME, val, selection, whereArgs);

                return count;
            } else {
                //inset into registors values (...)
                id = db.insert(RegistroEntry.TABLE_NAME, null, val);

                return id;
            }
        } finally {
            db.close();
        }
    }

    public long saveUsuario(Usuario u) {
        long id = u.getId();
        SQLiteDatabase db = getWritableDatabase();
        ContentValues val = new ContentValues();
        try {
            val.put(UsuarioEntry.NOME, u.getNomeUsuario());
            val.put(UsuarioEntry.CPF, u.getCpf());

            if (id != 0) {
                String selection = UsuarioEntry._ID + "= ?";
                String[] whereArgs = new String[]{String.valueOf(id)};

                int count = db.update(UsuarioEntry.TABLE_NAME, val, selection, whereArgs);

                return count;
            } else {
                id = db.insert(UsuarioEntry.TABLE_NAME, null, val);
                return id;
            }
        } finally {
            db.close();
        }
    }

    public long saveCultura(Cultura c) {
        //long id = c.getId();
        SQLiteDatabase db = getWritableDatabase();
        ContentValues val = new ContentValues();

        long d = 3;
        return d;
    }

    public long savePraga(Praga p) {
       /* long id = p.getId();
        SQLiteDatabase db = getWritableDatabase();
        ContentValues val = new ContentValues();
        try {
            val.put(PragaEntry.NOME, p.getNome());
            val.put(PragaEntry.ESCALA1, p.getEscala1());
            val.put(PragaEntry.ESCALA2, p.getEscala2());
            val.put(PragaEntry.ESCALA3, p.getEscala3());
            val.put(PragaEntry.ESCALA4, p.getEscala4());
            val.put(PragaEntry.ESCALA5, p.getEscala5());
            val.put(PragaEntry.IDCULTURA, p.getIdCultura());

            if (id != 0){
                String selection = PragaEntry._ID + "= ?";
                String[] whereArgs = new String[]{String.valueOf(id)};

                int count = db.update(PragaEntry.TABLE_NAME, val, selection, whereArgs);

                return count;
            } else {
                id = db.insert(PragaEntry.TABLE_NAME, null, val);
                return id;
            }
        } finally {
            db.close();
        }*/
       return new Long(2);
    }
//==================================================================================================
    // Retornar uma lista de todos os registros, usuarios, cultura, praga
//==================================================================================================

    public List<Registro> findAllRegistros() {
        SQLiteDatabase db = getReadableDatabase();
        try {
            Cursor c = db.query(RegistroEntry.TABLE_NAME, null, null, null, null, null, null, null);
            return toListRegistro(c);
        } finally {
            db.close();
        }
    }

    private List<Registro> toListRegistro(Cursor c) {
        List<Registro> res = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                Registro registro = new Registro();
                res.add(registro);

                //recupera os atributos
                registro.setId(c.getLong(c.getColumnIndex(RegistroEntry._ID)));
                registro.setCulturaId(c.getInt(c.getColumnIndex(RegistroEntry.CULTURA)));
                registro.setDataRegistro(c.getString(c.getColumnIndex(RegistroEntry.DATA_REGISTRO)));
                registro.setDataTratamento(c.getString(c.getColumnIndex(RegistroEntry.DATATRATAMENTO)));
                registro.setEscala(c.getInt(c.getColumnIndex(RegistroEntry.ESCALA)));
                registro.setLatitude(c.getDouble(c.getColumnIndex(RegistroEntry.LATITUDE)));
                registro.setLongitude(c.getDouble(c.getColumnIndex(RegistroEntry.LONGITUDE)));
                registro.setObs(c.getString(c.getColumnIndex(RegistroEntry.OBS)));
                registro.setPragaId(c.getInt(c.getColumnIndex(RegistroEntry.PRAGA)));
                registro.setTipo(c.getString(c.getColumnIndex(RegistroEntry.TIPO)));
                registro.setTratamento(c.getColumnIndex(RegistroEntry.TRAMTAMENTO) != 0 /*? true : false*/);//nao sei se funciona, testem
                //o banco salvou tratamento como integer, e o objeto registro tem tratamento como booleano, esse codigo esta "traduzindo o que foi salvo"
                registro.setUsuarioId(c.getInt(c.getColumnIndex(RegistroEntry.USUARIO)));

            } while (c.moveToNext());
        }
        return res;
    }

    public List<Usuario> findAllUsuarios() {
        SQLiteDatabase db = getReadableDatabase();
        try {
            Cursor c = db.query(RegistroEntry.TABLE_NAME, null, null, null, null, null, null, null);
            return toListUsuario(c);
        } finally {
            db.close();
        }
    }

    private List<Usuario> toListUsuario(Cursor c) {
        List<Usuario> users = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                Usuario user = new Usuario();
                users.add(user);

                //recupera os atributos
                user.setNomeUsuario(c.getString(c.getColumnIndex(UsuarioEntry.NOME)));
                user.setCpf(c.getString(c.getColumnIndex(UsuarioEntry.CPF)));

            } while (c.moveToNext());
        }
        return users;
    }

    public List<Cultura> findAllCulturas() {
        SQLiteDatabase db = getReadableDatabase();
        try {
            Cursor c = db.query(CulturaEntry.TABLE_NAME, null, null, null, null, null, null, null);
            return toListCultura(c);
        } finally {
            db.close();
        }
    }

    private List<Cultura> toListCultura(Cursor c) {
        List<Cultura> culturas = new ArrayList<>();
       /* if (c.moveToFirst()) {
            do {
                Cultura cultura = new Cultura();
                culturas.add(cultura);

                //recupera os atributos
                cultura.setNome(c.getString(c.getColumnIndex(CulturaEntry.NOME)));
                cultura.setDescricao(c.getString(c.getColumnIndex(CulturaEntry.DESCRICAO)));

            } while (c.moveToNext());
        }*/
        return culturas;
    }

    public List<Praga> findAllPragas() {
        SQLiteDatabase db = getReadableDatabase();
        try {
            Cursor c = db.query(PragaEntry.TABLE_NAME, null, null, null, null, null, null, null);
            return toListPraga(c);
        } finally {
            db.close();
        }
    }

    private List<Praga> toListPraga(Cursor c) {
        List<Praga> pragas = new ArrayList<>();
        if (c.moveToFirst()) {
          /*  do {
                Praga praga = new Praga();
                pragas.add(praga);

                //recupera os atributos
                praga.setNome(c.getString(c.getColumnIndex(PragaEntry.NOME)));
                praga.setEscala1(c.getString(c.getColumnIndex(PragaEntry.ESCALA1)));
                praga.setEscala2(c.getString(c.getColumnIndex(PragaEntry.ESCALA2)));
                praga.setEscala3(c.getString(c.getColumnIndex(PragaEntry.ESCALA3)));
                praga.setEscala4(c.getString(c.getColumnIndex(PragaEntry.ESCALA4)));
                praga.setEscala5(c.getString(c.getColumnIndex(PragaEntry.ESCALA5)));
                praga.setIdCultura(c.getInt(c.getColumnIndex(PragaEntry.IDCULTURA)));

            } while (c.moveToNext());*/
        }
        return pragas;
    }
//==================================================================================================
    //ATUALIZA PELA ID UM REGISTRO
//==================================================================================================

    public void atualizaRegistro(Registro reg) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues val = new ContentValues();
            val.put(RegistroEntry.CULTURA, reg.getCulturaId());
            val.put(RegistroEntry.DATA_REGISTRO, reg.getDataRegistro());
            val.put(RegistroEntry.DATATRATAMENTO, reg.getDataTratamento());
            val.put(RegistroEntry.ESCALA, reg.getEscala());
            val.put(RegistroEntry.LATITUDE, reg.getLatitude());
            val.put(RegistroEntry.LONGITUDE, reg.getLongitude());
            val.put(RegistroEntry.OBS, reg.getObs());
            val.put(RegistroEntry.PRAGA, reg.getPragaId());
            val.put(RegistroEntry.TIPO, reg.getTipo());
            val.put(RegistroEntry.TRAMTAMENTO, reg.isTratamento());
            val.put(RegistroEntry.USUARIO, reg.getUsuarioId());


            String selection = RegistroEntry._ID + "= ?";
            String[] whereArgs = new String[]{String.valueOf(reg.getId())};

            // update registro set values = ... where _id=?
            db.update(RegistroEntry.TABLE_NAME, val, selection, whereArgs);
        } finally {
            db.close();
        }
    }

    //executa uma sql
    public List<Praga> execSQL(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.execSQL(sql);
        } finally {
            db.close();
        }
        return null;
    }

    //executa um sql
    public void execSQL(String sql, Object[] args) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.execSQL(sql, args);
        } finally {
            db.close();
        }

    }


    public static class RegistroEntry implements BaseColumns {
        public static final String TABLE_NAME = "Registro";
        public static final String DATA_REGISTRO = "dataRegistro";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";
        public static final String ESCALA = "escala";
        public static final String TRAMTAMENTO = "tratamento";
        public static final String DATATRATAMENTO = "dataTratamento";
        public static final String TIPO = "tipo";
        public static final String OBS = "obs";
        public static final String USUARIO = "usuario";
        public static final String CULTURA = "cultura";
        public static final String PRAGA = "praga";

    }

    public static class UsuarioEntry implements BaseColumns {
        public static final String TABLE_NAME = "Usuario";
        public static final String NOME = "nomeUsuario";
        public static final String CPF = "cpf";
    }

    public static class CulturaEntry implements BaseColumns {
        public static final String TABLE_NAME = "Cultura";
        public static final String NOME = "nomeCultura";
        public static final String DESCRICAO = "descricao";
    }

    public static class PragaEntry implements BaseColumns {
        public static final String TABLE_NAME = "Praga";
        public static final String NOME = "nomePraga";
        public static final String ESCALA1 = "escala1";
        public static final String ESCALA2 = "escala2";
        public static final String ESCALA3 = "escala3";
        public static final String ESCALA4 = "escala4";
        public static final String ESCALA5 = "escala5";
        public static final String IDCULTURA = "idCultura";
    }

    public static class PropriedadeEntry implements BaseColumns{
        public static final String TABLE_NAME = "Propriedade";
        public static final String NOME = "nomePropriedade";
        public static final String LOCALIDADE = "localidade";
        public static final String CIDADE = "cidade";
        public static final String PAIS = "pais";
    }
}
