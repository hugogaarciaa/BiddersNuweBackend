package com.hackathon.hackathon.model;

public class Art extends Item {
    private String artist;
    private int yearCreated;

    // Constructor
    public Art(String name, double initialPrice, Bidder currentBidder, String type, String artist, int yearCreated) {
        super(name, initialPrice, currentBidder, type);
        this.artist = artist;
        this.yearCreated = yearCreated;
    }

    // Getters and setters
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }
}
