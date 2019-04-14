package com.example.yinshengnan.suting_a.sn.bean.Responds;
import java.io.Serializable;
import java.util.List;

/**
 * Created by jl on 2019/1/29.
 */

public class BindRoomSearchListResponses implements Serializable {


    /**
     * id : 8
     * house : {"id":14,"created":"2019-04-12T21:31:18.986","updated":"2019-04-12T21:31:18.986","name":"分租房源1","building":{"id":3,"name":"微软大厦","code":"B0FFFSPTNE","district":110108,"longitude":"116.31028","latitude":"39.979366"},"address":"2","houseType":"APARTMENT","floor":"HIGH","bedroomCount":5,"parlorCount":1,"toiletCount":2,"kitchenCount":0,"room":[]}
     * name : 整租
     * inherited : true
     * suitable : 2
     * bed : ["单人床2X0.8米  1张"]
     * area : 2
     * orientation : EAST
     * amenities : ["WIFI","ESSENTIALS","LAPTOP"]
     * description : saffsasfdsfd
     * state : LEASING
     * imagePath : http://rubik-cloud.oss-cn-beijing.aliyuncs.com/room/8/TOP/top.jpg?Expires=1555845947&OSSAccessKeyId=LTAIvZlFofKRP4u5&Signature=q8mIi%2BJ3n332zp1ZWpUREOMEVkA%3D&x-oss-process=image%2Fresize%2Cm_fixed%2Cw_48%2Ch_48
     * created : 2019-04-12T21:31:18.986
     * updated : 2019-04-12T21:31:18.986
     */

    private int id;
    private HouseBean house;
    private String name;
    private boolean inherited;
    private int suitable;
    private String area;
    private String orientation;
    private String description;
    private String state;
    private String imagePath;
    private String created;
    private String updated;
    private List<String> bed;
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

    public List<String> getBed() {
        return bed;
    }

    public void setBed(List<String> bed) {
        this.bed = bed;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public static class HouseBean {
        /**
         * id : 14
         * created : 2019-04-12T21:31:18.986
         * updated : 2019-04-12T21:31:18.986
         * name : 分租房源1
         * building : {"id":3,"name":"微软大厦","code":"B0FFFSPTNE","district":110108,"longitude":"116.31028","latitude":"39.979366"}
         * address : 2
         * houseType : APARTMENT
         * floor : HIGH
         * bedroomCount : 5
         * parlorCount : 1
         * toiletCount : 2
         * kitchenCount : 0
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

        public static class BuildingBean {
            /**
             * id : 3
             * name : 微软大厦
             * code : B0FFFSPTNE
             * district : 110108
             * longitude : 116.31028
             * latitude : 39.979366
             */

            private int id;
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
}
