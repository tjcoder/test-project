package kg.javarush.first.repositories;

import kg.javarush.first.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Integer>
{
    Page<User> findByNameContaining(String name, Pageable pageable);
}
