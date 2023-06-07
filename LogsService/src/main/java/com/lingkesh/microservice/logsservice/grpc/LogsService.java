package com.lingkesh.microservice.logsservice.grpc;

import com.microservice.proto.APIResponse;
import com.microservice.proto.LogsGrpc;
import com.microservice.proto.loginRequest;
import io.grpc.stub.StreamObserver;

@net.devh.boot.grpc.server.service.GrpcService
public class LogsService extends LogsGrpc.LogsImplBase {

    @Override
    public void login(loginRequest request, StreamObserver<APIResponse> responseObserver) {
        //The line below will cause an error, fixes from this link https://stackoverflow.com/questions/44102096/grpc-core-rpcexception-method-is-unimplemented-with-c-sharp-client-and-java-serv
        //super.login(request, responseObserver);

        String username = request.getUsername();
        String password = request.getPassword();

        System.out.println("THE USERNAME IS SHOWING: " + username);
        System.out.println("THE PASSWORD IS SHOWING: " + password);

        int code= 0;
        String message = "Success";
        String object = "This is Object";

        APIResponse response = APIResponse.newBuilder()
                .setCode(code)
                .setMessage(message)
                .setObject(object).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
