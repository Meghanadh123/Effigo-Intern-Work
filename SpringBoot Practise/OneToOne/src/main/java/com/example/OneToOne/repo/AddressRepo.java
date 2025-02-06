package com.example.OneToOne.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OneToOne.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{

}
