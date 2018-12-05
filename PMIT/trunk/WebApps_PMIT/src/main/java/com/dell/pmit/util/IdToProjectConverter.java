package com.dell.pmit.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.dell.pmit.dao.PMITDao;
import com.dell.pmit.model.Project;

public class IdToProjectConverter implements Converter<String, Project>{
    @Autowired
    PMITDao pmitDao;
    public Project convert(String id) {
        return pmitDao.getProjectBasedOnId(Long.valueOf(id));
    }
}
