package com.project.smart_dashboard_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.smart_dashboard_db.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {}