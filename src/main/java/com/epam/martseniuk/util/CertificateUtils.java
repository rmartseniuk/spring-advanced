package com.epam.martseniuk.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

/**
 * @author Roman_Martseniuk
 */
@Component
@Slf4j
public class CertificateUtils {

    private static final String STANDART_X_509 = "X.509";

    public X509Certificate getCertificate(String base64Certificate) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance(STANDART_X_509);
        return (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(convertToDerEncoding(base64Certificate)));
    }

    public String getSerialNumber() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        String certificateInStr = "";
        if (attributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();
            certificateInStr = (String) request.getAttribute("javax.servlet.request.X509Certificate");
        }
        try {
            X509Certificate certificate = getCertificate(certificateInStr);
            return certificate.getSerialNumber().toString();
        } catch (CertificateException e) {
            log.error("Cannot retrieve serial number", e);
        }
        return "";
    }

    private byte[] convertToDerEncoding(String certificate) {
        return Base64.getDecoder().decode(certificate);
    }
}
