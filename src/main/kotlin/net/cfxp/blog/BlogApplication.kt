package net.cfxp.blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import java.util.concurrent.ConcurrentHashMap

data class  Customer(var id: Int = 0, var name: String = "")
@SpringBootApplication
class BlogApplication{
	companion object{
		val initialCustomers = arrayOf(Customer(1, "Kotlin"), Customer(2, "Stpring"), Customer(3, "Microservices"))
	}
	@Bean
	fun customers() = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))
}

fun main(args: Array<String>) {
	runApplication<BlogApplication>(*args){
//		setBannerMode(Banner.Mode.OFF)
	}
}
