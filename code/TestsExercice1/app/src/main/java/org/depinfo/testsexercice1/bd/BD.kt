package org.depinfo.testsexercice1.bd

import androidx.room.Database
import androidx.room.RoomDatabase
import org.depinfo.testsexercice1.modele.Personne

@Database(entities = [Personne::class], version = 1)
abstract class BD : RoomDatabase() {
    abstract fun monDao(): MonDao
}
