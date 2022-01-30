package vn.myclass.core.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @Column(name = "roleid")
    private Integer roleId;

    @Column(name = "name")
    private String name;
    //fetchtype.eager: lấy hết toàn bộ list và role -> chậm
    //fetchtype.lazy : lấy role thui
    @OneToMany(mappedBy = "roleEntity",fetch = FetchType.LAZY)
    private List<UserEntity> userEntityList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<UserEntity> getUserList() {
        return userEntityList;
    }

    public void setUserList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }
}
