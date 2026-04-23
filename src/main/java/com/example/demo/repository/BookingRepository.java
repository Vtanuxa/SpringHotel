package com.example.demo.repository;

import com.example.demo.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Найти бронирования по клиенту
    List<Booking> findByClientId(Long clientId);
    // Найти бронирования по комнате
    List<Booking> findByRoomId(Long roomId);
    List<Booking> findByStatus(String status);


    // Найти активные бронирования (текущая дата между датами заезда и выезда)
    @Query("SELECT b FROM Booking b WHERE b.checkInDate <= :date AND b.checkOutDate >= :date AND b.status = 'Подтверждено'")
    List<Booking> findActiveBookings(@Param("date")LocalDate date);
}