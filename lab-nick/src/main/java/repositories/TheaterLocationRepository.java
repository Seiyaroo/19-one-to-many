package repositories;


import models.TheaterLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterLocationRepository extends JpaRepository<TheaterLocation, Long> {
}