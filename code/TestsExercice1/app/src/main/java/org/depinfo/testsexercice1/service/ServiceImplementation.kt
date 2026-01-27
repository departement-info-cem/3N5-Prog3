package org.depinfo.testsexercice1.service

import org.depinfo.testsexercice1.bd.BD
import org.depinfo.testsexercice1.modele.Personne

class ServiceImplementation private constructor(private val maBD: BD) {
    fun ajouterPersonne(personne: Personne) {
        // Ajout
        personne.idPersonne = maBD.monDao()!!.insertPersonne(personne)
    }

    companion object {
        private var single_instance: ServiceImplementation? = null
        fun getInstance(maBD: BD): ServiceImplementation {
            if (single_instance == null) single_instance = ServiceImplementation(maBD)

            return single_instance!!
        }
    }
}
