package com.trackolap.api.test;

import org.junit.Before;
import org.junit.Test;
import com.trackolap.APIManager;
import com.trackolap.response.Asset;
import com.trackolap.response.AssetList;


public class AssetTest {

    private APIManager apiManager;


    @Before
    public void setup() {
        apiManager = new APIManager("", "");

    }

    @Test
    public void assetList() {
        try {
            AssetList assets = apiManager.assetList();
            System.out.println("Total assets Found " + assets.getCount());
            assets.getData().forEach(asset -> {
                System.out.println(asset.getTitle() + " " + asset.getNumber());
                assetDetail(asset.getId());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void assetDetail(String assetid) {
        try {
            Asset asset = apiManager.assetDetail(assetid);
            System.out.println("Asset Lat lng " + asset.getGeoData().getLat() + " " + asset.getGeoData().getLng());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
