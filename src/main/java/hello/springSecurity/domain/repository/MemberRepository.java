package hello.springSecurity.domain.repository;

import hello.springSecurity.domain.dao.Member;

import java.util.Optional;

public interface MemberRepository {

    Long saveMember(Member member);
    Optional<Member> findById(Long id);

}
