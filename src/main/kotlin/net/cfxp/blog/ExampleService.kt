package net.cfxp.blog

import org.springframework.stereotype.Service

@Service
class ExampleService : ServiceInterface{
    override  fun getHello(name: String) = "hello $name"
}