package com.lingkesh.microservice.logsservice.config;

import com.lingkesh.microservice.logsservice.grpc.LogsGrpcConsumer;
import com.lingkesh.microservice.logsservice.service.LogService;
import com.lingkesh.microservice.logsservice.service.impl.LogServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@ComponentScan(basePackages = "com.lingkesh.microservice.logsservice.*")
public class GrpcServerConfig {

    @Value("${grpc.server.port}")
    private int grpcServerPort;

    @Bean
    public Server grpcServer(LogsGrpcConsumer logsGrpcConsumer) throws IOException {
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(grpcServerPort).addService(logsGrpcConsumer);
        Server server = serverBuilder.build();
        server.start();
        return server;
    }

    @Bean
    public LogsGrpcConsumer customLogsGrpcConsumer(LogService logService) {
        return new LogsGrpcConsumer(logService);
    }

    @Bean
    public LogService customLogService() {
        return new LogServiceImpl(); // assuming LogServiceImpl is your LogService implementation
    }
}
