package com.example.simple.repositories

import com.example.simple.models.GRoom
import org.springframework.data.repository.CrudRepository

interface RoomRepository: CrudRepository<GRoom, Long>