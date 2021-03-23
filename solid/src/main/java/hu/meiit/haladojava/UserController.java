package hu.meiit.haladojava;

import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final List<hu.meiit.haladojava.Validator> validatorList;

   public int create(String name){
       if (validateName(name)) {
           return userService.create(name);
       }
       return -1;

    }

    private boolean validateName(String name) {
        for (Validator validator : validatorList){
            if(!validator.isValid(name)){
                  return false;
            }
        }
        return true;
    }

    public Collection<UserDetailsDto> getAll(){
        return userService.getAll();
    }
}
