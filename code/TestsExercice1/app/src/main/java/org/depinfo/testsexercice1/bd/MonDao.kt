package org.depinfo.testsexercice1.bd

import androidx.room.Dao
import androidx.room.Insert
import org.depinfo.testsexercice1.modele.Personne

@Dao
interface MonDao {
    @Insert
    fun insertPersonne(p: Personne): Long
}
