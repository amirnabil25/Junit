package com.example;

import org.springframework.stereotype.Service;

@Service
public class BusinessService {
    private final Repository repository;

    public BusinessService(Repository repository) {
        this.repository = repository;
    }

    public int multiply(int a, int b) {
        int output = a * b;
        repository.save(output);
        return output;
    }

    public int multiplyWithRepo(int input) {
        return input * repository.getMultiplier();
    }
}
