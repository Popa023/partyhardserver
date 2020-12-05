package com.example.simple.models

import javax.persistence.*

@Entity
class User {

    @Id
    @GeneratedValue
    var id: Long? = null
    var userName: String? = null
    var userEmail: String? = null
    var userType: String? = null
    var userRating: Double? = null
    var userDescription: String? = null

    @OneToMany
    var userComments: Set<Comment>? = null

}