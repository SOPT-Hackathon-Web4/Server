package server.sopt.server.service.Connect;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.sopt.server.domain.Connect;
import server.sopt.server.repository.ConnectRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ConnectService {
    private final ConnectRepository connectRepository;
    public void saveConnect(Long challengeMemberId,Long targetId){

        connectRepository.save(Connect.create(challengeMemberId,targetId));
    }
}
