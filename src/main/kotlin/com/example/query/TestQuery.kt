package com.example.query

import com.trendyol.kediatr.AsyncQueryHandler
import com.trendyol.kediatr.Query
import io.quarkus.runtime.Startup
import javax.enterprise.context.ApplicationScoped

class TestQuery(val id: String) : Query<String>

@ApplicationScoped
@Startup
class TestQueryQueryHandler : AsyncQueryHandler<TestQuery, String> {
    override suspend fun handleAsync(query: TestQuery): String {
        return "Test Query: ${query.id}"
    }
}