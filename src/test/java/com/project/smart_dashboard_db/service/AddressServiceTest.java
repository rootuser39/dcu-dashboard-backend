package com.project.smart_dashboard_db.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.smart_dashboard_db.model.Address;
import com.project.smart_dashboard_db.repository.AddressRepository;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    @Test
    void testGetAllAddresses() {
        // Create mock addresses
        List<Address> mockAddresses = Arrays.asList(new Address(), new Address());
        // Mock the behavior of addressRepository.findAll()
        when(addressRepository.findAll()).thenReturn(mockAddresses);

        // Call the service method
        List<Address> result = addressService.getAllAddresses();

        // Verify the result
        assertEquals(mockAddresses, result);
    }

    @Test
    void testCreateAddress() {
        // Create a mock address
        Address mockAddress = new Address();
        // Mock the behavior of addressRepository.save()
        when(addressRepository.save(mockAddress)).thenReturn(mockAddress);

        // Call the service method
        Address result = addressService.createAddress(mockAddress);

        // Verify the result
        assertEquals(mockAddress, result);
    }

    // Add tests for other methods (getAddressById, updateAddress, deleteAddress) similarly
}
