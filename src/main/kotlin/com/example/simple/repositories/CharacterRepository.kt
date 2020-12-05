package com.example.simple.repositories

import com.example.simple.models.GCharacter
import org.springframework.data.repository.CrudRepository

interface CharacterRepository: CrudRepository<GCharacter, Long>