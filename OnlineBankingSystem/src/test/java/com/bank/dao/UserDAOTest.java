package com.bank.dao;

import com.bank.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private UserDAO userDAO;

    @BeforeEach
    void setUp() {
        userDAO = mock(UserDAO.class); // Mocking the DAO
    }

    @Test
    void testGetUserById() throws Exception {
        User mockUser = new User(1, "john_doe", "hashed_password", "john@example.com");
        when(userDAO.getUserById(1)).thenReturn(mockUser);

        User user = userDAO.getUserById(1);
        assertNotNull(user, "User should not be null");
        assertEquals("john_doe", user.getUsername(), "Username should match");
    }

    @Test
    void testUpdateProfile() throws Exception {
        when(userDAO.updateProfile(1, "new_email@example.com", "New Name")).thenReturn(true);

        boolean result = userDAO.updateProfile(1, "new_email@example.com", "New Name");
        assertTrue(result, "Profile update should succeed");
    }
}
