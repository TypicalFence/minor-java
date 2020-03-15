package moe.zaun.prismriver.minor.dto;

import moe.zaun.prismriver.minor.model.Model;

public class SimpleApiResponse extends AbstractApiResponse {
    
    private Model data;
    
    public void setData(Model model) {
        this.data = model;
    }

    public Model getData() {
        return this.data;
    }
    
}
