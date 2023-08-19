package com.example.springquerydsl.domain.user

import jakarta.annotation.Resource
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTests {

    @Resource
    private lateinit var service: UserService

    @Test
    fun getById(){
        val entity = service.getById(1L)
        Assertions.assertNotNull(entity)
    }

    @Test
    fun select(){
        val list = service.select()
        Assertions.assertNotNull(list)
    }
}
