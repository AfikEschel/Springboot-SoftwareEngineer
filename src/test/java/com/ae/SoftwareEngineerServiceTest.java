// src/test/java/com/ae/SoftwareEngineerServiceTest.java
package com.ae;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SoftwareEngineerServiceTest {

    @Mock
    private SoftwareEngineerRepository repo;

    @InjectMocks
    private SoftwareEngineerService service;

    @Test
    void getAllSoftwareEngineers_returnsAll() {
        var se1 = new SoftwareEngineer(1, "Alice", "Spring");
        var se2 = new SoftwareEngineer(2, "Bob", "Qiskit");
        when(repo.findAll()).thenReturn(List.of(se1, se2));

        var result = service.getAllSoftwareEngineers();

        assertThat(result).containsExactly(se1, se2);
        verify(repo).findAll();
        verifyNoMoreInteractions(repo);
    }

    @Test
    void insertSoftwareEngineer_savesEntity() {
        var se = new SoftwareEngineer(3, "Charlie", "PostgreSQL");

        service.insertSoftwareEngineer(se);

        verify(repo).save(se);
        verifyNoMoreInteractions(repo);
    }

    @Test
    void getSoftwareEngineerById_whenMissing_throws() {
        when(repo.findById(99)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.getSoftwareEngineerById(99))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("99 not found");

        verify(repo).findById(99);
        verifyNoMoreInteractions(repo);
    }

    @Test
    void getSoftwareEngineerById_returnsEntity() {
        var se = new SoftwareEngineer(5, "Dana", "Java");
        when(repo.findById(5)).thenReturn(Optional.of(se));

        var result = service.getSoftwareEngineerById(5);

        assertThat(result).isEqualTo(se);
        verify(repo).findById(5);
        verifyNoMoreInteractions(repo);
    }
}
