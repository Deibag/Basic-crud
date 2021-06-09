package test.back.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import test.back.domain.Item;


public interface ItemRepository extends JpaRepository<Item, Integer> {
}
