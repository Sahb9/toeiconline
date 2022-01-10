package vn.myclass.core.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "roleid")
    private Integer roleId;
    //fetchtype.eager: lấy hết toàn bộ list và role -> chậm
    //fetchtype.lazy : lấy role thui
    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
    private List<User> userList;

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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
