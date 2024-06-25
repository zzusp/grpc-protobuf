package org.example.grpc.impl;

import com.google.rpc.Code;
import io.grpc.stub.StreamObserver;
import org.example.grpc.proto.HelloProto;
import org.example.grpc.proto.HelloServiceGrpc;

public class HelloServiceGrpcImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloProto.HelloRequest request, StreamObserver<HelloProto.HelloResponse> responseObserver) {

        HelloProto.HelloResponse response = HelloProto.HelloResponse.newBuilder().setCode(Code.OK)
                .setMessage("hello: " + request.getYourName() + ", this is java grpc server").build();
        System.out.println("request success.");
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
