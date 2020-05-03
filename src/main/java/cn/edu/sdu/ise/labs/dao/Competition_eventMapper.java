package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.dto.Competition_eventQueryDTO;
import cn.edu.sdu.ise.labs.model.Competition_event;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Competition_eventMapper {
    /**
     * 根据代码列表批量删除部门
     *
     * @param codeList    代码列表
     * @param teacherCode 操作人
     * @param tenantCode  租户代码
     */
    void deleteByCodes(
            @Param("codeList") List<String> codeList,
            @Param("teacherCode") String teacherCode,
            @Param("tenantCode") String tenantCode);

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入比赛
     *
     * @param record
     * @return
     */
    int insert(Competition_event record);

    /**
     * 根据主键更新数据
     *
     * @param record
     * @return
     */

    int updateByPrimaryKey(Competition_event record);

    /**
     * 根据查询条件获取命中个数
     *
     * @param queryDTO   查询条件
     * @param tenantCode 租户代码
     * @return 命中数量
     */
    Integer count(
            @Param("queryDTO") Competition_eventQueryDTO queryDTO,
            @Param("tenantCode") String tenantCode);

    /**
     * 根据查询条件获取部门列表
     *
     * @param queryDTO   查询条件
     * @param offset     开始位置
     * @param limit      记录数量
     * @param tenantCode 租户代码
     * @return 部门列表
     */
    List<Competition_event> list(
            @Param("queryDTO") Competition_eventQueryDTO queryDTO,
            @Param("offset") Integer offset,
            @Param("limit") Integer limit,
            @Param("tenantCode") String tenantCode);

    /**
     * 根据比赛代码列表获取比赛信息列表
     *
     * @param codeList   部门代码列表
     * @param tenantCode 租户代码
     * @return 部门列表
     */
    List<Competition_event> listByCodes(
            @Param("codeList") List<String> codeList,
            @Param("tenantCode") String tenantCode);

    /**
     * 根据部门编码获取部门信息详情
     *
     * @param competition_eventCode 部门编码
     * @param tenantCode            租户代码
     * @return 门信息详情
     */
    Competition_event getByCode(
            @Param("competition_eventCode") String competition_eventCode,
            @Param("tenantCode") String tenantCode);

    /**
     * 根据部门名称查询部门列表
     *
     * @param competitionEventName 部门名称，模糊匹配
     * @param tenantCode           租户代码
     * @return 部门列表
     */
    List<Competition_event> listByName(
            @Param("competitionEventName") String competitionEventName,
            @Param("competitionEventCode") String competitionEventCode,
            @Param("tenantCode") String tenantCode);
}