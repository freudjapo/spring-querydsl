package com.example.springquerydsl.config

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueryDslConfig {

    @Bean
    fun japQueryFactory(entityManager: EntityManager): JPAQueryFactory{
        return JPAQueryFactory(entityManager)
    }
}
