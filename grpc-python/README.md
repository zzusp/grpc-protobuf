python -m pip install --upgrade pip

python -m pip install grpcio

python -m pip install grpcio-tools

python -m pip install googleapis-common-protos

# Proto文件生成代码
cd .\proto-files\

python -m grpc_tools.protoc -I ./ --python_out=../grpc-python/example/grpc/proto --grpc_python_out=../grpc-python/example/grpc/proto ./*.proto

# 修改生成后文件
```python
import hello_pb2 as hello__pb2
# 改为
from example.grpc.proto import hello_pb2 as hello__pb2
```