package com.LLD.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Seat  extends BaseClass{
    private String name;

    @ManyToOne
    private Screen screen;
}
