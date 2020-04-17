package com.example.cardspocemon

 data class cards (
       val id: String,
       val  name: String,
       val imageUrl: String,
       val types: List<String>

)

 data class card (val cards : List<cards>)
