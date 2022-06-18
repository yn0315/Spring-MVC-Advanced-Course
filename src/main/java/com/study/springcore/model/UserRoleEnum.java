package com.study.springcore.model;

public enum UserRoleEnum {
    USER(Authority.USER), // 사용자 권한
    ADMIN(Authority.ADMIN); // 관리자 권한
    private final String authority;

    UserRoleEnum(String authority) {
        this.authority = authority;
    }

    //위에 final로 설정된 authority를 사용해서 사용자 권한 가져오는 메서드
    public String getAuthority() {
        return this.authority;
    }

    /*
    private static final String PREFIX_ROLE = "ROLE_";

    public String getAuthority() {
        return PREFIX_ROLE + USER;
    }
     */

    //ProductController의 메서드 매개변수에서 주석처리된 getAuthority를 가져오지 못함(static이 아니라)
    //밑에처럼 써서 ProductController의 매개변수로 써야함
    public static class Authority{
        public static final String USER = "ROLE_USER";
        public static final String ADMIN = "ROLE_ADMIN";
    }
}