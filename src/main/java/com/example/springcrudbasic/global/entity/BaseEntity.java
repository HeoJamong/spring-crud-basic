package com.example.springcrudbasic.global.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreated() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
