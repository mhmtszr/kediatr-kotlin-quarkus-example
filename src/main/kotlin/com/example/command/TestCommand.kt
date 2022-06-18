package com.example.command

import com.trendyol.kediatr.AsyncCommandHandler
import com.trendyol.kediatr.Command
import io.quarkus.runtime.Startup
import javax.enterprise.context.ApplicationScoped

class TestCommand(val id: String) : Command

@ApplicationScoped
@Startup
class TestCommandHandler : AsyncCommandHandler<TestCommand> {
    override suspend fun handleAsync(command: TestCommand) {
        println("Command is working... ${command.id}")
    }
}