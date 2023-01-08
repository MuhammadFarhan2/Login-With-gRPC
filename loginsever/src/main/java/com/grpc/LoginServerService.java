package com.grpc;

import com.proto.login.LoginRequest;
import com.proto.login.LoginResponse;
import com.proto.login.LoginServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class LoginServerService extends LoginServiceGrpc.LoginServiceImplBase {

    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {

        String username = request.getUsername();
        String password = request.getPassword();
        LoginResponse response ;
        if (password.equals(username)) {
                response = LoginResponse.newBuilder().setMessage("Login Successfully").build();
        }
        else
            response = LoginResponse.newBuilder().setMessage("Wrong username or password").build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
