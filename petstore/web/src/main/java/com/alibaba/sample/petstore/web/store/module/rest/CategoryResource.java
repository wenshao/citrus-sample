package com.alibaba.sample.petstore.web.store.module.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.sample.petstore.biz.StoreManager;
import com.alibaba.sample.petstore.dal.dataobject.Category;

@Path("rest/category")
public class CategoryResource {

    @Autowired
    private StoreManager storeManager;

    @GET
    public List<Category> getAllCategories() {
        return storeManager.getAllCategories();
    }
}
