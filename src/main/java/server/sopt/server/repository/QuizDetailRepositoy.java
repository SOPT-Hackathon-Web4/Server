package server.sopt.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.sopt.server.domain.QuizDetail;

@Repository
public interface QuizDetailRepositoy extends JpaRepository<QuizDetail,Long> {
}
