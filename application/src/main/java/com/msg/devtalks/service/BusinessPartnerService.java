package com.msg.devtalks.service;


import com.sap.cloud.sdk.cloudplatform.logging.CloudLoggerFactory;
import com.sap.cloud.sdk.odatav2.connectivity.ODataException;
import com.sap.cloud.sdk.s4hana.connectivity.ErpConfigContext;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartner;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.DefaultBusinessPartnerService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessPartnerService {

    private static final Logger logger = CloudLoggerFactory.getLogger(BusinessPartnerService.class);

    public BusinessPartner getBusinessPartner(String name) throws ODataException {

            final List<BusinessPartner> businessPartners =
                    new DefaultBusinessPartnerService()
                            .getAllBusinessPartner()
                            .select(BusinessPartner.ALL_FIELDS)
                            .filter(BusinessPartner.FIRST_NAME.eq(name))
                            .execute(new ErpConfigContext("BP_S4_CLOUD"));

            businessPartners.forEach(bp -> logger.info(bp.getBusinessPartnerFullName()));

            return businessPartners.get(0);
    }

    public List<BusinessPartner> getAllBusinessPartners() throws ODataException {

        final List<BusinessPartner> businessPartners =
                new DefaultBusinessPartnerService()
                        .getAllBusinessPartner()
                        .select(BusinessPartner.ALL_FIELDS)
                        .execute(new ErpConfigContext("BP_S4_CLOUD"));

        return businessPartners;
    }
}
