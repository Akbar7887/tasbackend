package tas.uz.tasbackend.repository.usersrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import tas.uz.tasbackend.models.auth.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
