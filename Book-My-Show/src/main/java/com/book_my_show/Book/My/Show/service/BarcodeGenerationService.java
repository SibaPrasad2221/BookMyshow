package com.book_my_show.Book.My.Show.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Getter
@Service
public class BarcodeGenerationService {
    private static final String qrLocation = "C:\\Users\\sahoo\\Downloads\\Book My Show\\Book-My-Show\\src\\main\\resources\\static\\QRcode.png";
    private static int hieght = 250;
    private static int width = 250;

    public void generateQR(String text) throws IOException, WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, hieght);
        Path path = FileSystems.getDefault().getPath(qrLocation);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
