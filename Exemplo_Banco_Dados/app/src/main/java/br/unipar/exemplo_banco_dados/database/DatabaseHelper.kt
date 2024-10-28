package br.unipar.exemplo_banco_dados.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import br.unipar.exemplo_banco_dados.entidade.Item

class DatabaseHelper(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME){

    companion object {
        private const val DATABASE_NAME = "COMPRAS_UNIPAR.db"
        private const val VERSION_DATABASE = 1
        private const val TABLE_NAME  = "items"

        private const val COLUMN_ID = "id"
        private const val COLUMN_DESCRIPTION = "description"
        private const val COLUMN_QUANTITY = "quantity"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE ${TABLE_NAME} (" +
                            "${COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "${COLUMN_DESCRIPTION} TEXT," +
                            "${COLUMN_QUANTITY} INTEGER )")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS items")
        onCreate(db)
    }

    fun saveItem(description: String, quantity: Int){
        val db = this.writableDatabase

        val values = ContentValues().apply {
            put(COLUMN_DESCRIPTION, description)
            put(COLUMN_QUANTITY, quantity)
        }

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getListItems(): List<Item> {

        val itemList = mutableListOf<Item>()
        val querySelect = "SELECT * FROM ${TABLE_NAME}"
        val db = readableDatabase

        val cursor = db.rawQuery(querySelect, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
                val description = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION))
                val quantity = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_QUANTITY))

                val item = Item(id, description, quantity)
                itemList.add(item)

            } while (cursor.moveToNext())

            cursor.close()
            db.close()
            return itemList
        }

    }



}
