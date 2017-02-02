package com.cuyc.pokemonfightguide.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class DbProcess extends SQLiteOpenHelper {

//	public static final String DATABASE_NAME = ".db";
//	public static final int DATABASE_VERSION = 8;

	public DbProcess(Context context, String name, CursorFactory factory,
					 int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
//		Logger.i("Db Create Start.");
		}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
//		onCreate(db);
	}

	public void ExecQuery(String SQL, String[] args) {
		SQLiteDatabase dbIslem = this.getWritableDatabase();
		dbIslem.execSQL(SQL);
		dbIslem.close();
	}

	public Cursor SelectQuery(String SQL, String[] args) {
		SQLiteDatabase dbIslem = this.getReadableDatabase();
		Cursor sonuc = dbIslem.rawQuery(SQL, args);
		return sonuc;
	}

	public long Insert(String table, ContentValues values) {
		long rv = 0;
		try {
			SQLiteDatabase dbIslem = this.getWritableDatabase();
			rv = dbIslem.insert(table, table + "_Id", values);
			dbIslem.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rv;
	}

	public long Update(String table, ContentValues values, String whereClause) {
		long rv = 0;
		try {
			SQLiteDatabase dbIslem = this.getWritableDatabase();
			rv = dbIslem.update(table, values, whereClause, null);
			dbIslem.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rv;
	}

	public long Delete(String table, String whereClause) {
		long rv = 0;
		try {
			SQLiteDatabase dbIslem = this.getWritableDatabase();
			rv = dbIslem.delete(table, whereClause, null);
			dbIslem.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rv;
	}

	public Cursor SelectTable(String fields, String Table, String Where) {
		SQLiteDatabase dbIslem = this.getReadableDatabase();
		if (fields == null)
			fields = "*";
		if (Table == null)
			return null;
		if (Where != null)
			Where = " Where " + Where;
		else
			Where = "";
		Cursor sonuc = dbIslem.rawQuery("Select " + fields + " from " + Table
				+ " " + Where, null);
		return sonuc;
	}
}
