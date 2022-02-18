package com.personal.test01.test001;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类名:SysRole
 * 创建人:weipenghuang
 * 创建时间:2018年09月17日 15:01:00
 */
@Data
@NoArgsConstructor
public class SysRole {
    /****/
    private Long id;
    /**角色名称**/
    private String roleName;
    /**是否启用，0：启用，1：禁用，默认是0**/
    private Integer enable;
    /**角色描述**/
    private String description;

    private Long parentId;

    public SysRole(Long id, Integer enable) {
        this.id = id;
        this.enable = enable;
    }
}