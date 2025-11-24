package com.LLD.BookMyShow.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Screen extends BaseClass{
    private String name;

    @OneToMany(mappedBy = "screen")
    private List<Show> shows;

    @Enumerated
    @ElementCollection
    private List<QualitySupportType> qualitySupportTypes;

    @ManyToOne
    private Theatre theatre;
}
