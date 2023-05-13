package default.model

import jakarta.persistence.Entity
import jakarta.persistence.*

@Entity
@Table(name = "persons")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val person_id: Long,
    val username: String,
    val email: String,
    val password: String,
    val profile_picture: String
)

@Entity
@Table(name = "persons_skills")
data class PersonSkill(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "person_skill_id")
    val person_skill_id,
    @OneToMany()
    val languages: MutableList<Language>,
    @ManyToOne()
    val skills: Skill,
    @ManyToOne(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER)
    val teams: Teams
)

@Entity
@Table(name = "languages")
data class Language(
    @Id val language_id: Long,
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val name: String,
)

@Entity
@Table(name = "skills")
data class Skill(
    @Id val skill_id: Long,
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val name: String
)

@Entity
@Table(name = "rooms")
data class Rooms(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val room_id: Long,
    @OneToMany
    val persons: MutableList<Person>,
    @OneToMany
    val messages: MutableList<Messages>,
)

@Entity
@Table(name = "messages")
data class Messages(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val message_id: Long,
    @ManyToOne
    val person: Person,
    val date: java.time.LocalDateTime,
    val message: String,
)

@Entity
@Table(name = "teams")
data class Teams(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val team_id: Long,
    val name: String,
    val description: String,
    val picture: String,
    val persons: MutableList<Person>,
)