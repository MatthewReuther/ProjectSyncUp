package com.nashss.se.projectsyncup.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.projectsyncup.activity.requests.GetProjectTasksRequest;
import com.nashss.se.projectsyncup.activity.results.GetProjectTasksResult;

/**
 * The `GetProjectTasksLambda` class is an implementation of the AWS Lambda function that retrieves a projects tasks.
 * This class extends the `LambdaActivityRunner` and implements the `RequestHandler` interface.
 *
 */
public class GetProjectTasksLambda
        extends LambdaActivityRunner<GetProjectTasksRequest, GetProjectTasksResult>
        implements RequestHandler<LambdaRequest<GetProjectTasksRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetProjectTasksRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPathAndQuery((path, query) ->
                        GetProjectTasksRequest.builder()
                                .withProjectId(path.get("projectId"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideGetProjectTasksActivity().handleRequest(request)
        );
    }
}

