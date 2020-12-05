package com.example.simple.controllers

import com.example.simple.models.OEvent
import com.example.simple.repositories.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/events")
class EventController {

    @Autowired
    private val repository: EventRepository? = null


    @GetMapping("/getAll")
    fun getAll(): MutableIterable<OEvent> {

        return repository!!.findAll()

    }

    @GetMapping("/get")
    fun get(@RequestParam id: Long): OEvent? {

        return repository!!.findByIdOrNull(id)

    }

    @PostMapping("/post")
    fun post(@RequestBody oEvent: OEvent): OEvent {

        repository!!.save(oEvent)
        return oEvent

    }

    @DeleteMapping("/delete")
    fun delete(@RequestParam id: Long): OEvent? {

        val oEvent: OEvent? = repository!!.findByIdOrNull(id)
        if (oEvent != null) {

            repository.delete(oEvent)

        }

        return oEvent
    }

}