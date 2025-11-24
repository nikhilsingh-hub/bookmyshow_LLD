package com.LLD.BookMyShow.Controllers;

import com.LLD.BookMyShow.DTOs.AdminDTO.CreateShowRequestDTO;
import com.LLD.BookMyShow.Models.Show;
import com.LLD.BookMyShow.Services.Interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/show")
    public Show createShow(@RequestBody CreateShowRequestDTO request) {
        return adminService.createShow(request);
    }
}
