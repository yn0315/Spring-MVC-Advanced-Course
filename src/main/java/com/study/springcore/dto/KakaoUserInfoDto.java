package com.study.springcore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor//모든 생성자 만드는 어노테이션
@Getter
public class KakaoUserInfoDto {
    private Long id;
    private String nickname;
    private String email;



/*
    public KakaoUserInfoDto(Long id, String nickname, String email) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
    }
 */

}
