package com.example.railway_ticket_backend.service.auth;

import com.example.railway_ticket_backend.dto.auth.LoginDto;
import com.example.railway_ticket_backend.dto.auth.RegisterDto;
import com.example.railway_ticket_backend.entity.user.User;
import com.example.railway_ticket_backend.repository.RoleRepo;
import com.example.railway_ticket_backend.repository.UserRepo;
import com.example.railway_ticket_backend.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public HttpEntity<?> registerUser(RegisterDto registerDto) {
        User user = User.builder()
                .firstName(registerDto.firstName())
                .lastName(registerDto.lastName())
                .username(registerDto.username())
                .password(passwordEncoder.encode(registerDto.password()))
                .enabled(true)
                .roles(roleRepo.findAllByName("ROLE_USER"))
                .build();

        userRepo.save(user);
        return ResponseEntity.ok("success");
    }

    @Override
    public HttpEntity<?> loginUser(LoginDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password()));
        User user = userRepo.findByUsername(loginDto.username()).orElseThrow();
        String token = jwtService.generateJwtToken(user);
        return ResponseEntity.ok(token);
    }

    @Override
    public HttpEntity<?> me() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(authentication.getAuthorities());
    }
}
