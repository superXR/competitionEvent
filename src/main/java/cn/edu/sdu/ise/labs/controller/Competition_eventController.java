package cn.edu.sdu.ise.labs.controller;

import cn.edu.sdu.ise.labs.dto.Competition_eventDTO;
import cn.edu.sdu.ise.labs.dto.Competition_eventQueryDTO;
import cn.edu.sdu.ise.labs.model.ResultContext;
import cn.edu.sdu.ise.labs.service.Competition_eventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 比赛管理后端服务
 */

@RestController
@RequestMapping("competition_event")
public class Competition_eventController {
    @Autowired
    private Competition_eventService competition_eventService;

    /**
     * 增加
     *
     * @param competition_eventDTO
     * @return
     */
    @PostMapping("add")
    public ResultContext add(@RequestBody Competition_eventDTO competition_eventDTO) {
        return ResultContext.returnSuccess(competition_eventService.addCompetition_event(competition_eventDTO));
    }

    /**
     * 更新
     *
     * @param competition_eventDTO
     * @return
     */

    @PostMapping("update")
    public ResultContext update(@RequestBody Competition_eventDTO competition_eventDTO) {
        return ResultContext.returnSuccess(competition_eventService.updateCompetition_event(competition_eventDTO));
    }

    /**
     * 获取列表
     *
     * @param queryDTO
     * @return
     */
    @PostMapping("list")
    public ResultContext list(@RequestBody Competition_eventQueryDTO queryDTO) {
        return ResultContext.returnSuccess(competition_eventService.listByPage(queryDTO));
    }

    /**
     * 删除
     *
     * @param codelist
     * @return
     */
    @PostMapping("delete")
    public ResultContext delete(@RequestBody List<String> codelist) {
        competition_eventService.deleteByCodes(codelist);
        return ResultContext.returnSuccess(true);
    }

    @GetMapping("listByName")
    public ResultContext listByName(String competitionEventName, String competitionEventCode) {
        return ResultContext.returnSuccess(competition_eventService.listByName(competitionEventName, competitionEventCode));
    }
}
