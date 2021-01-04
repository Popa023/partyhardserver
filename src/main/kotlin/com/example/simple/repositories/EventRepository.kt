package com.example.simple.repositories

import com.example.simple.models.Event
import org.springframework.data.repository.CrudRepository

interface EventRepository: CrudRepository<Event, Long>