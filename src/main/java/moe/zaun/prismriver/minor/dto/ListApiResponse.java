package moe.zaun.prismriver.minor.dto;

import java.util.List;
import moe.zaun.prismriver.minor.model.Model;

public class ListApiResponse extends AbstractApiResponse {
 
    private List<Model> data;
    private int count;
    private int limit;
    
    public void setData(List<Model> model) {
        this.data = model;
    }

    public List<Model> getData() {
        return this.data;
    }

    public int getCount() {
        return this.count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
    
}
