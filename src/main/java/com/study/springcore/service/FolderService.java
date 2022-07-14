package com.study.springcore.service;

import com.study.springcore.model.Folder;
import com.study.springcore.model.Users;
import com.study.springcore.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FolderService {

    private final FolderRepository folderRepository;

    @Autowired
    public FolderService(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    // 로그인한 회원에 폴더들 등록
    public List<Folder> addFolders(List<String> folderNames, Users user) {
        List<Folder> folderList = new ArrayList<>();

        for (String folderName : folderNames) {
            Folder folder = new Folder(folderName, user);
            folderList.add(folder);
        }

        return folderRepository.saveAll(folderList);
    }

    // 로그인한 회원이 등록된 모든 폴더 조회
    public List<Folder> getFolders(Users user) {
        return folderRepository.findAllByUser(user);
    }
}
