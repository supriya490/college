package com.example.swaroopapp.ebook;

public class Ebookdata {
    private String pdftitle, pdfUrl;

    public Ebookdata() {
    }

    public Ebookdata(String pdftitle, String pdfUrl) {
        this.pdftitle = pdftitle;
        this.pdfUrl = pdfUrl;
    }

    public String getPdftitle() {
        return pdftitle;
    }

    public void setPdftitle(String pdftitle) {
        this.pdftitle = pdftitle;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}


