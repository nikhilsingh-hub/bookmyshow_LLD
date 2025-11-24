package com.LLD.BookMyShow.DTOs.AdminDTO;

import com.LLD.BookMyShow.DTOs.ResponseType;
import com.LLD.BookMyShow.Models.Show;
import lombok.Data;

@Data
public class CreateShowResponseDTO {
    private Show show;
    private ResponseType responseType;
}
