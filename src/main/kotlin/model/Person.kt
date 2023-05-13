package default.model

import jakarta.persistence.Entity
import jakarta.persistence.*

@Entity
class Person(@Id val person_id: Long) {
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
class Language(@Id val language_id: Long) {
    lateinit var name: String
}

@Entity
class Skill(@Id val skill_id: Long ) {
    lateinit var name: String
}

@Entity
class Room(@Id val room_id:Long) {
    @OneToMany
    lateinit var persons: MutableList<Person>
    @OneToMany
    lateinit var messages: MutableList<Message>
}

@Entity
class Message(@Id val message_id:Long)  {
    @ManyToOne
    lateinit var person: Person
    lateinit var date: java.time.LocalDateTime
    lateinit var message: String
}

@Entity
class Team(@Id val team_id:Long)   {
    lateinit var name: String
    var description: String = ""
    var picture = ""
    @ManyToMany(mappedBy = "teams")
    var persons: MutableList<Person> = mutableListOf()
}