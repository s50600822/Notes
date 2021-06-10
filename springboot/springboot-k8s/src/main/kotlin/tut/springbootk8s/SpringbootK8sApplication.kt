package tut.springbootk8s

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringbootK8sApplication

fun main(args: Array<String>) {
	runApplication<SpringbootK8sApplication>(*args)
}
