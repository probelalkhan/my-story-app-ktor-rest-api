package net.simplifiedcoding.routes.story

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import net.simplifiedcoding.data.repository.story.StoryRepository
import net.simplifiedcoding.routes.DEFAULT_LIMIT_SIZE
import net.simplifiedcoding.routes.DEFAULT_PAGE_START
import net.simplifiedcoding.security.UserIdPrincipalForUser

fun Application.storyRoutes(repository: StoryRepository) {
    routing {
        authenticate {
            route("story") {

                get("my/{page}") {
                    val userId = call.principal<UserIdPrincipalForUser>()?.id
                    if (userId != null) {
                        val isDraft = call.request.queryParameters["is_draft"] == "true"
                        val limit = call.request.queryParameters["limit"]?.toIntOrNull() ?: DEFAULT_LIMIT_SIZE
                        val page = call.parameters["page"]?.toIntOrNull() ?: DEFAULT_PAGE_START
                        val result = repository.getMyStories(userId, page, limit, isDraft)
                        call.respond(result.statusCode, result)
                    } else {
                        call.respond(HttpStatusCode.Unauthorized)
                    }
                }

                get("all/{page}") {
                    val page = call.parameters["page"]?.toIntOrNull() ?: DEFAULT_PAGE_START
                    val limit = call.request.queryParameters["limit"]?.toIntOrNull() ?: DEFAULT_LIMIT_SIZE
                    val result = repository.getAllStories(page, limit)
                    call.respond(result.statusCode, result)
                }

                post("add") {
                    val params = call.receive<StoryParams>()
                    val result = repository.add(params)
                    call.respond(result.statusCode, result)
                }

                get("{id}") {
                    val id = call.parameters["id"]?.toIntOrNull() ?: -1
                    val result = repository.get(id)
                    call.respond(result.statusCode, result)
                }

                put("update/{id}") {
                    val id = call.parameters["id"]?.toIntOrNull() ?: -1
                    val params = call.receive<StoryParams>()
                    val result = repository.update(id, params)
                    call.respond(result.statusCode, result)
                }

                delete("delete/{id}") {
                    val id = call.parameters["id"]?.toIntOrNull() ?: -1
                    val result = repository.delete(id)
                    call.respond(result.statusCode, result)
                }

                get("{story_id}/comments") {
                    val storyId = call.parameters["story_id"]?.toIntOrNull() ?: -1
                    val result = repository.getComments(storyId)
                    call.respond(result.statusCode, result)
                }
            }
        }
    }
}