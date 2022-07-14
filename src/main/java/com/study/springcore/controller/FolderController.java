package com.study.springcore.controller;

import com.study.springcore.dto.FolderRequestDto;
import com.study.springcore.model.Folder;
import com.study.springcore.model.Users;
import com.study.springcore.security.UserDetailsImpl;
import com.study.springcore.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FolderController {
    private final FolderService folderService;

    @Autowired
    public FolderController(FolderService folderService){
        this.folderService = folderService;
    }
    @PostMapping("api/folders")
    public List<Folder> addFolders(@RequestBody FolderRequestDto folderRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<String> folderNames = folderRequestDto.getFolderNames();
        Users user = userDetails.getUser();
        List<Folder> folders = folderService.addFolders(folderNames, user);
        return folders;
    }

}
