package com.mylearningapp.own.security.securityController;


import com.mylearningapp.own.domain.Customer;
import com.mylearningapp.own.domain.Role;
import com.mylearningapp.own.domain.User;
import com.mylearningapp.own.dtos.CustomerDto;
import com.mylearningapp.own.repository.CustomerRepository;
import com.mylearningapp.own.repository.UserRepository;
import com.mylearningapp.own.security.jwt.AuthenticationRequest;
import com.mylearningapp.own.security.jwt.AuthenticationResponse;
import com.mylearningapp.own.security.jwt.JwtUtil;
import com.mylearningapp.own.service.CustomerService;
import com.mylearningapp.own.serviceImpl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception{
        try{

            System.out.println("Username==>> " +authenticationRequest.getUsername()+"  "+ authenticationRequest.getPassword()+"   password==>> ");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }
        catch(BadCredentialsException e){

            return new ResponseEntity("Invalid credentials", HttpStatus.BAD_REQUEST);

        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        User user = userRepository.findByUsername(authenticationRequest.getUsername()).get();

        return ResponseEntity.ok(new AuthenticationResponse(jwt,user.getId(),user.getRole(),user.getName(),user.getUsername()));
    }


    //facebook access token receiving
    @Modifying
    @Transactional
    @PostMapping("/facebook/login")
    public ResponseEntity<?> facebookLoginAccessToken(@Valid @RequestBody FacebookUser facebookUser){
        System.out.println(facebookUser.getId());
        Customer user = new Customer();
        if(!userRepository.findByUsername(facebookUser.getEmail()).isPresent()){

            user.setName(facebookUser.getName());
            user.setUsername(facebookUser.getEmail());
            user.setRole(Role.ROLE_CUSTOMER);
            user.setPassword(facebookUser.getId());
            customerRepository.save(user);
        }
        else
            user = customerRepository.findByUsername(facebookUser.getEmail()).get();

        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt,user.getId(),user.getRole(),user.getName(),user.getUsername()));


    }

}
