package Controller;

import Domain.Team;
import Service.TeamService;
import org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/getteam/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Integer id) {

        Team team = teamService.getTeam(id);
        return ResponseEntity.ok(team);
    }

    @GetMapping("/findteam/{id}")
    public ModelAndView findTeamById(@PathVariable Integer id) {
        Team team = teamService.findTeam(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("team", team);
        mav.setViewName("test");
        return mav;
    }
}
