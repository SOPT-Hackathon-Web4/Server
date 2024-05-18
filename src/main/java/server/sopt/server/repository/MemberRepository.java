package server.sopt.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.sopt.server.domain.Member;
import server.sopt.server.domain.Scrap;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>,MemberRepositoryCustom {
//    @Query("SELECT c FROM Customer c WHERE c.id IN :customerIds")
//    List<Member> findAllByIds(@Param("customerIds") List<Long> customerIds);
    Member findMemberByInstaId(String instagram);
    Member findMemberById(Long memberId);
//    Member findMemberBy
//    List<Member> findAllById
}
