package com.grpc.service;

import com.proto.login.LoginRequest;
import com.proto.login.LoginResponse;
import com.proto.login.LoginServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class LoginClientService {
    @GrpcClient("myServiceLogin")
    LoginServiceGrpc.LoginServiceBlockingStub loginServiceBlockingStub;

    public String login(String username, String password) {
        LoginRequest loginRequest = LoginRequest.newBuilder().setUsername(username).setPassword(password).build();
        LoginResponse loginResponse = loginServiceBlockingStub.login(loginRequest);
        return loginResponse.getMessage().toString();
    }
}
