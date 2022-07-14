package com.study.springcore.repository;

import com.study.springcore.model.Folder;
import com.study.springcore.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    List<Folder> findAllByUser(Users user);
}
