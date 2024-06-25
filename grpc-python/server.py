from concurrent import futures

import grpc

from example.grpc.proto import hello_pb2_grpc, hello_pb2


class HelloServer(hello_pb2_grpc.HelloServiceServicer):

    # 继承
    def SayHello(self, request, context):
        name = request.your_name
        print("name " + name)
        return hello_pb2.HelloResponse(code=0, message="hello: {}, this is python grpc server".format(name))


def serve():
    port = "40000"
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    hello_pb2_grpc.add_HelloServiceServicer_to_server(HelloServer(), server)
    server.add_insecure_port('[::]:' + port)
    server.start()
    print("Server started, listening on " + port)
    server.wait_for_termination()


if __name__ == '__main__':
    serve()