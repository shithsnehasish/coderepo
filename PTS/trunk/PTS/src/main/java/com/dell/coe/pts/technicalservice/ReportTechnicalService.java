package com.dell.coe.pts.technicalservice;

import javax.ws.rs.core.Response;

import com.dell.coe.virtuoso.common.service.AbstractService;

public interface ReportTechnicalService extends AbstractService {

    Response getFile(String reportType);

}
