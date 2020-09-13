package com.qingyuan.object.VO;

import lombok.Data;

/**
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-09 19:38
 **/
@Data
public class Department {
    /**
     * 部门id
     */
    private Integer departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 组织id
     */
    private Integer organizationId;

    /**
     * 组织名称
     */
    private String organizationName;

    /**
     * 部门PC登录账号
     */
    private String departmentAccount;

    /**
     * 部门PC端登录密码
     */
    private String departmentPwd;
}
