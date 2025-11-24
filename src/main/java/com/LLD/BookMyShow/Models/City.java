package com.LLD.BookMyShow.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class City extends BaseClass{
    private String name;
    private String pinCode;
}
