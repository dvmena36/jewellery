package jewellry.repo;

import jewellry.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    Item findByTitle(String title);
    List<Item> findAByCategory(String category);
}
