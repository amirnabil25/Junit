package com.example;

@org.springframework.stereotype.Repository
public class Repository {
    public int getMultiplier() {
        return 2;
    }

    public int save(int input) {
        return 1;  //as if I am saving and this is the number of rows updated
    }
}
