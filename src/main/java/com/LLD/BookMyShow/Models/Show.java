package com.LLD.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity(name = "shows")
public class Show extends BaseClass{
    @ManyToOne
    private Movie movie;

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats;

    @Enumerated
    @ElementCollection
    private List<QualitySupportType> qualitySupportTypes;

    @ManyToOne
    private  Screen screen;
    private Date startTime;
    private Date endTime;
}
