package hu.meiit.haladojava;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @Mock
    UserService userService;
    @Mock
    Validator validatorAccept;
    @Mock
    Validator validatorDeny;

    List<Validator> validatorList = new ArrayList<>();

    UserController userController;

    @Before
    public void before(){
        validatorList.clear();
       // when(validatorAccept.isValid(anyString())).thenReturn(true);
       // when(validatorDeny.isValid(anyString())).thenReturn(false);
        userController = new UserController(userService,validatorList);

    }

    @Test
    void createWhenAllValidatorAccept() {
        when(validatorAccept.isValid(anyString())).thenReturn(true);
        Integer newId = 5;
        when(userService.create(anyString())).thenReturn(newId);
        validatorList.add(validatorAccept);
        String userName = "hello";
        int Id = userController.create("hello");
        verify(validatorAccept,times(1)).isValid(eq(userName));
        verify(userService,times(1)).create(eq(userName));
        assertEquals((long)newId, Id);
    }

    @Test
   public void getAll() {
    }
}