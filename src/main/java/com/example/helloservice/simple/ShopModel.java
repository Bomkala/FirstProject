package com.example.helloservice.simple;

import com.alibaba.fastjson.JSON;

public class ShopModel {

    private Integer shopId;

    private ExtParams extParams;

    public static ShopModel getInstance(String shopId, String thirdShopId, String locationId, String mFrom, String storeCode) {
        ShopModel shopModel = new ShopModel();
        shopModel.setShopId(Integer.parseInt(shopId));

        ExtParams params = new ExtParams(shopId, locationId, mFrom, storeCode);
        shopModel.setExtParams(params);

        return shopModel;
    }

    @Override
    public String toString() {
        return shopId + "," + JSON.toJSONString(extParams);
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public ExtParams getExtParams() {
        return extParams;
    }

    public void setExtParams(ExtParams extParams) {
        this.extParams = extParams;
    }

    public static class ExtParams {

        public ExtParams(String shopId, String locationId, String mFrom, String storeCode) {
            this.shopId = shopId;
            this.locationId = locationId;
            this.mFrom = mFrom;
            this.storeCode = storeCode;
        }

        private String shopId;

        private String locationId;

        private String mFrom;

        private String storeCode;

        public String getShopId() {
            return shopId;
        }

        public void setShopId(String shopId) {
            this.shopId = shopId;
        }

        public String getLocationId() {
            return locationId;
        }

        public void setLocationId(String locationId) {
            this.locationId = locationId;
        }

        public String getmFrom() {
            return mFrom;
        }

        public void setmFrom(String mFrom) {
            this.mFrom = mFrom;
        }
    }
}
