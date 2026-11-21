package kz.baizhik.menuservice.repositories;

import kz.baizhik.menuservice.model.entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
