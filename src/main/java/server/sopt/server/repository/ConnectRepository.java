package server.sopt.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.sopt.server.domain.Connect;
import server.sopt.server.domain.Member;

public interface ConnectRepository extends JpaRepository<Connect, Long> {
}
