package com.trackolap;

import com.google.gson.Gson;
import com.trackolap.http.HttpManager;
import com.trackolap.response.Asset;
import com.trackolap.response.AssetList;

/**
 * API manager - All API's can be access https://trackolap.com/help/api-doc/
 * 
 * @author TrackOlap
 *
 */
public class APIManager {


    private static final String HOST = "https://app.trackolap.com/cust/1/";
    // private static final String PLAYBACK = HOST
    // +
    // "positions?asset_id=%s&load_all=true&start_time=%d&end_time=%d&stopage_filter=30&speed_filter=100";
    // private static final String ALERTS =
    // HOST +
    // "alert/list?asset_ids=%s&load_all=true&start_time=$d&end_time=$d&pt=10&pn=1&alert_types=$s";
    private static final String ASSET_LIST = HOST + "asset/list";
    private static final String ASSET_DETAIL = HOST + "asset/get?asset_id=%s";

    private final HttpManager httpManager;
    private final Gson gson;

    public APIManager(String customerId, String apiKey) {
        httpManager = new HttpManager(customerId, apiKey);
        gson = new Gson();
    }

    public AssetList assetList() throws Exception {
        return gson.fromJson(httpManager.sendGet(ASSET_LIST), AssetList.class);
    }

    public Asset assetDetail(String assetid) throws Exception {
        return gson.fromJson(httpManager.sendGet(String.format(ASSET_DETAIL, assetid)), Asset.class);
    }


}
