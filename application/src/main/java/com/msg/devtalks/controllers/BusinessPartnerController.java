package com.msg.devtalks.controllers;

import com.msg.devtalks.service.BusinessPartnerService;
import com.sap.cloud.sdk.cloudplatform.logging.CloudLoggerFactory;
import com.sap.cloud.sdk.odatav2.connectivity.ODataException;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartner;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusinessPartnerController {

    private static final Logger logger = CloudLoggerFactory.getLogger(BusinessPartnerController.class);
    @Autowired
    private BusinessPartnerService businessPartnerService;

    @GetMapping("/bp/{bpName}")
    public ResponseEntity<BusinessPartner> getMyBusinessPartner(@PathVariable("bpName") String bpName){
        try {

            return ResponseEntity.ok(businessPartnerService.getBusinessPartner(bpName));

        } catch (ODataException e) {
            logger.error("exception thrown:", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/bp")
    public ResponseEntity<List<BusinessPartner>> getMyBusinessPartner(){
        try {

            return ResponseEntity.ok(businessPartnerService.getAllBusinessPartners());

        } catch (ODataException e) {
            logger.error("exception thrown:", e);
            return ResponseEntity.badRequest().build();
        }
    }
}
