package hu.meiit.haladojava;

import java.util.Collection;

public interface UserService {

    int create(String name);

    Collection<UserDetailsDto> getAll();
}
