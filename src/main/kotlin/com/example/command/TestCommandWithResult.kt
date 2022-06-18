package com.example.command

import com.trendyol.kediatr.AsyncCommandWithResultHandler
import com.trendyol.kediatr.CommandWithResult
import io.quarkus.runtime.Startup
import javax.enterprise.context.ApplicationScoped

class TestCommandWithResult(val id: String) : CommandWithResult<String>

@ApplicationScoped
@Startup
class TestCommandWithResultHandler : AsyncCommandWithResultHandler<TestCommandWithResult, String> {
    override suspend fun handleAsync(command: TestCommandWithResult): String {
        return "Command is working... ${command.id}"
    }
}