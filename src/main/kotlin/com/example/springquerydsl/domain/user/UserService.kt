package com.example.springquerydsl.domain.user

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.annotation.Resource
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService {

    @Resource
    private lateinit var repository: UserRepository
    @Resource
    private lateinit var queryFactory: JPAQueryFactory

    fun getById(id: Long): User?{
        var table = QUser.user
        return queryFactory.select(table)
            .from(table)
            .where(table.id.eq(id))
            .fetchOne()
    }

    fun select(): List<User>{
        val table = QUser.user
        val predicate = table.name.startsWith("后")
            .and(table.createTime
                .loe(LocalDateTime.now())
            )
        return repository.findAll(predicate) as List<User>
    }
}
