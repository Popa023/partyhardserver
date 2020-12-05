package com.example.simple.models

import javax.persistence.*

@Entity
class Comment {

    @Id
    @GeneratedValue
    var id: Long? = null
    var commentString: String? = null
    var commentLikes: Int? = null

    @ManyToOne
    var commentEvent: OEvent? = null

    @ManyToOne
    var commentCreator: User? = null

    @OneToMany
    var commentReplies: Set<Comment>? = null

}