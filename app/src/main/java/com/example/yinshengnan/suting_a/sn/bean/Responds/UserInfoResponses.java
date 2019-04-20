package com.example.yinshengnan.suting_a.sn.bean.Responds;

import java.util.List;

/**
 * Created by jl on 2019/1/30.
 */

public class UserInfoResponses {


    /**
     * certificateNumber : string
     * certificateType : IDCARD
     * created : 2019-04-20T10:28:47.838Z
     * email : string
     * group : {"created":"2019-04-20T10:28:47.838Z","district":[0],"id":0,"name":"string","shortName":"string","updated":"2019-04-20T10:28:47.838Z"}
     * id : 0
     * mobile : string
     * nickname : string
     * password : string
     * role : {"created":"2019-04-20T10:28:47.838Z","id":0,"name":"string","permission":[0],"updated":"2019-04-20T10:28:47.838Z"}
     * salt : string
     * type : GOD
     * updated : 2019-04-20T10:28:47.838Z
     * username : string
     */

    private String certificateNumber;
    private String certificateType;
    private String created;
    private String email;
    private GroupBean group;
    private int id;
    private String mobile;
    private String nickname;
    private String password;
    private RoleBean role;
    private String salt;
    private String type;
    private String updated;
    private String username;

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GroupBean getGroup() {
        return group;
    }

    public void setGroup(GroupBean group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleBean getRole() {
        return role;
    }

    public void setRole(RoleBean role) {
        this.role = role;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static class GroupBean {
        /**
         * created : 2019-04-20T10:28:47.838Z
         * district : [0]
         * id : 0
         * name : string
         * shortName : string
         * updated : 2019-04-20T10:28:47.838Z
         */

        private String created;
        private int id;
        private String name;
        private String shortName;
        private String updated;
        private List<Integer> district;

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public List<Integer> getDistrict() {
            return district;
        }

        public void setDistrict(List<Integer> district) {
            this.district = district;
        }
    }

    public static class RoleBean {
        /**
         * created : 2019-04-20T10:28:47.838Z
         * id : 0
         * name : string
         * permission : [0]
         * updated : 2019-04-20T10:28:47.838Z
         */

        private String created;
        private int id;
        private String name;
        private String updated;
        private List<Integer> permission;

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public List<Integer> getPermission() {
            return permission;
        }

        public void setPermission(List<Integer> permission) {
            this.permission = permission;
        }
    }
}
