package hello.springSecurity.domain.repository;

import hello.springSecurity.domain.dao.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private final Map<Long, Member> memberMap = new HashMap<>();
    private Long count = 0L;

    @Override
    public Long saveMember(Member member) {
        count++;
        memberMap.put(count++, member);

        return count;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.of(memberMap.get(id));
    }
}
