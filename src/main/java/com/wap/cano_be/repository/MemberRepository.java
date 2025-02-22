package com.wap.cano_be.repository;

import com.wap.cano_be.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member m where m.email = :email")
    Optional<Member> findByEmail(@Param("email") String email);

    @Query("select m from Member m where m.socialId = :socialId")
    Optional<Member> findBySocialId(@Param("socialId") long socialId);

    Optional<Member> findByName(String name);
}
