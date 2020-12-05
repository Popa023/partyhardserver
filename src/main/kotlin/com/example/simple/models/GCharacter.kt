package com.example.simple.models

import javax.persistence.*

@Entity
class GCharacter {

    @Id
    @GeneratedValue
    var id: Long? = null
    var strength: Int? = null
    var strengthProgress: Int? = null
    var speed: Int? = null
    var speedProgress: Int? = null
    var health: Int? = null
    var attack: Int? = null

}