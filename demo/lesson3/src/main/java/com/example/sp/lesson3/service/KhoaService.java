package com.example.sp.lesson3.service;
import com.example.sp.lesson3.entity.Khoa;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KhoaService {
    private List<Khoa> khoaList = new ArrayList<>();

    public KhoaService() {
        khoaList.add(new Khoa("KH001", "Công nghệ thông tin"));
        khoaList.add(new Khoa("KH002", "Kinh tế"));
        khoaList.add(new Khoa("KH003", "Ngoại ngữ"));
        khoaList.add(new Khoa("KH004", "Luật"));
        khoaList.add(new Khoa("KH005", "Y dược"));
    }

    public List<Khoa> getAllKhoa() {
        return khoaList;
    }

    public Optional<Khoa> getKhoaById(String makh) {
        return khoaList.stream().filter(k -> k.getMakh().equals(makh)).findFirst();
    }

    public void addKhoa(Khoa khoa) {
        khoaList.add(khoa);
    }

    public void updateKhoa(String makh, Khoa khoa) {
        khoaList.replaceAll(k -> k.getMakh().equals(makh) ? khoa : k);
    }

    public void deleteKhoa(String makh) {
        khoaList.removeIf(k -> k.getMakh().equals(makh));
    }
}