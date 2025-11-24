package com.LLD.BookMyShow.DTOs.AdminDTO;

import lombok.Data;

import java.util.Date;

@Data
public class CreateShowRequestDTO {
    private String movieId;
    private String screenId;
    private Date startTime;
    private Date endTime;
}
