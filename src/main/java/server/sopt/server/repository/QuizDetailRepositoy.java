package server.sopt.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.sopt.server.domain.Quiz;
import server.sopt.server.domain.QuizDetail;

import java.util.List;

@Repository
public interface QuizDetailRepositoy extends JpaRepository<QuizDetail,Long> {
    List<QuizDetail> findByQuiz(Quiz quiz);
}
