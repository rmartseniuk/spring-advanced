package com.epam.martseniuk.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

/**
 * @author Roman_Martseniuk
 */
@Slf4j
@Component
@Profile("ssl")
public class CertificateUtils {

    private static final String STANDART_X_509 = "X.509";
    private static final String REQUEST_PARAMETER_CERTIFICATE = "javax.servlet.request.X509Certificate";

    public X509Certificate getCertificate(String base64Certificate) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance(STANDART_X_509);
        return (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(convertToDerEncoding(base64Certificate)));
    }

    private byte[] convertToDerEncoding(String certificate) {
        return Base64.getDecoder().decode(certificate);
    }

    public String getSerialNumber(HttpServletRequest request) {
        X509Certificate certificate = (X509Certificate) request.getAttribute(REQUEST_PARAMETER_CERTIFICATE);
        return certificate.getSerialNumber().toString();
    }
}
