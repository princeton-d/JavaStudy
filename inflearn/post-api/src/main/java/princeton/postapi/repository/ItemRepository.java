package princeton.postapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import princeton.postapi.domain.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}