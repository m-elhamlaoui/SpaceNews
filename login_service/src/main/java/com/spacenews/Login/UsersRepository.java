package com.SpaceNews.Login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<UsersModel, Integer>{
    Optional<UsersModel>  findByLoginAndPassword(String login, String password);
}