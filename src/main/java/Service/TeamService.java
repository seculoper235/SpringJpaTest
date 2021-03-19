package Service;

import Domain.Team;
import Repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service
@EnableTransactionManagement
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    /* 트랜잭션 설정 이유?
    * getOne()은 그 자체로 하나의 트랜잭션으로 묶여있다
    * 여기서 getOne()은 LAZY Loding 방식을 사용하므로, 이를 이용해 단일 객체를 뽑아올 경우 껍데기인 프록시 객체를 가져오게 된다.
    * 이미 트랜잭션이 종료된 상태인데, getter로 데이터를 가져오려고 하니 오류가 생기는 것이다.
    * 따라서 객체를 가져오고 데이터를 사용하는 과정을 하나의 트랜잭션으로 묶으면,
    * 아직 트랜잭션이 종료되지 않았으므로, getOne()은 데이터 사용을 감지하고 값을 채우게 된다.
    */
    // 하나의 트랜잭션으로 묶어서 처리
    @Transactional
   public Team getTeam(Integer id) {
        Team team = teamRepository.getOne(id);
        // team 객체에 한번 접근(프록시 객체에 데이터를 채우기 위해)
        System.out.println("팀 ID = " + team.getId() + "팀 이름 = " + team.getName() + "팀 설명 = " + team.getDescription());
        return team;
    }

    /* findById()
    * 반대로 findById()는 EAGER Loding 방식을 사용한다.
    * 따라서 처음부터 DB에 접근하여 값을 가져오기 때문에, getOne()과 같은 문제가 없다.
    * getOne()에서 오류가 생기면 findById()로 바꾸라는 것이 이 때문이다.
    */
    public Team findTeam(Integer id) {
        return teamRepository.findById(id).get();
    }
}
