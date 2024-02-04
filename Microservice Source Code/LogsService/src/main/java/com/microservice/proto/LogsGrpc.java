package com.microservice.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: logs.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LogsGrpc {

  private LogsGrpc() {}

  public static final String SERVICE_NAME = "Logs";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.microservice.proto.addLogsParams,
      com.microservice.proto.Empty> getAddLogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addLogs",
      requestType = com.microservice.proto.addLogsParams.class,
      responseType = com.microservice.proto.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.microservice.proto.addLogsParams,
      com.microservice.proto.Empty> getAddLogsMethod() {
    io.grpc.MethodDescriptor<com.microservice.proto.addLogsParams, com.microservice.proto.Empty> getAddLogsMethod;
    if ((getAddLogsMethod = LogsGrpc.getAddLogsMethod) == null) {
      synchronized (LogsGrpc.class) {
        if ((getAddLogsMethod = LogsGrpc.getAddLogsMethod) == null) {
          LogsGrpc.getAddLogsMethod = getAddLogsMethod =
              io.grpc.MethodDescriptor.<com.microservice.proto.addLogsParams, com.microservice.proto.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addLogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.microservice.proto.addLogsParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.microservice.proto.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new LogsMethodDescriptorSupplier("addLogs"))
              .build();
        }
      }
    }
    return getAddLogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.microservice.proto.retrieveUserLogsParams,
      com.microservice.proto.APIResponse> getRetrieveUserLogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "retrieveUserLogs",
      requestType = com.microservice.proto.retrieveUserLogsParams.class,
      responseType = com.microservice.proto.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.microservice.proto.retrieveUserLogsParams,
      com.microservice.proto.APIResponse> getRetrieveUserLogsMethod() {
    io.grpc.MethodDescriptor<com.microservice.proto.retrieveUserLogsParams, com.microservice.proto.APIResponse> getRetrieveUserLogsMethod;
    if ((getRetrieveUserLogsMethod = LogsGrpc.getRetrieveUserLogsMethod) == null) {
      synchronized (LogsGrpc.class) {
        if ((getRetrieveUserLogsMethod = LogsGrpc.getRetrieveUserLogsMethod) == null) {
          LogsGrpc.getRetrieveUserLogsMethod = getRetrieveUserLogsMethod =
              io.grpc.MethodDescriptor.<com.microservice.proto.retrieveUserLogsParams, com.microservice.proto.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "retrieveUserLogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.microservice.proto.retrieveUserLogsParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.microservice.proto.APIResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LogsMethodDescriptorSupplier("retrieveUserLogs"))
              .build();
        }
      }
    }
    return getRetrieveUserLogsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LogsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LogsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LogsStub>() {
        @java.lang.Override
        public LogsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LogsStub(channel, callOptions);
        }
      };
    return LogsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LogsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LogsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LogsBlockingStub>() {
        @java.lang.Override
        public LogsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LogsBlockingStub(channel, callOptions);
        }
      };
    return LogsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LogsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LogsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LogsFutureStub>() {
        @java.lang.Override
        public LogsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LogsFutureStub(channel, callOptions);
        }
      };
    return LogsFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class LogsImplBase implements io.grpc.BindableService {

    /**
     */
    public void addLogs(com.microservice.proto.addLogsParams request,
        io.grpc.stub.StreamObserver<com.microservice.proto.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddLogsMethod(), responseObserver);
    }

    /**
     */
    public void retrieveUserLogs(com.microservice.proto.retrieveUserLogsParams request,
        io.grpc.stub.StreamObserver<com.microservice.proto.APIResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRetrieveUserLogsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddLogsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.microservice.proto.addLogsParams,
                com.microservice.proto.Empty>(
                  this, METHODID_ADD_LOGS)))
          .addMethod(
            getRetrieveUserLogsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.microservice.proto.retrieveUserLogsParams,
                com.microservice.proto.APIResponse>(
                  this, METHODID_RETRIEVE_USER_LOGS)))
          .build();
    }
  }

  /**
   */
  public static final class LogsStub extends io.grpc.stub.AbstractAsyncStub<LogsStub> {
    private LogsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LogsStub(channel, callOptions);
    }

    /**
     */
    public void addLogs(com.microservice.proto.addLogsParams request,
        io.grpc.stub.StreamObserver<com.microservice.proto.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddLogsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void retrieveUserLogs(com.microservice.proto.retrieveUserLogsParams request,
        io.grpc.stub.StreamObserver<com.microservice.proto.APIResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveUserLogsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LogsBlockingStub extends io.grpc.stub.AbstractBlockingStub<LogsBlockingStub> {
    private LogsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LogsBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.microservice.proto.Empty addLogs(com.microservice.proto.addLogsParams request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddLogsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.microservice.proto.APIResponse retrieveUserLogs(com.microservice.proto.retrieveUserLogsParams request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveUserLogsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LogsFutureStub extends io.grpc.stub.AbstractFutureStub<LogsFutureStub> {
    private LogsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LogsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.microservice.proto.Empty> addLogs(
        com.microservice.proto.addLogsParams request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddLogsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.microservice.proto.APIResponse> retrieveUserLogs(
        com.microservice.proto.retrieveUserLogsParams request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveUserLogsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_LOGS = 0;
  private static final int METHODID_RETRIEVE_USER_LOGS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LogsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LogsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_LOGS:
          serviceImpl.addLogs((com.microservice.proto.addLogsParams) request,
              (io.grpc.stub.StreamObserver<com.microservice.proto.Empty>) responseObserver);
          break;
        case METHODID_RETRIEVE_USER_LOGS:
          serviceImpl.retrieveUserLogs((com.microservice.proto.retrieveUserLogsParams) request,
              (io.grpc.stub.StreamObserver<com.microservice.proto.APIResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LogsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LogsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.microservice.proto.LogsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Logs");
    }
  }

  private static final class LogsFileDescriptorSupplier
      extends LogsBaseDescriptorSupplier {
    LogsFileDescriptorSupplier() {}
  }

  private static final class LogsMethodDescriptorSupplier
      extends LogsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LogsMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LogsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LogsFileDescriptorSupplier())
              .addMethod(getAddLogsMethod())
              .addMethod(getRetrieveUserLogsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
