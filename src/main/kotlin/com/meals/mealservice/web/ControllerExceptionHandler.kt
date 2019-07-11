package com.meals.mealservice.web

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityNotFoundException

@ControllerAdvice(annotations = [RestController::class])
class ControllerExceptionHandler {

    @ExceptionHandler
    fun handleException(e: Exception): ResponseEntity<Any> {
        //TODO logging
        println(e.message)

        when(e) {
            is EntityNotFoundException -> return ResponseEntity.notFound().build()
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
    }

}