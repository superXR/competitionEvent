package cn.edu.sdu.ise.labs.service;

import cn.edu.sdu.ise.labs.dto.Competition_eventDTO;
import cn.edu.sdu.ise.labs.dto.Competition_eventQueryDTO;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.vo.Competition_eventVO;

import java.util.List;
import java.util.Map;

public interface Competition_eventService {
    Page<Competition_eventVO> listByPage(Competition_eventQueryDTO queryDTO);

    /**
     * 新建比赛
     *
     * @param competition_eventDTO 部门输入对象
     * @return 部门编码
     */
    String addCompetition_event(Competition_eventDTO competition_eventDTO);

    /**
     * 更新比赛数据
     *
     * @param competition_eventDTO 部门输入对象
     * @return 部门编码
     */
    String updateCompetition_event(Competition_eventDTO competition_eventDTO);

    /**
     * 根据编码列表，批量删除部门
     *
     * @param codeList 编码列表
     */
    void deleteByCodes(List<String> codeList);

    /**
     * 根据编码列表，获取部门集合（内部调用）
     *
     * @param codeList 部门编码列表
     * @return 包含部门信息的映射，key是部门编码
     */
    Map<String, Competition_eventVO> getCompetition_eventMap(List<String> codeList);

    /**
     * 根据部门名称\代码获取下拉列表
     *
     * @param competition_eventName 部门名称（模糊匹配）
     * @return 部门列表
     */
    List<Competition_eventVO> listByName(String competition_eventName, String competition_eventCode);
}
