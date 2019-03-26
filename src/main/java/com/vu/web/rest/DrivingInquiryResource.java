package com.vu.web.rest;

import com.vu.service.dto.FineCarDto;
import com.vu.service.dto.PointLicenseDto;
import com.vu.service.impl.DrivingInquiryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driving")
public class DrivingInquiryResource {

    private final DrivingInquiryService drivingInquiryService;

    public DrivingInquiryResource(DrivingInquiryService drivingInquiryService) {
        this.drivingInquiryService = drivingInquiryService;
    }

    @GetMapping("/points/{license-number}/inquiry")
    public PointLicenseDto getPointLicenseNumberInquiry(@PathVariable("license-number") String licenseNumber) {
        return drivingInquiryService.getPointLicenseNumberInquiry(licenseNumber);
    }

    @GetMapping("/fines/{bar-code}/inquiry")
    public FineCarDto getFineCarInquiry(@PathVariable("bar-code") String barCode) {
        return drivingInquiryService.getFineCarInquiry(barCode);
    }
}
