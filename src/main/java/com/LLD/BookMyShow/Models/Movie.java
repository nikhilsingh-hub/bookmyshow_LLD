package com.LLD.BookMyShow.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Movie extends BaseClass{
    private String name;
    private String language;
    private int duration;
    private double rating;
}
