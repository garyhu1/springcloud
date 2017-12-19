package com.garyhu.repository;

import org.springframework.stereotype.Repository;

import com.garyhu.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
