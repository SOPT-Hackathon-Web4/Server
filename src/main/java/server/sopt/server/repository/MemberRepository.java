package server.sopt.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.sopt.server.domain.Member;
import server.sopt.server.domain.Scrap;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>,MemberRepositoryCustom {

    Member findMemberByInstaId(String instagram);
    Member findMemberById(Long memberId);

}
