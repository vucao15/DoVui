package com.example.dovui;

public class Player {
    String name;
    int point;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Player() {
    }

    public Player(String name, int point) {
        this.name = name;
        this.point = point;
    }
}
