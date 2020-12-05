package com.example.simple.models

import javax.persistence.*

@Entity
class OEvent {

    @Id
    @GeneratedValue
    var id: Long? = null
    var eventName: String? = null
    var eventDescription: String? = null
    var eventActive: Boolean? = null

    @ManyToMany
    var eventGuests: Set<User>? = null

    @ManyToMany
    var eventLocations: Set<User>? = null

    @OneToMany
    var eventComments: Set<Comment>? = null
}