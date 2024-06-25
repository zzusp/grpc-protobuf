package org.example.config;

import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import org.example.grpc.impl.HelloServiceGrpcImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Configuration
public class GrpcConfig {

    @Value("${grpc.port:9090}")
    private int grpcPort;

    private Server server;

    @PostConstruct
    public void startGrpcServer() {
        try {
            server = NettyServerBuilder.forPort(grpcPort).addService(new HelloServiceGrpcImpl()).build().start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    public void stopGrpcServer() {
        if (server != null) {
            server.shutdown();
        }
    }
}