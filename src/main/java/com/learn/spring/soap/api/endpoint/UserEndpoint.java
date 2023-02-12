package com.learn.spring.soap.api.endpoint;


import com.learn.spring.soap.api.repo.UserRepository;
import com.learn.spring.soap.api.users.GetUserRequest;
import com.learn.spring.soap.api.users.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


/**
 * @author kansanja on 10/02/23.
 */
@Endpoint
public class UserEndpoint {
    @Autowired
    private UserRepository userRepository;

    private static final String NAMESPACE = "http://www.learn.com/spring/soap/api/users";


    @PayloadRoot(namespace = NAMESPACE, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getLoanStatus(@RequestPayload GetUserRequest userRequest) {
        GetUserResponse userResponse = new GetUserResponse();
        userResponse.setUser(userRepository.getUserById(userRequest.getId()));
        return userResponse;
    }
}
