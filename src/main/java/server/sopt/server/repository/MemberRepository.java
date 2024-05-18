package server.sopt.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.sopt.server.domain.Member;
import server.sopt.server.domain.Scrap;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>,MemberRepositoryCustom {
//    @Query("SELECT c FROM Customer c WHERE c.id IN :customerIds")
//    List<Member> findAllByIds(@Param("customerIds") List<Long> customerIds);
    Optional<Member> findMemberByInstaId(String instagram);

    Member findMemberById(Long memberId);
//    Member findMemberBy
//    List<Member> findAllById

}
