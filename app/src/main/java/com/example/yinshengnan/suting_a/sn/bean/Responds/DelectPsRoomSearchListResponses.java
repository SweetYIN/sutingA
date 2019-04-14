package com.example.yinshengnan.suting_a.sn.bean.Responds;
import java.io.Serializable;
import java.util.List;

/**
 * Created by jl on 2019/1/29.
 */

public class DelectPsRoomSearchListResponses implements Serializable {


    /**
     * roomView : {"id":7,"house":{"id":13,"created":"2019-04-12T21:22:35.44","updated":"2019-04-12T21:22:35.44","name":"分组房源","building":{"id":13,"created":"2019-04-03T23:21:50.561","updated":"2019-04-03T23:21:50.561","name":"天府新谷","code":"B001C80T16","district":510107,"longitude":"104.05568","latitude":"30.586697"},"address":"11111","houseType":"HOUSE","floor":"HIGH","bedroomCount":2,"parlorCount":1,"toiletCount":3,"kitchenCount":1,"room":[]},"name":"整租","inherited":true,"suitable":1,"area":"100","orientation":"SOUTH","amenities":["WIFI","ESSENTIALS"],"description":"啊发顺丰的","lock":{"id":1},"state":"CLEANING","imagePath":"http://rubik-cloud.oss-cn-beijing.aliyuncs.com/room/7/TOP/top.jpg?Expires=1555839137&OSSAccessKeyId=LTAIvZlFofKRP4u5&Signature=oa0eE8EDMO02v08ZsYof%2FE%2Bax2c%3D&x-oss-process=image%2Fresize%2Cm_fixed%2Cw_48%2Ch_48","created":"2019-04-12T21:22:35.44","updated":"2019-04-12T21:22:35.44"}
     * lockViewList : [{"lock":{"id":1,"created":"2019-04-14T08:22:08.04","updated":"2019-04-14T08:22:10.028","code":"1","name":"aaa","state":"EFFECTIVE","data":{"nbRssi":0,"lockKey":"OCw4LDAsMTEsMTUsMSwxMCw5LDEyLDEsNzA=","lockMac":"F5:2C:91:1C:54:91","pwdInfo":"AZ2D1y3CGHQ2E5VM3Iax4mrRBQZMR17NULUuPqjSBFStAjuQNpNBj1QdTnauvUvWdZXk8I70mwGOxfAXHt2Zzhms9l4w4mVNwEVsskNY1vLpD5yNjKH+MET8WF0sUPl6Da2rZuk0PLrZknENKxGzSCqeksJEhMARXWywXLFXv6HiZCk5uZD1LuU1sEe2VIxP9sGXPlGD/UWN/6GoIPd304YzMb/y/zqaHeO6HVYcdc6BFmXr88KXd7iQXPk8NoMEzlt6/l1+ahKMZkFHFNxWm033uDjMUt4rf8K9CQ/kOuf9Y4SP0+T+a4Zgmg+0C44aMexOvLtrTFFnP2k7dVWdV5VRq5ggRonvIoKUcXvSrTQzVq0eiFXCi//pumGhOy22adDrEnYCYKMniUsAuJ307cNq6rU47KGyqc29RIN93IlhSBn3sgpQA2i8TXp+ZelfHfKt4sVH/BxZR9nqMNii2S4wfPVs5EsKjWsgs19VA4W0GrEluYrSP4BdkZBTaVAL69WuLyP345EbA/ljyriq+RQeroM8ma4/auPRvFUkZBn1Dwp1GUV67cA/JqiSVwzYCoBP6bGXPrD15n/A2IiEoFNgSZxwMZxi2yaK166yr579Ns5ulAGTIjQr0PUOdHazLdxaRFv1bvdLA1HGdGaFIsR3GWe0QUt9o4n4kZmr6Es1IOGxWuuMvLfOsXXnO3OGBT0PlvZ1xNMttNagc01I00P836Uow0ePVhZjX88MWJnK7yH+G57UA1QlVrDemkCesrbOLo1/GC3duR+Eqc0xYfhQHry4T8N+fLrxIHnlhFtwQL7WzOnHyTHZCse9rlbsNpMbywzT+iZ0sdowTzPo9PEUSehp8XTpLP0u45muH5c=","adminPwd":"NDEsNDYsNDUsNDcsNDcsNDQsNDAsNDcsNDUsNDcsMTAz","lockName":"S202T_91541c","modelNum":"SN139-S202_PV53","noKeyPwd":"7803748","aesKeyStr":"ec,1f,e8,ea,5f,bf,b9,01,04,32,0e,6c,46,0d,d5,05","timestamp":1555231770670,"lockFlagPos":0,"lockVersion":"{\"groupId\":1,\"orgId\":1,\"protocolType\":5,\"protocolVersion\":3,\"scene\":2}","specialValue":53473,"electricQuantity":75,"firmwareRevision":"4.1.18.0626","hardwareRevision":"1.1.1","timezoneRawOffset":28800000}},"keyboardPwdId":10062265,"keyboardPwd":"185260"}]
     */

    private RoomViewBean roomView;
    private List<LockViewListBean> lockViewList;

    public RoomViewBean getRoomView() {
        return roomView;
    }

    public void setRoomView(RoomViewBean roomView) {
        this.roomView = roomView;
    }

    public List<LockViewListBean> getLockViewList() {
        return lockViewList;
    }

    public void setLockViewList(List<LockViewListBean> lockViewList) {
        this.lockViewList = lockViewList;
    }

    public static class RoomViewBean implements Serializable{
        /**
         * id : 7
         * house : {"id":13,"created":"2019-04-12T21:22:35.44","updated":"2019-04-12T21:22:35.44","name":"分组房源","building":{"id":13,"created":"2019-04-03T23:21:50.561","updated":"2019-04-03T23:21:50.561","name":"天府新谷","code":"B001C80T16","district":510107,"longitude":"104.05568","latitude":"30.586697"},"address":"11111","houseType":"HOUSE","floor":"HIGH","bedroomCount":2,"parlorCount":1,"toiletCount":3,"kitchenCount":1,"room":[]}
         * name : 整租
         * inherited : true
         * suitable : 1
         * area : 100
         * orientation : SOUTH
         * amenities : ["WIFI","ESSENTIALS"]
         * description : 啊发顺丰的
         * lock : {"id":1}
         * state : CLEANING
         * imagePath : http://rubik-cloud.oss-cn-beijing.aliyuncs.com/room/7/TOP/top.jpg?Expires=1555839137&OSSAccessKeyId=LTAIvZlFofKRP4u5&Signature=oa0eE8EDMO02v08ZsYof%2FE%2Bax2c%3D&x-oss-process=image%2Fresize%2Cm_fixed%2Cw_48%2Ch_48
         * created : 2019-04-12T21:22:35.44
         * updated : 2019-04-12T21:22:35.44
         */

        private int id;
        private HouseBean house;
        private String name;
        private boolean inherited;
        private int suitable;
        private String area;
        private String orientation;
        private String description;
        private LockBean lock;
        private String state;
        private String imagePath;
        private String created;
        private String updated;
        private List<String> amenities;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public HouseBean getHouse() {
            return house;
        }

        public void setHouse(HouseBean house) {
            this.house = house;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isInherited() {
            return inherited;
        }

        public void setInherited(boolean inherited) {
            this.inherited = inherited;
        }

        public int getSuitable() {
            return suitable;
        }

        public void setSuitable(int suitable) {
            this.suitable = suitable;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getOrientation() {
            return orientation;
        }

        public void setOrientation(String orientation) {
            this.orientation = orientation;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public LockBean getLock() {
            return lock;
        }

        public void setLock(LockBean lock) {
            this.lock = lock;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public List<String> getAmenities() {
            return amenities;
        }

        public void setAmenities(List<String> amenities) {
            this.amenities = amenities;
        }

        public static class HouseBean implements Serializable{
            /**
             * id : 13
             * created : 2019-04-12T21:22:35.44
             * updated : 2019-04-12T21:22:35.44
             * name : 分组房源
             * building : {"id":13,"created":"2019-04-03T23:21:50.561","updated":"2019-04-03T23:21:50.561","name":"天府新谷","code":"B001C80T16","district":510107,"longitude":"104.05568","latitude":"30.586697"}
             * address : 11111
             * houseType : HOUSE
             * floor : HIGH
             * bedroomCount : 2
             * parlorCount : 1
             * toiletCount : 3
             * kitchenCount : 1
             * room : []
             */

            private int id;
            private String created;
            private String updated;
            private String name;
            private BuildingBean building;
            private String address;
            private String houseType;
            private String floor;
            private int bedroomCount;
            private int parlorCount;
            private int toiletCount;
            private int kitchenCount;
            private List<?> room;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public String getUpdated() {
                return updated;
            }

            public void setUpdated(String updated) {
                this.updated = updated;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public BuildingBean getBuilding() {
                return building;
            }

            public void setBuilding(BuildingBean building) {
                this.building = building;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getHouseType() {
                return houseType;
            }

            public void setHouseType(String houseType) {
                this.houseType = houseType;
            }

            public String getFloor() {
                return floor;
            }

            public void setFloor(String floor) {
                this.floor = floor;
            }

            public int getBedroomCount() {
                return bedroomCount;
            }

            public void setBedroomCount(int bedroomCount) {
                this.bedroomCount = bedroomCount;
            }

            public int getParlorCount() {
                return parlorCount;
            }

            public void setParlorCount(int parlorCount) {
                this.parlorCount = parlorCount;
            }

            public int getToiletCount() {
                return toiletCount;
            }

            public void setToiletCount(int toiletCount) {
                this.toiletCount = toiletCount;
            }

            public int getKitchenCount() {
                return kitchenCount;
            }

            public void setKitchenCount(int kitchenCount) {
                this.kitchenCount = kitchenCount;
            }

            public List<?> getRoom() {
                return room;
            }

            public void setRoom(List<?> room) {
                this.room = room;
            }

            public static class BuildingBean implements Serializable{
                /**
                 * id : 13
                 * created : 2019-04-03T23:21:50.561
                 * updated : 2019-04-03T23:21:50.561
                 * name : 天府新谷
                 * code : B001C80T16
                 * district : 510107
                 * longitude : 104.05568
                 * latitude : 30.586697
                 */

                private int id;
                private String created;
                private String updated;
                private String name;
                private String code;
                private int district;
                private String longitude;
                private String latitude;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getCreated() {
                    return created;
                }

                public void setCreated(String created) {
                    this.created = created;
                }

                public String getUpdated() {
                    return updated;
                }

                public void setUpdated(String updated) {
                    this.updated = updated;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public int getDistrict() {
                    return district;
                }

                public void setDistrict(int district) {
                    this.district = district;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }
            }
        }

        public static class LockBean implements Serializable{
            /**
             * id : 1
             */

            private int id;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }

    public static class LockViewListBean implements  Serializable{
        /**
         * lock : {"id":1,"created":"2019-04-14T08:22:08.04","updated":"2019-04-14T08:22:10.028","code":"1","name":"aaa","state":"EFFECTIVE","data":{"nbRssi":0,"lockKey":"OCw4LDAsMTEsMTUsMSwxMCw5LDEyLDEsNzA=","lockMac":"F5:2C:91:1C:54:91","pwdInfo":"AZ2D1y3CGHQ2E5VM3Iax4mrRBQZMR17NULUuPqjSBFStAjuQNpNBj1QdTnauvUvWdZXk8I70mwGOxfAXHt2Zzhms9l4w4mVNwEVsskNY1vLpD5yNjKH+MET8WF0sUPl6Da2rZuk0PLrZknENKxGzSCqeksJEhMARXWywXLFXv6HiZCk5uZD1LuU1sEe2VIxP9sGXPlGD/UWN/6GoIPd304YzMb/y/zqaHeO6HVYcdc6BFmXr88KXd7iQXPk8NoMEzlt6/l1+ahKMZkFHFNxWm033uDjMUt4rf8K9CQ/kOuf9Y4SP0+T+a4Zgmg+0C44aMexOvLtrTFFnP2k7dVWdV5VRq5ggRonvIoKUcXvSrTQzVq0eiFXCi//pumGhOy22adDrEnYCYKMniUsAuJ307cNq6rU47KGyqc29RIN93IlhSBn3sgpQA2i8TXp+ZelfHfKt4sVH/BxZR9nqMNii2S4wfPVs5EsKjWsgs19VA4W0GrEluYrSP4BdkZBTaVAL69WuLyP345EbA/ljyriq+RQeroM8ma4/auPRvFUkZBn1Dwp1GUV67cA/JqiSVwzYCoBP6bGXPrD15n/A2IiEoFNgSZxwMZxi2yaK166yr579Ns5ulAGTIjQr0PUOdHazLdxaRFv1bvdLA1HGdGaFIsR3GWe0QUt9o4n4kZmr6Es1IOGxWuuMvLfOsXXnO3OGBT0PlvZ1xNMttNagc01I00P836Uow0ePVhZjX88MWJnK7yH+G57UA1QlVrDemkCesrbOLo1/GC3duR+Eqc0xYfhQHry4T8N+fLrxIHnlhFtwQL7WzOnHyTHZCse9rlbsNpMbywzT+iZ0sdowTzPo9PEUSehp8XTpLP0u45muH5c=","adminPwd":"NDEsNDYsNDUsNDcsNDcsNDQsNDAsNDcsNDUsNDcsMTAz","lockName":"S202T_91541c","modelNum":"SN139-S202_PV53","noKeyPwd":"7803748","aesKeyStr":"ec,1f,e8,ea,5f,bf,b9,01,04,32,0e,6c,46,0d,d5,05","timestamp":1555231770670,"lockFlagPos":0,"lockVersion":"{\"groupId\":1,\"orgId\":1,\"protocolType\":5,\"protocolVersion\":3,\"scene\":2}","specialValue":53473,"electricQuantity":75,"firmwareRevision":"4.1.18.0626","hardwareRevision":"1.1.1","timezoneRawOffset":28800000}}
         * keyboardPwdId : 10062265
         * keyboardPwd : 185260
         */

        private LockBeanX lock;
        private int keyboardPwdId;
        private String keyboardPwd;

        public LockBeanX getLock() {
            return lock;
        }

        public void setLock(LockBeanX lock) {
            this.lock = lock;
        }

        public int getKeyboardPwdId() {
            return keyboardPwdId;
        }

        public void setKeyboardPwdId(int keyboardPwdId) {
            this.keyboardPwdId = keyboardPwdId;
        }

        public String getKeyboardPwd() {
            return keyboardPwd;
        }

        public void setKeyboardPwd(String keyboardPwd) {
            this.keyboardPwd = keyboardPwd;
        }

        public static class LockBeanX implements Serializable{
            /**
             * id : 1
             * created : 2019-04-14T08:22:08.04
             * updated : 2019-04-14T08:22:10.028
             * code : 1
             * name : aaa
             * state : EFFECTIVE
             * data : {"nbRssi":0,"lockKey":"OCw4LDAsMTEsMTUsMSwxMCw5LDEyLDEsNzA=","lockMac":"F5:2C:91:1C:54:91","pwdInfo":"AZ2D1y3CGHQ2E5VM3Iax4mrRBQZMR17NULUuPqjSBFStAjuQNpNBj1QdTnauvUvWdZXk8I70mwGOxfAXHt2Zzhms9l4w4mVNwEVsskNY1vLpD5yNjKH+MET8WF0sUPl6Da2rZuk0PLrZknENKxGzSCqeksJEhMARXWywXLFXv6HiZCk5uZD1LuU1sEe2VIxP9sGXPlGD/UWN/6GoIPd304YzMb/y/zqaHeO6HVYcdc6BFmXr88KXd7iQXPk8NoMEzlt6/l1+ahKMZkFHFNxWm033uDjMUt4rf8K9CQ/kOuf9Y4SP0+T+a4Zgmg+0C44aMexOvLtrTFFnP2k7dVWdV5VRq5ggRonvIoKUcXvSrTQzVq0eiFXCi//pumGhOy22adDrEnYCYKMniUsAuJ307cNq6rU47KGyqc29RIN93IlhSBn3sgpQA2i8TXp+ZelfHfKt4sVH/BxZR9nqMNii2S4wfPVs5EsKjWsgs19VA4W0GrEluYrSP4BdkZBTaVAL69WuLyP345EbA/ljyriq+RQeroM8ma4/auPRvFUkZBn1Dwp1GUV67cA/JqiSVwzYCoBP6bGXPrD15n/A2IiEoFNgSZxwMZxi2yaK166yr579Ns5ulAGTIjQr0PUOdHazLdxaRFv1bvdLA1HGdGaFIsR3GWe0QUt9o4n4kZmr6Es1IOGxWuuMvLfOsXXnO3OGBT0PlvZ1xNMttNagc01I00P836Uow0ePVhZjX88MWJnK7yH+G57UA1QlVrDemkCesrbOLo1/GC3duR+Eqc0xYfhQHry4T8N+fLrxIHnlhFtwQL7WzOnHyTHZCse9rlbsNpMbywzT+iZ0sdowTzPo9PEUSehp8XTpLP0u45muH5c=","adminPwd":"NDEsNDYsNDUsNDcsNDcsNDQsNDAsNDcsNDUsNDcsMTAz","lockName":"S202T_91541c","modelNum":"SN139-S202_PV53","noKeyPwd":"7803748","aesKeyStr":"ec,1f,e8,ea,5f,bf,b9,01,04,32,0e,6c,46,0d,d5,05","timestamp":1555231770670,"lockFlagPos":0,"lockVersion":"{\"groupId\":1,\"orgId\":1,\"protocolType\":5,\"protocolVersion\":3,\"scene\":2}","specialValue":53473,"electricQuantity":75,"firmwareRevision":"4.1.18.0626","hardwareRevision":"1.1.1","timezoneRawOffset":28800000}
             */

            private int id;
            private String created;
            private String updated;
            private String code;
            private String name;
            private String state;
            private DataBean data;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public String getUpdated() {
                return updated;
            }

            public void setUpdated(String updated) {
                this.updated = updated;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public static class DataBean implements Serializable{
                /**
                 * nbRssi : 0
                 * lockKey : OCw4LDAsMTEsMTUsMSwxMCw5LDEyLDEsNzA=
                 * lockMac : F5:2C:91:1C:54:91
                 * pwdInfo : AZ2D1y3CGHQ2E5VM3Iax4mrRBQZMR17NULUuPqjSBFStAjuQNpNBj1QdTnauvUvWdZXk8I70mwGOxfAXHt2Zzhms9l4w4mVNwEVsskNY1vLpD5yNjKH+MET8WF0sUPl6Da2rZuk0PLrZknENKxGzSCqeksJEhMARXWywXLFXv6HiZCk5uZD1LuU1sEe2VIxP9sGXPlGD/UWN/6GoIPd304YzMb/y/zqaHeO6HVYcdc6BFmXr88KXd7iQXPk8NoMEzlt6/l1+ahKMZkFHFNxWm033uDjMUt4rf8K9CQ/kOuf9Y4SP0+T+a4Zgmg+0C44aMexOvLtrTFFnP2k7dVWdV5VRq5ggRonvIoKUcXvSrTQzVq0eiFXCi//pumGhOy22adDrEnYCYKMniUsAuJ307cNq6rU47KGyqc29RIN93IlhSBn3sgpQA2i8TXp+ZelfHfKt4sVH/BxZR9nqMNii2S4wfPVs5EsKjWsgs19VA4W0GrEluYrSP4BdkZBTaVAL69WuLyP345EbA/ljyriq+RQeroM8ma4/auPRvFUkZBn1Dwp1GUV67cA/JqiSVwzYCoBP6bGXPrD15n/A2IiEoFNgSZxwMZxi2yaK166yr579Ns5ulAGTIjQr0PUOdHazLdxaRFv1bvdLA1HGdGaFIsR3GWe0QUt9o4n4kZmr6Es1IOGxWuuMvLfOsXXnO3OGBT0PlvZ1xNMttNagc01I00P836Uow0ePVhZjX88MWJnK7yH+G57UA1QlVrDemkCesrbOLo1/GC3duR+Eqc0xYfhQHry4T8N+fLrxIHnlhFtwQL7WzOnHyTHZCse9rlbsNpMbywzT+iZ0sdowTzPo9PEUSehp8XTpLP0u45muH5c=
                 * adminPwd : NDEsNDYsNDUsNDcsNDcsNDQsNDAsNDcsNDUsNDcsMTAz
                 * lockName : S202T_91541c
                 * modelNum : SN139-S202_PV53
                 * noKeyPwd : 7803748
                 * aesKeyStr : ec,1f,e8,ea,5f,bf,b9,01,04,32,0e,6c,46,0d,d5,05
                 * timestamp : 1555231770670
                 * lockFlagPos : 0
                 * lockVersion : {"groupId":1,"orgId":1,"protocolType":5,"protocolVersion":3,"scene":2}
                 * specialValue : 53473
                 * electricQuantity : 75
                 * firmwareRevision : 4.1.18.0626
                 * hardwareRevision : 1.1.1
                 * timezoneRawOffset : 28800000
                 */

                private int nbRssi;
                private String lockKey;
                private String lockMac;
                private String pwdInfo;
                private String adminPwd;
                private String lockName;
                private String modelNum;
                private String noKeyPwd;
                private String aesKeyStr;
                private long timestamp;
                private int lockFlagPos;
                private String lockVersion;
                private int specialValue;
                private int electricQuantity;
                private String firmwareRevision;
                private String hardwareRevision;
                private int timezoneRawOffset;

                public int getNbRssi() {
                    return nbRssi;
                }

                public void setNbRssi(int nbRssi) {
                    this.nbRssi = nbRssi;
                }

                public String getLockKey() {
                    return lockKey;
                }

                public void setLockKey(String lockKey) {
                    this.lockKey = lockKey;
                }

                public String getLockMac() {
                    return lockMac;
                }

                public void setLockMac(String lockMac) {
                    this.lockMac = lockMac;
                }

                public String getPwdInfo() {
                    return pwdInfo;
                }

                public void setPwdInfo(String pwdInfo) {
                    this.pwdInfo = pwdInfo;
                }

                public String getAdminPwd() {
                    return adminPwd;
                }

                public void setAdminPwd(String adminPwd) {
                    this.adminPwd = adminPwd;
                }

                public String getLockName() {
                    return lockName;
                }

                public void setLockName(String lockName) {
                    this.lockName = lockName;
                }

                public String getModelNum() {
                    return modelNum;
                }

                public void setModelNum(String modelNum) {
                    this.modelNum = modelNum;
                }

                public String getNoKeyPwd() {
                    return noKeyPwd;
                }

                public void setNoKeyPwd(String noKeyPwd) {
                    this.noKeyPwd = noKeyPwd;
                }

                public String getAesKeyStr() {
                    return aesKeyStr;
                }

                public void setAesKeyStr(String aesKeyStr) {
                    this.aesKeyStr = aesKeyStr;
                }

                public long getTimestamp() {
                    return timestamp;
                }

                public void setTimestamp(long timestamp) {
                    this.timestamp = timestamp;
                }

                public int getLockFlagPos() {
                    return lockFlagPos;
                }

                public void setLockFlagPos(int lockFlagPos) {
                    this.lockFlagPos = lockFlagPos;
                }

                public String getLockVersion() {
                    return lockVersion;
                }

                public void setLockVersion(String lockVersion) {
                    this.lockVersion = lockVersion;
                }

                public int getSpecialValue() {
                    return specialValue;
                }

                public void setSpecialValue(int specialValue) {
                    this.specialValue = specialValue;
                }

                public int getElectricQuantity() {
                    return electricQuantity;
                }

                public void setElectricQuantity(int electricQuantity) {
                    this.electricQuantity = electricQuantity;
                }

                public String getFirmwareRevision() {
                    return firmwareRevision;
                }

                public void setFirmwareRevision(String firmwareRevision) {
                    this.firmwareRevision = firmwareRevision;
                }

                public String getHardwareRevision() {
                    return hardwareRevision;
                }

                public void setHardwareRevision(String hardwareRevision) {
                    this.hardwareRevision = hardwareRevision;
                }

                public int getTimezoneRawOffset() {
                    return timezoneRawOffset;
                }

                public void setTimezoneRawOffset(int timezoneRawOffset) {
                    this.timezoneRawOffset = timezoneRawOffset;
                }
            }
        }
    }
}
