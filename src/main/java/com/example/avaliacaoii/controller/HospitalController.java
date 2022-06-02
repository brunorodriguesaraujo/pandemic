package com.example.avaliacaoii.controller;

import com.example.avaliacaoii.controller.request.PercentRequest;
import com.example.avaliacaoii.controller.request.PostHospitalRequest;
import com.example.avaliacaoii.controller.response.HospitalResponse;
import com.example.avaliacaoii.entity.Hospital;
import com.example.avaliacaoii.exception.NotFoundException;
import com.example.avaliacaoii.service.HospitalService;
import com.example.avaliacaoii.util.ConvertUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/hospital")
public class HospitalController {

    private final HospitalService service;
    private final ConvertUtils convertUtils;

    public HospitalController(HospitalService service, ConvertUtils convertUtils) {
        this.service = service;
        this.convertUtils = convertUtils;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid PostHospitalRequest request) {
        service.save((Hospital) convertUtils.convertRequestToEntity(request, Hospital.class));
    }

    @GetMapping("/percentual-maior")
    public double percentLarger() {
        return service.percentLarger();
    }

    @GetMapping("/percentual-menor")
    public double percentSmaller() {
        return service.percentSmaller();
    }

    @PutMapping(path = {"/{id}"})
    public Hospital updatePercent(@PathVariable Long id, PercentRequest percentRequest) throws NotFoundException {
        return service.updatePercent(id, percentRequest);
    }

    @GetMapping("/ocupacao-menor")
    public HospitalResponse getOccupationSmaller() {
        return (HospitalResponse) convertUtils.convertEntityToResponse(service.getOccupationSmaller(), HospitalResponse.class);
    }

    @GetMapping("/ocupacao-maior")
    public HospitalResponse getOccupationLarger() {
        return (HospitalResponse) convertUtils.convertEntityToResponse(service.getOccupationLarger(), HospitalResponse.class);
    }
}
