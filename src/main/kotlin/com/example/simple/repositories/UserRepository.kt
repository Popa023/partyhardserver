package com.example.simple.repositories

import com.example.simple.models.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long>