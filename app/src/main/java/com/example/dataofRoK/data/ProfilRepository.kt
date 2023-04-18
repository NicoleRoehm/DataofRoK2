package com.example.dataofRoK.data

import com.example.dataofRoK.data.model.Profil

class ProfilRepository {


    fun loadProfil() :List<Profil>{

        return listOf(

            Profil(1238,"Niesi", 53585738,"LeLe",72712423,
            25156772,2687284,1299569,33560577,
                33886693,1028948188,10619162,138946)
        )


    }
}