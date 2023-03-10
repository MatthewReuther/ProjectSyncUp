package com.nashss.se.projectsyncup.lambda;

import com.nashss.se.projectsyncup.dependency.DaggerServiceComponent;
import com.nashss.se.projectsyncup.dependency.ServiceComponent;

import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * Class that handles running an activity and returning a LambdaResponse.
 *
 * @param <TRequest> The type of the request required to run the activity.
 * @param <TResult> The type of the result obtained after running the activity.
 */
public class LambdaActivityRunner<TRequest, TResult> {
    private ServiceComponent service;

    /**
     * Handles running the activity and returning a LambdaResponse (either success or failure).
     * @param requestSupplier Provides the activity request.
     * @param handleRequest Runs the activity and provides a response.
     * @return A LambdaResponse
     */
    protected LambdaResponse runActivity(
            Supplier<TRequest> requestSupplier,
            BiFunction<TRequest, ServiceComponent, TResult> handleRequest) {

        try {
            TRequest request = requestSupplier.get();
            ServiceComponent serviceComponent = getService();
            TResult result = handleRequest.apply(request, serviceComponent);
            return LambdaResponse.success(result);
        } catch (Exception e) {
            return LambdaResponse.error(e);
        }
    }

    /**
     * Returns the instance of the ServiceComponent.
     * If the instance is not already created, it creates a new instance.
     *
     * @return the instance of the ServiceComponent
     */
    private ServiceComponent getService() {
        if (service == null) {
            service = DaggerServiceComponent.create();
        }
        return service;
    }
}
