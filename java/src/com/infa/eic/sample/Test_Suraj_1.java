package com.infa.eic.sample;

import com.infa.products.ldm.core.rest.v2.client.api.CatalogApi;
import com.infa.products.ldm.core.rest.v2.client.invoker.ApiException;
import com.infa.products.ldm.core.rest.v2.client.invoker.ApiResponse;
import com.infa.products.ldm.core.rest.v2.client.models.AttributePostRequest;
import com.infa.products.ldm.core.rest.v2.client.models.AttributePutRequest;
import com.infa.products.ldm.core.rest.v2.client.models.AttributeResponse;
import com.infa.products.ldm.core.rest.v2.client.models.AttributesRequest;
import com.infa.products.ldm.core.rest.v2.client.models.AttributesResponse;
import com.infa.products.ldm.core.rest.v2.client.models.FactRequest;
import com.infa.products.ldm.core.rest.v2.client.models.Link;
import com.infa.products.ldm.core.rest.v2.client.models.Links;
import com.infa.products.ldm.core.rest.v2.client.models.ModelRefRequest;
import com.infa.products.ldm.core.rest.v2.client.models.ObjectIdRequest;
import com.infa.products.ldm.core.rest.v2.client.models.ObjectResponse;
import com.infa.products.ldm.core.rest.v2.client.models.ObjectsResponse;
import com.infa.products.ldm.core.rest.v2.client.models.RefAttributePost;
import com.infa.products.ldm.core.rest.v2.client.models.RefAttributesPost;
import com.infa.products.ldm.core.rest.v2.client.models.RefAttributesResponse;
import com.infa.products.ldm.core.rest.v2.client.utils.ObjectAdapter;

import java.math.BigDecimal;

public class Test_Suraj_1 {
    private CatalogApi api;

    public void Search() throws ApiException {

        BigDecimal offset = BigDecimal.ZERO;
        final BigDecimal pagesize = BigDecimal.valueOf(20);
        ObjectsResponse response = null;
        this.api=new CatalogApi();



        do {
            response = api.catalogDataObjectsGet("core.name:*Product_Information*" , null, offset, pagesize, false);
            for (ObjectResponse obj : response.getItems()) {
                obj.getFacts();
                System.out.println(obj.getId());

            }

            }
        while (response.getMetadata().getTotalCount().longValue() > pagesize.longValue()) ;
        }

        public static void main(String[] args){
            Test_Suraj_1 t1=new Test_Suraj_1();
            try {
                APIUtils.setupOnce();
            }catch(Exception e) {
                e.printStackTrace();
            }

            try {
                t1.Search();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

