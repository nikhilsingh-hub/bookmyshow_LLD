package com.LLD.BookMyShow.Services.Implementations;

import com.LLD.BookMyShow.DTOs.AdminDTO.CreateShowRequestDTO;
import com.LLD.BookMyShow.Models.*;
import com.LLD.BookMyShow.Repository.*;
import com.LLD.BookMyShow.Services.Interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Override
    public Show createShow(CreateShowRequestDTO request) {
        // 1. Validate movieId and screenId
        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new RuntimeException("Invalid Movie ID"));

        Screen screen = screenRepository.findById(request.getScreenId())
                .orElseThrow(() -> new RuntimeException("Invalid Screen ID"));

        // 2. Create Show entity
        Show show = new Show();
        show.setMovie(movie);
        show.setScreen(screen);
        show.setStartTime(request.getStartTime());
        show.setEndTime(request.getEndTime());

        Show savedShow = showRepository.save(show);


        // List<Seat> seats = seatRepository.findAll().stream().filter(s -> s.getScreen().getId().equals(screen.getId())).collect(Collectors.toList());

        List<Seat> seats = seatRepository.findAll().stream()
                .filter(seat -> seat.getScreen().getId().equals(screen.getId()))
                .collect(Collectors.toList());

        // 4. Create ShowSeat for each Seat
        List<ShowSeat> showSeats = seats.stream().map(seat -> {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeat(seat);
            showSeat.setShow(savedShow);
            showSeat.setSeatStatus(SeatStatus.AVAILABLE);
            showSeat.setShowSeatType(ShowSeatType.DELUXE); // Defaulting to DELUXE as per plan
            return showSeat;
        }).collect(Collectors.toList());

        // 5. Save ShowSeats
        List<ShowSeat> savedShowSeats = showSeatRepository.saveAll(showSeats);

        // 6. Update Show with ShowSeats
        savedShow.setShowSeats(savedShowSeats);
        return showRepository.save(savedShow);
    }
}
