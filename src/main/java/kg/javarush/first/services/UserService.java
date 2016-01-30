package kg.javarush.first.services;

import kg.javarush.first.model.User;
import org.springframework.data.domain.Page;

public interface UserService {

    Page<User> listAllUsers(int page, int size, String query);

    User getUserById(Integer id);

    User saveUser(User user);

    void deleteUser(Integer id);
}
