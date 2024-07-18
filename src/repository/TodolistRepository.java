package repository;

import entity.Todolist;

public interface TodolistRepository {
    /*
        untuk nama interface di repository dan service
        biasanya sama dengan nama namaentityRepository dan namaentityService

        khusus untuk layer service dan repository biasanya orang java buat interfacenya dulu
        selanjutnya baru implementasi classnya

        tujuannya nanti di unit test tentang mocking

        jadi yang dibikin interface itu hanyalah untuk feature aja
        kalau featurenya ada method yang dipecah lagi,maka gausah bikin interface
     */

    Todolist[] getAll(); // menggunakan tipe data class Todolist
    void add(Todolist todo); // menggunakan tipe data class Todolist
    boolean remove(Integer number);
}
