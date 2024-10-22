package org.depinfo.testsexercice1

import android.content.Context
import androidx.room.Room.inMemoryDatabaseBuilder
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.depinfo.testsexercice1.bd.BD
import org.depinfo.testsexercice1.modele.Personne
import org.depinfo.testsexercice1.service.ServiceImplementation
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ApplicationTests {
    private var bd: BD? = null
    private var service: ServiceImplementation? = null

    // S'exécute avant chacun des tests. Crée une BD en mémoire
    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        bd = inMemoryDatabaseBuilder(context, BD::class.java).build()
        service = ServiceImplementation.getInstance(bd!!)
    }


    @Test
    fun ajoutPersonneOKBD() {
        val personne = Personne()
        personne.idPersonne = 1L
        personne.nomPersonne = "Maudie"
        personne.agePersonne = 24
        personne.adressePersonne = "1234 De la Mortagne MTL CA"
        bd!!.monDao()!!.insertPersonne(personne)
    }


    @Test
    fun ajoutPersonneKOService() {
        val personne = Personne()
        personne.idPersonne = 2L
        personne.nomPersonne = "Maudie"
        personne.agePersonne = 24
        personne.adressePersonne = "1234 De la Mortagne MTL CA"
        service!!.ajouterPersonne(personne)
    }
}