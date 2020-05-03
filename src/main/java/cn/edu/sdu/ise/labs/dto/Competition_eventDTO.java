package cn.edu.sdu.ise.labs.dto;

import lombok.Data;

import java.util.Date;

/**
 * 比赛管理接入口(获取详情)
 */
@Data
public class Competition_eventDTO {
    /**
     * 根据比赛编码查询
     */
    public String competitionEventCode;
    /**
     * 比赛名
     */
    public String competitionEventName;
    /**
     * 组别
     */
    private String suiteType;
    /**
     * 计划比赛开始时间
     */
    private Date planStartAt;
    /**
     * 计划比赛结束时间
     */
    private Date planEndAt;
    /**
     * 比赛状态
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新时间
     */
    private Date updatedAt;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 更新人
     */
    private String updatedBy;

}
