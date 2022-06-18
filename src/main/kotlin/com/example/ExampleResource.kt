package com.example

import com.example.command.TestCommand
import com.example.command.TestCommandWithResult
import com.example.query.TestQuery
import com.trendyol.kediatr.CommandBus
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/demo")
class ExampleResource(
    private val commandBus: CommandBus
) {

    @GET
    @Path("query")
    @Produces(MediaType.TEXT_PLAIN)
    suspend fun query(): String {
        return commandBus.executeQueryAsync(TestQuery("ExampleId"))
    }

    @GET
    @Path("command")
    @Produces(MediaType.TEXT_PLAIN)
    suspend fun command(): String {
        commandBus.executeCommandAsync(TestCommand("ExampleId"))
        return "Command worked successfully"
    }

    @GET
    @Path("commandWithResult")
    @Produces(MediaType.TEXT_PLAIN)
    suspend fun commandWithResult(): String {
        return commandBus.executeCommandAsync(TestCommandWithResult("ExampleId"))
    }
}