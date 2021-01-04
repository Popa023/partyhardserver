package com.example.simple.controllers

import com.example.simple.models.Event
import com.example.simple.repositories.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/events")
class EventController {

    @Autowired
    private val repository: EventRepository? = null

    @CrossOrigin
    @GetMapping("/getAll")
    fun getAll(): MutableIterable<Event> {

        return repository!!.findAll()

    }
    @CrossOrigin
    @GetMapping("/get")
    fun get(@RequestParam id: Long): Event? {

        return repository!!.findByIdOrNull(id)

    }
    @CrossOrigin
    @PostMapping("/post")
    fun post(@RequestBody pEvent: Event): Event {

        repository!!.save(pEvent)
        return pEvent

    }
    @CrossOrigin
    @DeleteMapping("/delete")
    fun delete(@RequestParam id: Long): Event? {

        val pEvent: Event? = repository!!.findByIdOrNull(id)
        if (pEvent != null) {

            repository.delete(pEvent)

        }

        return pEvent
    }

}