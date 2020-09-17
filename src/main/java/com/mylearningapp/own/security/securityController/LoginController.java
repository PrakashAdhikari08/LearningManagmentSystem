package com.mylearningapp.own.security.securityController;


import com.mylearningapp.own.domain.User;
import com.mylearningapp.own.repository.UserRepository;
import com.mylearningapp.own.security.jwt.AuthenticationRequest;
import com.mylearningapp.own.security.jwt.AuthenticationResponse;
import com.mylearningapp.own.security.jwt.JwtUtil;
import com.mylearningapp.own.serviceImpl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


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
}
