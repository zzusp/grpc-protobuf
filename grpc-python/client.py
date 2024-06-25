from concurrent import futures

import grpc

from example.grpc.proto import hello_pb2_grpc, hello_pb2

def client():
    port = "9090"
    channel = grpc.insecure_channel('localhost:' + port)

    stub = hello_pb2_grpc.HelloServiceStub(channel)
    print(stub.SayHello(hello_pb2.HelloRequest(your_name="python client")))


if __name__ == '__main__':
    client()