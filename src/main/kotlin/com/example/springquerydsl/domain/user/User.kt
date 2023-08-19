package com.example.springquerydsl.domain.user

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "t_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val createTime: LocalDateTime,
    val name: String
)
