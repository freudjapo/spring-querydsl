package com.example.springquerydsl.domain.user

import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>, QuerydslPredicateExecutor<User>{
}
