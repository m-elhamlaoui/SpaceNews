package com.Spacenews.app;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCrRepository extends JpaRepository<BlogCrModel, Long> {
}