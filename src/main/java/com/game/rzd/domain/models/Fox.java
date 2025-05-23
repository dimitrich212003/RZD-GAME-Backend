package com.game.rzd.domain.models;


import jakarta.persistence.*;


@Entity(name = "foxes")
public class Fox extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int coins;
    @Column(nullable = false)
    private String gameLevel;

    @Version
    private Long version;
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    public Fox(String name, int coins, String gameLevel, User user) {
        this.name = name;
        this.coins = coins;
        this.gameLevel = gameLevel;
        this.user = user;
    }

    public Fox() {

    }

    public String getName() {
        return name;
    }

    public int getCoins() {
        return coins;
    }

    public String getGameLevel() {
        return gameLevel;
    }

    public User getUser() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGameLevel(String gameLevel) {
        this.gameLevel = gameLevel;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}

