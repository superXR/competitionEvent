package cn.edu.sdu.ise.labs.service.utils;

import cn.edu.sdu.ise.labs.dto.Competition_eventDTO;
import cn.edu.sdu.ise.labs.model.Competition_event;
import cn.edu.sdu.ise.labs.utils.FormatUtils;
import cn.edu.sdu.ise.labs.vo.Competition_eventVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

public class Competition_eventUtils {
    public static void validateCompetition_event(Competition_eventDTO competition_eventDTO) {
        FormatUtils.trimFieldToNull(competition_eventDTO);
        Assert.notNull(competition_eventDTO, "项目输入数据不能为空");
        Assert.hasText(competition_eventDTO.getCompetitionEventName(), "项目名称不能为空");
    }

    /**
     * 将实体对象转换为VO对象
     *
     * @param competition_event 实体对象
     * @return VO对象
     */
    public static Competition_eventVO convertToVO(Competition_event competition_event) {
        Competition_eventVO competition_eventVO = new Competition_eventVO();
        //获取输出属性
        BeanUtils.copyProperties(competition_event, competition_eventVO);
        //盖时间戳
        competition_eventVO.setCreatedAt(FormatUtils.formatFullDate(competition_event.getCreatedAt()));
        competition_eventVO.setUpdatedAt(FormatUtils.formatFullDate(competition_event.getUpdatedAt()));
        return competition_eventVO;
    }
}
