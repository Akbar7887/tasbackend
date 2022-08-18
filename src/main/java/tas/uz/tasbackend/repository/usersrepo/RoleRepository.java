package tas.uz.tasbackend.repository.usersrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import tas.uz.tasbackend.models.auth.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByname(String name);
}
