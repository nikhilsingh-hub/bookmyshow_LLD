package com.LLD.BookMyShow.Repository;

import com.LLD.BookMyShow.Models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, String> {
}
