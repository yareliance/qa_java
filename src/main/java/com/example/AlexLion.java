package com.example;

import java.util.List;

public class AlexLion extends Lion {

    private List<String> friends = List.of("Марти", "Глория", "Мелман");
    private String placeOfLiving = "Нью-Йоркский зоопарк";

    public AlexLion() throws Exception {
        super(new Feline(), "Самец");
    }

    @Override
    public int getKittens() {
        return 0; // У Алекса нет львят
    }

    public List<String> getFriends() {
        return friends;
    }

    public String getPlaceOfLiving() {
        return placeOfLiving;
    }
}