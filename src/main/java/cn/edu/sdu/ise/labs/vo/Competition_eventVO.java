package cn.edu.sdu.ise.labs.vo;

import lombok.Data;

import java.util.Date;

@Data
public class Competition_eventVO {
    /**
     * 比赛项目编码
     */
    private String competitionEventCode;
    /**
     * 比赛项目名称
     */
    private String competitionEventName;
    /**
     * 计划开始时间
     */
    private Date planStartAt;
    /**
     * 结束时间
     */
    private Date planEndAt;
    /**
     * 组别
     */
    private String suiteType;
    /**
     * 状态
     */
    private String status;
    /**
     * 创建时间
     */
    private String createdAt;
    /**
     * 更新时间
     */
    private String updatedAt;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 更新人
     */
    private String updatedBy;
}
