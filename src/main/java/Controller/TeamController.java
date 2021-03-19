package Controller;

import Domain.Team;
import Service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/getteam/{id}")
    public ModelAndView getTeamById(@PathVariable Integer id) {
        Team team = teamService.getTeam(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("team", team);
        mav.setViewName("test");
        return mav;
    }

    @GetMapping("/findteam/{id}")
    public ModelAndView findTeamById(@PathVariable Integer id) {
        Team team = teamService.findTeam(id);
        System.out.println("id = " + team.getId() + "name = " + team.getName() + "description = " + team.getDescription());
        ModelAndView mav = new ModelAndView();
        mav.addObject("team", team);
        mav.setViewName("test");
        return mav;
    }
}
