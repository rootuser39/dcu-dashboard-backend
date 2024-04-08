package com.project.smart_dashboard_db.service;

import org.springframework.stereotype.Service;

import com.project.smart_dashboard_db.model.Address;
import com.project.smart_dashboard_db.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressById(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        return addressOptional.orElse(null);
    }

    public Address updateAddress(Long id, Address addressDetails) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            Address existingAddress = optionalAddress.get();
            existingAddress.setCountry(addressDetails.getCountry());
            existingAddress.setCity(addressDetails.getCity());
            existingAddress.setPostalCode(addressDetails.getPostalCode());
            existingAddress.setStreet(addressDetails.getStreet());
            return addressRepository.save(existingAddress);
        }
        return null;
    }

    public boolean deleteAddress(Long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            addressRepository.delete(optionalAddress.get());
            return true;
        }
        return false;
    }
}