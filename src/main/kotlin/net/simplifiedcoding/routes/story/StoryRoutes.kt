package net.simplifiedcoding.routes.story

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import net.simplifiedcoding.data.repository.story.StoryRepository

fun Application.storyRoutes(repository: StoryRepository) {
    routing {
        authenticate {
            route("story") {

                get("all") {

                }

                post("add") {
                    val params = call.receive<StoryParams>()
                    val result = repository.add(params)
                    call.respond(result.statusCode, result)
                }

                put("update/{id}") {
                    val id = call.parameters["id"]?.toIntOrNull() ?: -1
                    val params = call.receive<StoryParams>()
                    val result = repository.update(id, params)
                    call.respond(result.statusCode, result)
                }

                delete("delete/{id}"){
                    val id = call.parameters["id"]?.toIntOrNull() ?: -1
                    val result = repository.delete(id)
                    call.respond(result.statusCode, result)
                }
            }
        }
    }
}