package com.example.teamdirectory.model;

public class TeamMember {
    private final String name;
    private final int color;

    public TeamMember(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public String getName() { return name; }
    public int getColor() { return color; }
}
