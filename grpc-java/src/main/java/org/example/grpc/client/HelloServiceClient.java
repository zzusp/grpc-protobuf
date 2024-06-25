package org.example.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.grpc.proto.HelloProto;
import org.example.grpc.proto.HelloServiceGrpc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloServiceClient {

    private ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 40000).usePlaintext().build();

    @GetMapping("/sendToPython")
    public String sendToPython(@RequestParam String name) {
        HelloProto.HelloRequest.newBuilder().setYourName(name).build();
        HelloProto.HelloResponse response = HelloServiceGrpc.newBlockingStub(channel).sayHello(HelloProto.HelloRequest.newBuilder().setYourName(name).build());
        System.out.println("code: " + response.getCode() + ", message: " + response.getMessage());
        return response.getMessage();
    }

}
