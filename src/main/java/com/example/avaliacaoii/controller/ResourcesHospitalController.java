package com.example.avaliacaoii.controller;

import com.example.avaliacaoii.controller.request.PostResourcesHospitalRequest;
import com.example.avaliacaoii.entity.ResourcesHospital;
import com.example.avaliacaoii.service.ResourcesHospitalService;
import com.example.avaliacaoii.util.ConvertUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/recursos")
public class ResourcesHospitalController {

    private final ResourcesHospitalService service;
    private final ConvertUtils convertUtils;

    public ResourcesHospitalController(ResourcesHospitalService service, ConvertUtils convertUtils) {
        this.service = service;
        this.convertUtils = convertUtils;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addResources(@RequestBody @Valid PostResourcesHospitalRequest request) {
        service.save((ResourcesHospital) convertUtils.convertRequestToEntity(request, ResourcesHospital.class));
    }

    @GetMapping("/media-recursos")
    public String getAverageResource() {
        return service.getAverageResource();
    }
}
