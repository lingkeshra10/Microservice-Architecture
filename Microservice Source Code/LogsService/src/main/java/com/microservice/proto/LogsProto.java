// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: logs.proto

package com.microservice.proto;

public final class LogsProto {
  private LogsProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_addLogsParams_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_addLogsParams_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_retrieveUserLogsParams_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_retrieveUserLogsParams_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_APIResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_APIResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Empty_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nlogs.proto\"E\n\raddLogsParams\022\016\n\006userId\030" +
      "\001 \001(\t\022\024\n\014responseCode\030\002 \001(\005\022\016\n\006remark\030\003 " +
      "\001(\t\"(\n\026retrieveUserLogsParams\022\016\n\006userId\030" +
      "\001 \001(\t\"<\n\013APIResponse\022\014\n\004code\030\001 \001(\005\022\017\n\007me" +
      "ssage\030\002 \001(\t\022\016\n\006object\030\003 \001(\t\"\007\n\005Empty2d\n\004" +
      "Logs\022!\n\007addLogs\022\016.addLogsParams\032\006.Empty\022" +
      "9\n\020retrieveUserLogs\022\027.retrieveUserLogsPa" +
      "rams\032\014.APIResponseB%\n\026com.microservice.p" +
      "rotoB\tLogsProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_addLogsParams_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_addLogsParams_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_addLogsParams_descriptor,
        new java.lang.String[] { "UserId", "ResponseCode", "Remark", });
    internal_static_retrieveUserLogsParams_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_retrieveUserLogsParams_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_retrieveUserLogsParams_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_APIResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_APIResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_APIResponse_descriptor,
        new java.lang.String[] { "Code", "Message", "Object", });
    internal_static_Empty_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Empty_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
