package hello.springSecurity.domain.dao;

import hello.springSecurity.security.MemberRole;

import java.util.HashSet;
import java.util.Set;

public class Member {

    private Long id;

    private String username;
    private String password;

    private Set<MemberRole> roles = new HashSet<>();

    public void addMemberRole(MemberRole memberRole) {
        roles.add(memberRole);
    }

}
