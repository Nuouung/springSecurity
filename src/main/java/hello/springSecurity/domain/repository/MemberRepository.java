package hello.springSecurity.domain.repository;

import hello.springSecurity.domain.User;

import java.util.Optional;

public interface MemberRepository {

    User saveMember(User member);
    Optional<User> findById(String name);

}
