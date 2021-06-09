package test.back.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import test.back.domain.Box;


public interface BoxRepository extends JpaRepository<Box, Integer> {
}
