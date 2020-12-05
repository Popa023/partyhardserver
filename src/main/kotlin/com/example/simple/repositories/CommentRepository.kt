package com.example.simple.repositories

import com.example.simple.models.Comment
import org.springframework.data.repository.CrudRepository

interface CommentRepository: CrudRepository<Comment, Long>