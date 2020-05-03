package cn.edu.sdu.ise.labs.dto;

import lombok.Data;

@Data
public class Competition_eventQueryDTO {
    /**
     * 名字
     */
    private String competitionEventName;
    /**
     * 代码
     */
    private String competitionEventCode;
    /**
     * 页码
     */
    private Integer page;

    /**
     * 每页记录数
     */
    private Integer pageSize;

}
