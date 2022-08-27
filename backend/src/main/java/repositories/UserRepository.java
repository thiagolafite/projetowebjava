package repositories;

import entities.User;

public interface UserRepository {

	User findByEmail(String email);



	User saveAndFlush(User user);

}
