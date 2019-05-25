package com.trackolap.response;

import java.util.ArrayList;
import java.util.List;


public class AssetList extends GenericResponse {

    private int count;

    private long total;

    // Has more records - Applicable for pagniated API's
    private boolean hm;

    private List<Asset> data = new ArrayList<Asset>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isHm() {
        return hm;
    }

    public void setHm(boolean hm) {
        this.hm = hm;
    }

    public List<Asset> getData() {
        return data;
    }

    public void setData(List<Asset> data) {
        this.data = data;
    }

}
