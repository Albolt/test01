package com.personal.test01.test001;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Creater albolt
 * @2020/2/24 下午4:04
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleTreeDTO implements Comparable<RoleTreeDTO> {

    private Long id;

    private String roleName;

    private Long parentId;

    private List<RoleTreeDTO> children=new ArrayList<>();

    public RoleTreeDTO(SysRole role) {
        this.id = role.getId();
        this.roleName = role.getRoleName();
        this.parentId = role.getParentId();
    }

    @Override
    public int compareTo(RoleTreeDTO dto) {
        if (this.getId()==null || dto.getId()==null) {
            return 0;
        }
        if (this.getId()>dto.getId()) {
            return 1;
        } else if (this.getId()< dto.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}
