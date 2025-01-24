package com.security.demo.entity;

public class JwtResponse {
    private String jwtToken;
    private String username;

    // Default (no-args) constructor
    public JwtResponse() {
    }

    // All-args constructor
    public JwtResponse(String jwtToken, String username) {
        this.jwtToken = jwtToken;
        this.username = username;
    }

    // Copy constructor (if needed)
    public JwtResponse(JwtResponse jwtResponse) {
        this.jwtToken = jwtResponse.jwtToken;
        this.username = jwtResponse.username;
    }

    // Getters
    public String getJwtToken() {
        return jwtToken;
    }

    public String getUsername() {
        return username;
    }

    // Setters
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Builder Pattern Implementation
    public static class Builder {
        private String jwtToken;
        private String username;

        // Setter method for jwtToken in the builder
        public Builder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        // Setter method for username in the builder
        public Builder username(String username) {
            this.username = username;
            return this;
        }

        // Build method to create a JwtResponse object
        public JwtResponse build() {
            return new JwtResponse(this.jwtToken, this.username);
        }
    }

    @Override
    public String toString() {
        return "JwtResponse{" +
                "jwtToken='" + jwtToken + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
