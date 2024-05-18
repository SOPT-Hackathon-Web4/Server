package server.sopt.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.sopt.server.domain.Member;
import server.sopt.server.domain.Quiz;



@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Quiz findByMemberId(Long memberId);
}
