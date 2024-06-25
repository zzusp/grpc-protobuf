# 保持依赖整洁
go mod tidy

# 国内镜像
go env -w GOPROXY=https://mirrors.aliyun.com/goproxy
# 原镜像
go env -w GOPROXY=https://goproxy.cn,direct

# 安装
go get github.com/grpc-ecosystem/grpc-gateway/v2/runtime
go get google.golang.org/grpc
go get google.golang.org/grpc/credentials/insecure
go get google.golang.org/grpc/grpclog

# 下载地址
https://github.com/grpc/grpc-go/releases
