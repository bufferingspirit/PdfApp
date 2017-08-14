package com.example.admin.pdfapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        pdfView = (PDFView) findViewById(R.id.pdfView);
        //scrollHandle = (ScrollHandle) view.findViewById(R.id.scrollBar);
        pdfView.fromAsset("myPDF.pdf").defaultPage(1).load();
    }
    //add code to close pdf properly
}
