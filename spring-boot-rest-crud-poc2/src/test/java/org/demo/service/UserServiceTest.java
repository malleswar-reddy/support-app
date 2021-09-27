package org.demo.service;

import org.demo.entity.User;
import org.demo.repository.UserRepository;
import org.demo.util.UserUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void findAllTest() throws Exception {
        when(userRepository.findAll()).thenReturn(Arrays.asList(UserUtil.getUser()));
        List<User> users = userService.findAll();
        assertEquals(1, users.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void TestFindById() throws Exception {
        when(userRepository.findById(101)).thenReturn(Optional.of(UserUtil.getUser()));
        Optional<User> optionalUser = userService.findById(101);
        assertEquals(101, optionalUser.map(User::getUserId).orElse(null));
    }

    @Test
    public void TestSave() throws Exception {
        when(userRepository.save(any())).thenReturn(UserUtil.getUser());
        final User user = userService.save(UserUtil.getUser());
        assertEquals(101, user.getUserId());
        assertEquals(user,UserUtil.getUser());
    }

    @Test
    public void TestfindByUserName() throws Exception {
        when(userRepository.findAllByUserName("subbu")).thenReturn(Arrays.asList(UserUtil.getUser()));
        final List<User> subbus = userService.findByUserName("subbu");
        assertEquals(1,subbus.size());
    }

    @Test
    public void TestFindAllSortByBirthDate() throws Exception {
        when(userRepository.findAll(any(Sort.class))).thenReturn(UserUtil.getUserList());
        final List<User> allSortByBirthDate = userService.findAllSortByBirthDate();
        assertEquals(2,allSortByBirthDate.size());
        assertEquals(UserUtil.getCurrentDate(),allSortByBirthDate.get(0).getUserBirthDate());
    }

}
