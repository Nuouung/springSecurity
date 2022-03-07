package hello.springSecurity.domain.repository;

import hello.springSecurity.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private final Map<Long, User> memberMap = new HashMap<>();
    private final Map<String, Long> memberIdMap = new HashMap<>();
    private Long count = 0L;

    @Override
    public User saveMember(User member) {
        count++;
        memberMap.put(count++, member);

        return member;
    }

    @Override
    public Optional<User> findById(String name) {
        Optional<Long> memberId = findMemberId(name);
        return memberId.map(memberMap::get);
    }

    private Optional<Long> findMemberId(String name) {
        return Optional.ofNullable(memberIdMap.get(name));
    }
}
