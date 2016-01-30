package kg.javarush.first.services;

import kg.javarush.first.model.User;
import kg.javarush.first.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> listAllUsers(int page, int size, String query)
    {
        if (page == 0)
            page = 1;

        return findByUsername(query, new PageRequest(page - 1, size));
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveUser(User user) {
        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }

    private Page<User> findByUsername(String name, Pageable pageable)
    {
        return userRepository.findByNameContaining(name, pageable);
    }
}