package org.depinfo.testsexercice1.modele

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Personne {
    @PrimaryKey
    var idPersonne: Long? = null

    var nomPersonne: String? = null

    var agePersonne: Int = 0

    var adressePersonne: String? = null
}
