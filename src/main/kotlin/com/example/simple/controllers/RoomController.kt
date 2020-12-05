package com.example.simple.controllers

import com.example.simple.models.GRoom
import com.example.simple.models.User
import com.example.simple.repositories.RoomRepository
import com.example.simple.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*
import kotlin.random.Random


@RestController
@RequestMapping("/rooms")
class RoomController {

    @Autowired
    private val repository: RoomRepository? = null
    @Autowired
    private val uRepository: UserRepository? = null

    @PostMapping("/start")
    fun start(@RequestParam roomId: Long): GRoom? {

        val room: GRoom = repository!!.findByIdOrNull(roomId) ?: return null
        room.turn = Random.nextLong(1, room.users!!.size.toLong())
        repository.save(room)
        return room

    }

    @PostMapping("/attack")
    fun attack(@RequestParam roomId: Long, @RequestParam attackerId: Long,
               @RequestParam defenderId: Long): User? {

        var room: GRoom? = repository!!.findByIdOrNull(roomId) ?: return null
        val attacker: User? = uRepository!!.findByIdOrNull(attackerId)
        val defender: User? = uRepository.findByIdOrNull(defenderId)
        if(attacker == null || defender == null) {
            return null
        }
        attacker.gCharacter!!.strengthProgress = attacker.gCharacter!!.strengthProgress?.plus(1)
        attacker.gCharacter!!.speedProgress = attacker.gCharacter!!.speedProgress?.plus(1)
        defender.gCharacter!!.strengthProgress = defender.gCharacter!!.strengthProgress?.plus(1)
        defender.gCharacter!!.speedProgress = defender.gCharacter!!.speedProgress?.plus(1)
        defender.gCharacter!!.health = defender.gCharacter!!.health?.minus(attacker.gCharacter!!.attack!!)
        uRepository.save(defender)
        return defender

    }

    @PostMapping("/endTurn")
    fun endTurn(@RequestParam roomId: Long, @RequestParam userId: Long): GRoom? {

        val room: GRoom = repository!!.findByIdOrNull(roomId) ?: return null
        room.turn = room.turn?.plus(1)
        if(room.turn!! > room.users!!.size){
            room.turn = 1
        }

        repository.save(room)
        return room

    }

    @GetMapping("endGame")
    fun endGame(@RequestParam roomId: Long, @RequestParam userId: Long): Boolean? {

        val room: GRoom = repository!!.findByIdOrNull(roomId) ?: return null
        for(user: User in room.users!!){
            if(user.gCharacter!!.health!! <= 0){
                return user.id != userId
            }
        }
        return null
    }

    @PostMapping("/finishGame")
    fun finishGame(@RequestParam roomId: Long): GRoom? {

        val room: GRoom = repository!!.findByIdOrNull(roomId) ?: return null
        for(user: User in room.users!!){
            user.gCharacter!!.strength = 1 + (user.gCharacter!!.strengthProgress?.div(100) ?: 0)
            user.gCharacter!!.speed = 1 + (user.gCharacter!!.speedProgress?.div(100) ?: 0)
            user.gCharacter!!.health = 100 + 10 * user.gCharacter!!.strength!!
            user.gCharacter!!.attack = 10 + 2 * user.gCharacter!!.strength!!

        }
        repository.delete(room)
        return room

    }

    @GetMapping("/getAll")
    fun getAll(): MutableIterable<GRoom> {

        return repository!!.findAll()

    }

    @GetMapping("/get")
    fun get(@RequestParam id: Long): GRoom? {

        return repository!!.findByIdOrNull(id)

    }

    @PostMapping("/post")
    fun post(@RequestBody gRoom: GRoom): GRoom {

        repository!!.save(gRoom)
        return gRoom

    }

    @DeleteMapping("/delete")
    fun delete(@RequestParam id: Long): GRoom? {

        val gRoom: GRoom? = repository!!.findByIdOrNull(id)
        if (gRoom != null) {

            repository.delete(gRoom)

        }

        return gRoom
    }

}