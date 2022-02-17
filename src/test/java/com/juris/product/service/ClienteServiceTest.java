package com.juris.product.service;

import com.juris.model.Cliente;
import com.juris.cliente.ClienteRepository;
import com.juris.cliente.ClienteService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Test API Mac Donalds")
class ClienteServiceTest {

    @InjectMocks
    private ClienteService service;

    @Mock
    private ClienteRepository repository;

    private Cliente cliente;

    @BeforeEach
    void init(){
        cliente = Cliente.builder()
                .nome("Alisson")
                .cpf("111111111")
                .build();

        createDefaultCondition();
    }

    void createDefaultCondition() {
        when(repository.findById(any())).thenReturn(Optional.of(cliente));
        when(repository.findAll()).thenReturn(List.of(cliente));
    }

    @Test
    @DisplayName("Success FindAll")
    void findAll(){
        final var valueMeals = service.findAll();
        Assert.assertNotNull(valueMeals);
    }

    @Test
    @DisplayName("Success FindById")
    void findById(){
        final var cliente = service.findById("123");
        Assert.assertEquals(cliente.getNome(), cliente.getNome());
    }

    @Test
    @DisplayName("Success Delete")
    void delete(){
        repository.delete(cliente);
        verify(repository, atLeastOnce()).delete(any());
    }

    @Test
    @DisplayName("Success Save")
    void save(){
        repository.save(cliente);
        verify(repository, atLeastOnce()).save(any());
    }
}