package default.model

import jakarta.persistence.Entity
import jakarta.persistence.*

@Entity
class Person() : AbstractJpaPersistable<Long>() {
    lateinit var username: String
    lateinit var email: String
    lateinit var password: String
    lateinit var profile_picture: String

    @OneToMany()
    lateinit var languages: MutableList<Language>

    @OneToMany()
    lateinit var skills: MutableList<Skill>

    @ManyToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER)
    var teams: MutableList<Team> = mutableListOf()
}

@Entity
class Language() : AbstractJpaPersistable<Long>() {
    lateinit var name: String
}

@Entity
class Skill() : AbstractJpaPersistable<Long>() {
    lateinit var name: String
}

@Entity
class Room() :AbstractJpaPersistable<Long>(){
    @OneToMany
    lateinit var persons: MutableList<Person>
    @OneToMany
    lateinit var messages: MutableList<Message>
}

@Entity
class Message() : AbstractJpaPersistable<Long>() {
    @ManyToOne
    lateinit var person: Person
    lateinit var date: java.time.LocalDateTime
    lateinit var message: String
}

@Entity
class Team : AbstractJpaPersistable<Long>() {
    lateinit var name: String
    var description: String = ""
    var picture = ""

    @ManyToMany(mappedBy = "teams")
    var persons: MutableList<Person> = mutableListOf()
}