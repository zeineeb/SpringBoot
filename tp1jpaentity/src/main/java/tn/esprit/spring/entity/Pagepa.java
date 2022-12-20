package tn.esprit.spring.entity;

import java.util.List;

public class Pagepa {
    private List<Universite> universites;
    private List<Partenaire> partenaires;
    private List<Offre> offres;

    private int totalPages;
    private int pageNumber;
    private int pageSize;

    public Pagepa(){}

    public Pagepa(List<Universite> universites, int totalPages, int pageNumber, int pageSize) {
        this.universites  = universites;
        this.totalPages = totalPages;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public Pagepa(List<Partenaire> partenaires, int totalPages, int pageNumber, int pageSize , int p, int a) {
        this.partenaires  = partenaires;
        this.totalPages = totalPages;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
    public Pagepa(List<Offre> offres, int totalPages, int pageNumber, int pageSize, int p) {
        this.offres = offres;
        this.totalPages = totalPages;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public void setUniversites(List<Universite> universites) {
        this.universites = universites;
    }

    public List<Universite>  getUniversites() {
        return this.universites;
    }
    public void setOffres(List<Offre> offres) {
        this.offres = offres;
    }

    public List<Offre> getOffres() {
        return this.offres;
    }

    public void setPartenaires(List<Partenaire> partenaires) {
        this.partenaires = partenaires;
    }

    public List<Partenaire> getPartenaires() {
        return this.partenaires;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return this.pageSize;
    }
}
