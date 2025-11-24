package com.LLD.BookMyShow.Services.Interfaces;

import com.LLD.BookMyShow.DTOs.AdminDTO.CreateShowRequestDTO;
import com.LLD.BookMyShow.Models.Show;

public interface AdminService {
    public Show createShow(CreateShowRequestDTO request);
}
