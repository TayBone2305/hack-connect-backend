package default.routes
import default.firebase
import default.services.DbUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * Home redirection to OpenAPI api documentation
 */
@RestController
class HomeController(private val userService: DbUserService) {
    @GetMapping("/")
    fun index(): ResponseEntity<String> {
        return ResponseEntity.ok("Test")
    }
    class PersonRequest(val email:String, val password:String)
    @PostMapping(
        value = ["/login"], consumes = ["application/json"] )
    fun login(@RequestBody person:PersonRequest): ResponseEntity<Unit> {
        val users = userService.list()
        if (users.find { it?.email == person.email && it?.password == person.password } != null ){
            return ResponseEntity.ok().build()
        }
        else{
            return ResponseEntity.badRequest().build()
        }
    }
}
