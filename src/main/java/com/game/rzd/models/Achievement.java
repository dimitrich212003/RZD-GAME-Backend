package com.game.rzd.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "achievements")
public class Achievement extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private boolean unlocked;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Achievement(String name, boolean unlocked, User user) {
        this.name = name;
        this.unlocked = unlocked;
        this.user = user;
    }

    public Achievement() {

    }

    public String getName() {
        return name;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public User getUser() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

