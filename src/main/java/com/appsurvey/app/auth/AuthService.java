package com.appsurvey.app.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.appsurvey.app.jwt.JwtService;
import com.appsurvey.app.user.domain.entities.Role;
import com.appsurvey.app.user.domain.entities.User;
import com.appsurvey.app.user.infrastructure.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        // Autenticar al usuario
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        // Obtener los detalles del usuario
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();

        // Generar el token JWT
        String token = jwtService.getToken(user);

        // Devolver el token junto con el rol del usuario
        return AuthResponse.builder()
            .token(token)
            .role(user.getRole().name())  // Aquí se agrega el rol del usuario a la respuesta
            .build();
    }

    // Método para registrar al usuario (puede que necesites hacer lo mismo aquí)
    public AuthResponse register(RegisterRequest request) {
       // Verificar que el rol esté presente en la solicitud
       if (request.getRole() == null) {
        throw new IllegalArgumentException("El rol es requerido");
    }

    // Crear el usuario con el rol proporcionado en la solicitud
    User user = User.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(request.getRole())  // Usar el rol enviado en la solicitud
        .build();

    // Guardar el usuario en la base de datos
    userRepository.save(user);

    // Devolver el token junto con el rol del usuario
    return AuthResponse.builder()
        .token(jwtService.getToken(user))
        .role(user.getRole().name())  // Asegúrate de que también se devuelva el rol aquí
        .build();
}
}
