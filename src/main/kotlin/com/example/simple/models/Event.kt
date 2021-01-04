package com.example.simple.models

import org.hibernate.annotations.Cascade
import javax.persistence.*

@Entity
class Event {

    @Id
    @GeneratedValue
    var id: Long? = null
    var eventName: String? = null
    var eventType: String? = null

    @OneToOne
    var eventOrganizer: User? = null

    @OneToMany
    var eventGuests: Set<User>? = null

    @OneToMany(cascade = arrayOf(CascadeType.ALL))
    var eventReviews: Set<Review>? = null

}