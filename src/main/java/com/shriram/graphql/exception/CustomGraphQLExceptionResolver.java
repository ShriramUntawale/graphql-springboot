package com.shriram.graphql.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class CustomGraphQLExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof PlayerNotFoundException) {
            return GraphqlErrorBuilder.newError(env)
                    .message(ex.getMessage())
                    .build();
        }
        return null; // Return null to allow other resolvers to process the exception
    }
}