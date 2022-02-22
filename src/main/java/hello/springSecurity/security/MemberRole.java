package hello.springSecurity.security;

public enum MemberRole {

    USER("회원"), ADMIN("관리자");

    String title;

    MemberRole(String title) {
        this.title = title;
    }

}
