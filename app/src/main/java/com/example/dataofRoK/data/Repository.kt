package com.example.dataofRoK.data

import com.example.dataofRoK.data.model.Kingdoms

class Repository {

    fun loadKingdoms (): List<Kingdoms>{
        return listOf(

            Kingdoms("Kingdom of Galloway", 1001),
            Kingdoms("Kingdom of Valencia",1003),
            Kingdoms("Hatami´s Hope",1017),
            Kingdoms("Kingdom of Asadal",1097),
            Kingdoms("Kingdom of Hattusha",1108),
            Kingdoms(" Kingdom of Viking",1122),
            Kingdoms("Kingdom of Merovech",1149),
            Kingdoms("Kingdom of Babylon",1195),
            Kingdoms("Kingdom of Titus ",1224),
            Kingdoms("Kingdom of Leila",1238),
            Kingdoms("Kingdom of Gardiner ",1303),
            Kingdoms("Kingdom of Balimo",1430),
            Kingdoms("Kingdom of Germania",1558),
            Kingdoms("Kingdom of Mandini",1646),
            Kingdoms("Kingdom of Chipepo ",1703),
            Kingdoms("Kingdom of Hove",1886),
            Kingdoms("Kingdom of Ketton",1945),
            Kingdoms("Kingdom of Iapala",2067),
            Kingdoms("Kingdom of Alata",2168),
            Kingdoms("Kingdom of Wafura",2256),
            Kingdoms("Kingdom of Jaramillo",2340),
            Kingdoms("Kingdom of Noriland",2427),
            Kingdoms("Kingdom of Derek",2555),
            Kingdoms("Kingdom of Rickard",2632),
            Kingdoms("Kingdom of Wilbay",2753),
            Kingdoms("Kingdom of Theemon",2892),
            Kingdoms("Kingdom of Vanjacob",2961),
            Kingdoms("Kingdom of Yalek",3046),
            Kingdoms("Kingdom of Tulik",3140),
        )
    }
}