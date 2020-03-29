package com.forezp.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="user")
public class User {    
    @Id
//    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@NotBlank
    @Column(name="login_name")
    private  String loginName;

	@NotBlank
    @Column(name="login_password")
    private  String loginPassword;

	@NotBlank
    @Column(name="role_name")
    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}