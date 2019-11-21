package net.cfxp.blog

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api")
class ArticleController(private val repository: ArticleRepository){
    @GetMapping("/article")
    fun findAll() = repository.findAllByOrderByAddedAtDesc()

    @GetMapping("/article/{slug")
    fun findOne(@PathVariable slug: String) =
            repository.findBySlug(slug) ?: ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")
}

@RestController
@RequestMapping("/api")
class UserController(private val repository: UserRepository){
    @GetMapping("/user")
    fun findAll() = repository.findAll()

    @GetMapping("/user/{login}")
    fun findOne(@PathVariable login: String) =
    repository.findByLogin(login) ?: ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist")
}

@RestController
@RequestMapping("/api")
class TestController(val service: ExampleService){
    @GetMapping("/test/{name}")
    fun test(@PathVariable name: String) = service.getHello(name) + "??---?"
}

@RestController
@RequestMapping("/api")
class AnotherTestController{
    @Autowired
    lateinit var service: ServiceInterface
    @GetMapping("/anothertest/{name}")
    fun anotherTest(@PathVariable name: String) = service.getHello(name)
}
