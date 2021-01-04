package com.example.simple.models

import javax.persistence.*

@Entity
class Review {

    @Id
    @GeneratedValue
    var id: Long? = null
    var grade: Long? = null

    @ManyToOne
    var reviewer: User? = null

}