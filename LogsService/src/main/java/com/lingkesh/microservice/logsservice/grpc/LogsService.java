package com.lingkesh.microservice.logsservice.grpc;

import com.microservice.proto.APIResponse;
import com.microservice.proto.LogsGrpc;
import com.microservice.proto.addLogs;
import io.grpc.stub.StreamObserver;

@net.devh.boot.grpc.server.service.GrpcService
public class LogsService extends LogsGrpc.LogsImplBase {

    @Override
    public void logs(addLogs request, StreamObserver<APIResponse> responseObserver) {

        String userId = request.getUserId();
        int responseCode = request.getResponseCode();
        String remark = request.getRemark();

        System.out.println("THE userId IS SHOWING: " + userId);
        System.out.println("THE responseCode IS SHOWING: " + responseCode);
        System.out.println("THE remark IS SHOWING: " + remark);

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

//    @Override
//    public void login(addLogs request, StreamObserver<APIResponse> responseObserver) {
//        //The line below will cause an error, fixes from this link https://stackoverflow.com/questions/44102096/grpc-core-rpcexception-method-is-unimplemented-with-c-sharp-client-and-java-serv
//        //super.login(request, responseObserver);
//    }
}
