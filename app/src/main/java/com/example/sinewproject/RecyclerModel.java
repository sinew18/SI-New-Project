package com.example.sinewproject;

public class RecyclerModel {
    private String namaFilm;
    private String tahunFilm;
    private String durasiMenit;

    public RecyclerModel(String namaFilm, String tahunFilm, String durasiMenit){
        this.namaFilm = namaFilm;
        this.tahunFilm = tahunFilm;
        this.durasiMenit = durasiMenit;
    }

    public String getNamaFilm(){
        return namaFilm;
    }

    public String getTahunFilm(){
        return tahunFilm;
    }

    public String getDurasiMenit(){
        return durasiMenit;
    }

}
