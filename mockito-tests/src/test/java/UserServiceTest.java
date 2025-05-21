import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository repo;

    @InjectMocks
    UserService service;

    @Captor
    ArgumentCaptor<Integer> intCaptor;

    @BeforeEach
    void setUp() {
        // Optional setup
    }

    @Test
    void testGetUsername_withInjectedMock() {
        when(repo.getUsername(2)).thenReturn("Alice");
        String result = service.getUsername(2);
        assertEquals("Alice", result);
    }

    @Test
    void testGetUsername_withHardcodedMock() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.getUsername(2)).thenReturn("Alice");
        UserService manualService = new UserService(mockRepo);
        assertEquals("Alice", manualService.getUsername(2));
    }

    @Test
    void testSaveUser_VerifyInteraction() {
        User user = new User(1, "Alice");
        service.saveUser(user);
        verify(repo).save(user);
    }

    @Test
    void testDeleteUser_withVerifyTimes() {
        service.deleteUser(1);
        verify(repo, times(1)).deleteById(1);
    }

    @Test
    void testGetAllUsers_withStubbing() {
        List<User> users = Arrays.asList(new User(1, "A"), new User(2, "B"));
        when(repo.findAll()).thenReturn(users);
        assertEquals(2, service.getAllUsers().size());
    }

    @Test
    void testNoUsers_emptyList() {
        when(repo.findAll()).thenReturn(Collections.emptyList());
        assertTrue(service.getAllUsers().isEmpty());
    }

    @Test
    void testGetUserById_optional() {
        User user = new User(1, "A");
        when(repo.findById(1)).thenReturn(Optional.of(user));
        assertEquals("A", service.getUserById(1).name());
    }

    @Test
    void testVerifyNoMoreInteractions() {
        service.deleteUser(1);
        verify(repo).deleteById(1);
        verifyNoMoreInteractions(repo);
    }

    @Test
    void testArgumentCaptor() {
        when(repo.getUsername(anyInt())).thenReturn("MockUser");
        service.getUsername(42);
        verify(repo).getUsername(intCaptor.capture());
        assertEquals(42, intCaptor.getValue());
    }

    @Test
    void testDoThrow_onVoidMethod() {
        doThrow(new RuntimeException("Error")).when(repo).deleteById(999);
        assertThrows(RuntimeException.class, () -> service.deleteUser(999));
    }

    @Test
    void testDoAnswer_customLogic() {
        when(repo.getUsername(anyInt())).thenAnswer(invocation -> {
            int id = invocation.getArgument(0);
            return "User#" + id;
        });
        assertEquals("User#10", service.getUsername(10));
    }

    @Test
    void testResetMockIsRequired() {
        // Initial stubbing
        when(repo.getUsername(2)).thenReturn("Alice");

        // Call method and verify interaction
        assertEquals("Alice", service.getUsername(2));
        verify(repo).getUsername(2);

        // Now, reset the mock to clear both stubbing and verification history
        reset(repo);

        // Without reset, the following verifyNoMoreInteractions will FAIL
        verifyNoMoreInteractions(repo); // ✅ Passes because reset cleared previous calls

        // Re-stub with a new value after reset
        when(repo.getUsername(2)).thenReturn("Bob");
        assertEquals("Bob", service.getUsername(2));

        // And verify again
        verify(repo).getUsername(2);
    }

    @Test
    void testLenientMock() {
        lenient().when(repo.getUsername(anyInt())).thenReturn("Unused");
        // does not use this stub but no exception thrown
        service.saveUser(new User(2, "X"));
    }

    // Should fail as we didnt use lenient
    @Test
    void testWithoutLenientMock() {
        when(repo.getUsername(anyInt())).thenReturn("Unused");
        // does not use this stub but no exception thrown
        service.saveUser(new User(2, "X"));
    }
}
