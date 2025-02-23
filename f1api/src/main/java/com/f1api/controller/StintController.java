package com.f1api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f1api.service.StintService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/stint")
@RequiredArgsConstructor
public class StintController {

    private final StintService stintService;

    @GetMapping("/all")
    List<String> getAllStints(){
        return this.stintService.findAllStints();
    }
}
