package cn.edu.sdu.ise.labs.service.impl;

import cn.edu.sdu.ise.labs.constant.PrefixConstant;
import cn.edu.sdu.ise.labs.dao.Competition_eventMapper;
import cn.edu.sdu.ise.labs.dto.Competition_eventDTO;
import cn.edu.sdu.ise.labs.dto.Competition_eventQueryDTO;
import cn.edu.sdu.ise.labs.model.Competition_event;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.model.Token;
import cn.edu.sdu.ise.labs.service.Competition_eventService;
import cn.edu.sdu.ise.labs.service.KeyMaxValueService;
import cn.edu.sdu.ise.labs.service.utils.Competition_eventUtils;
import cn.edu.sdu.ise.labs.utils.FormatUtils;
import cn.edu.sdu.ise.labs.utils.PageUtils;
import cn.edu.sdu.ise.labs.utils.TokenContextHolder;
import cn.edu.sdu.ise.labs.vo.Competition_eventVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class Competition_eventServiceImpl implements Competition_eventService {
    @Autowired
    private Competition_eventMapper competition_eventMapper;

    @Autowired
    private KeyMaxValueService keyMaxValueService;

    @Override
    /**
     * 分页查询
     */
    public Page<Competition_eventVO> listByPage(Competition_eventQueryDTO queryDTO) {
        if (queryDTO == null) {
            queryDTO = new Competition_eventQueryDTO();
        }

        queryDTO.setCompetitionEventName(FormatUtils.makeFuzzySearchTerm(queryDTO.getCompetitionEventName()));
        queryDTO.setCompetitionEventCode(FormatUtils.makeFuzzySearchTerm(queryDTO.getCompetitionEventCode()));
        Token token = TokenContextHolder.getToken();

        Integer size = competition_eventMapper.count(queryDTO, token.getTenantCode());
        PageUtils pageUtils = new PageUtils(queryDTO.getPage(), queryDTO.getPageSize(), size);
        Page<Competition_eventVO> pageData = new Page<>(pageUtils.getPage(), pageUtils.getPageSize(), pageUtils.getTotal(), new ArrayList<>());
        if (size == 0) {
            // 没有命中，则返回空数据。
            return pageData;
        }

        List<Competition_event> list = competition_eventMapper.list(queryDTO, pageUtils.getOffset(), pageUtils.getLimit(), token.getTenantCode());
        for (Competition_event competition_event : list) {
            pageData.getList().add(Competition_eventUtils.convertToVO(competition_event));
        }

        return pageData;
    }


    /**
     * 新建比赛项目
     *
     * @param competition_eventDTO 项目输入对象
     * @return 部门编码
     */
    @Override
    public String addCompetition_event(Competition_eventDTO competition_eventDTO) {
        // 校验输入数据正确性
        Competition_eventUtils.validateCompetition_event(competition_eventDTO);
        // 创建实体对象，用以保存到数据库
        Competition_event competition_event = new Competition_event();
        // 将输入的字段全部复制到实体对象中
        BeanUtils.copyProperties(competition_eventDTO, competition_event);
        // 生成业务代码
        competition_event.setCompetitionEventCode(keyMaxValueService.generateBusinessCode(PrefixConstant.COMPETITIONEVENT));
        // 将token相关信息填入ce对象
        TokenContextHolder.formatInsert(competition_event);
        // 调用DAO方法保存到数据库表
        competition_eventMapper.insert(competition_event);
        return competition_event.getCompetitionEventCode();
    }

    /**
     * 更新部门数据
     *
     * @param competition_eventDTO 部门输入对象
     * @return 部门编码
     */
    @Override
    public String updateCompetition_event(Competition_eventDTO competition_eventDTO) {
        Token token = TokenContextHolder.getToken();
        Competition_eventUtils.validateCompetition_event(competition_eventDTO);
        Assert.hasText(competition_eventDTO.getCompetitionEventCode(), "比赛代码不能为空");
        Competition_event competition_event = competition_eventMapper.getByCode(competition_eventDTO.getCompetitionEventCode(), token.getTenantCode());
        Assert.notNull(competition_event, "为找到比赛，代码为：" + competition_eventDTO.getCompetitionEventCode());

        BeanUtils.copyProperties(competition_eventDTO, competition_event);
        competition_event.setUpdatedBy(token.getTenantCode());
        competition_eventMapper.updateByPrimaryKey(competition_event);
        return competition_event.getCompetitionEventCode();
    }

    /**
     * 根据编码列表，获取部门集合（内部调用）
     *
     * @param codeList 部门编码列表
     * @return 包含部门信息的映射，key是部门编码
     */
    @Override
    public Map<String, Competition_eventVO> getCompetition_eventMap(List<String> codeList) {
        if (CollectionUtils.isEmpty(codeList)) {
            return new HashMap<>(1 << 2);
        }

        Token token = TokenContextHolder.getToken();
        List<Competition_event> departmentList = competition_eventMapper.listByCodes(codeList, token.getTenantCode());
        return departmentList.stream()
                .map(item -> Competition_eventUtils.convertToVO(item))
                .collect(Collectors.toMap(Competition_eventVO::getCompetitionEventCode, Function.identity()));
    }

    /**
     * 根据部门名称获取下拉列表
     *
     * @param competitionEventName 项目名称（模糊匹配）
     * @return 部门列表
     */
    @Override
    public List<Competition_eventVO> listByName(String competitionEventName, String competitionEventCode) {
        //获取租户代码
        Token token = TokenContextHolder.getToken();
        //模糊匹配项目名称
        competitionEventName = FormatUtils.makeFuzzySearchTerm(competitionEventName);
        competitionEventCode = FormatUtils.makeFuzzySearchTerm(competitionEventCode);
        //从数据库中获得数据
        List<Competition_event> competition_eventsList = competition_eventMapper.listByName(competitionEventName, competitionEventCode, token.getTenantCode());
        return competition_eventsList.stream()
                .map(item -> Competition_eventUtils.convertToVO(item))
                .collect(toList());
    }

    /**
     * 根据编码列表，批量删除部门
     *
     * @param codeList 编码列表
     */
    @Override
    public void deleteByCodes(List<String> codeList) {
        Assert.notEmpty(codeList, "比赛编码列表不能为空");
        Token token = TokenContextHolder.getToken();
        competition_eventMapper.deleteByCodes(codeList, token.getTeacherCode(), token.getTenantCode());
    }
}