package tas.uz.tasbackend.service.usersservice;

import tas.uz.tasbackend.models.auth.AppUser;
import tas.uz.tasbackend.models.auth.Role;


import java.util.List;

public interface UserService {

    AppUser saveUser(AppUser user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String rolename);

    AppUser getUser(String username);

    List<AppUser> getUser();


}
