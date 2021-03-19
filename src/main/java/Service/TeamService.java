package Service;

import Domain.Team;
import Repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team getTeam(Integer id) {
        return teamRepository.getOne(id);
    }

    public Team findTeam(Integer id) {
        return teamRepository.findById(id).get();
    }
}
