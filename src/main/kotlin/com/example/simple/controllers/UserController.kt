package com.example.simple.controllers

import com.example.simple.models.User
import com.example.simple.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    private val repository: UserRepository? = null

    @CrossOrigin
    @GetMapping("/getAll")
    fun getAll(): MutableIterable<User> {

        return repository!!.findAll()

    }

    @CrossOrigin
    @GetMapping("/get")
    fun get(@RequestParam id: Long): User? {

        return repository!!.findByIdOrNull(id)

    }

    @CrossOrigin
    @PostMapping("/post")
    fun post(@RequestBody user: User): User {

        repository!!.save(user)
        return user

    }

    @CrossOrigin
    @DeleteMapping("/delete")
    fun delete(@RequestParam id: Long): User? {

        val user: User? = repository!!.findByIdOrNull(id)
        if (user != null) {

            repository.delete(user)

        }

        return user
    }

}