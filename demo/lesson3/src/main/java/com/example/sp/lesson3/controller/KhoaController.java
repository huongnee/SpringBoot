package com.example.sp.lesson3.controller;


import com.example.sp.lesson3.entity.Khoa;
import com.example.sp.lesson3.service.KhoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khoa")
public class KhoaController {
    private final KhoaService khoaService;

    public KhoaController(KhoaService khoaService) {
        this.khoaService = khoaService;
    }

    @GetMapping
    public List<Khoa> getAllKhoa() {
        return khoaService.getAllKhoa();
    }

    @GetMapping("/{makh}")
    public Optional<Khoa> getKhoaById(@PathVariable String makh) {
        return khoaService.getKhoaById(makh);
    }

    @PostMapping
    public void addKhoa(@RequestBody Khoa khoa) {
        khoaService.addKhoa(khoa);
    }

    @PutMapping("/{makh}")
    public void updateKhoa(@PathVariable String makh, @RequestBody Khoa khoa) {
        khoaService.updateKhoa(makh, khoa);
    }

    @DeleteMapping("/{makh}")
    public void deleteKhoa(@PathVariable String makh) {
        khoaService.deleteKhoa(makh);
    }
}