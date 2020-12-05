package com.example.simple.repositories

import com.example.simple.models.OEvent
import org.springframework.data.repository.CrudRepository

interface EventRepository: CrudRepository<OEvent, Long>