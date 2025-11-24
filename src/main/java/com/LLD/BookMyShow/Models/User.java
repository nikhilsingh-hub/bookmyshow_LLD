package com.LLD.BookMyShow.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class User  extends BaseClass{
    private String name;
    private String email;
    private String mobile;
}
