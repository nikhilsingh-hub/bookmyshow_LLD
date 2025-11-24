package com.LLD.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Theatre extends BaseClass{
    private String name;

    @OneToMany(mappedBy = "theatre")
    private List<Screen> screens;

    @ManyToOne
    private City city;
}
