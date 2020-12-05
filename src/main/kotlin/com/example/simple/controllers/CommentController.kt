package com.example.simple.controllers

import com.example.simple.models.Comment
import com.example.simple.repositories.CommentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/comments")
class CommentController {

    @Autowired
    private val repository: CommentRepository? = null

    @GetMapping("/getAll")
    fun getAll(): MutableIterable<Comment> {

        return repository!!.findAll()

    }

    @GetMapping("/get")
    fun get(@RequestParam id: Long): Comment? {

        return repository!!.findByIdOrNull(id)

    }

    @GetMapping("/getByEvent")
    fun getByEvent(@RequestParam eventId: Long): MutableIterable<Comment> {

        var comments: MutableIterable<Comment> = repository!!.findAll()
        comments.removeAll { predicate: Comment -> predicate.commentEvent!!.id != eventId }
        return comments

    }

    @PostMapping("/post")
    fun post(@RequestBody comment: Comment): Comment {

        repository!!.save(comment)
        return comment

    }

    @DeleteMapping("/delete")
    fun delete(@RequestParam id: Long): Comment? {

        val comment: Comment? = repository!!.findByIdOrNull(id)
        if (comment != null) {

            repository.delete(comment)

        }

        return comment
    }

}