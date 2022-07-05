package com.irfeyal.servicio.matricula;

import java.io.InputStream;
import java.text.SimpleDateFormat;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.irfeyal.modelo.matricula.Matricula;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class EnvioEmail {

	@Autowired
	private JavaMailSender mailSender;
	private String subject = "Notificacion de Matricula IRFEYAL";
	private String content;
	private String[] listEntregados;
	
	private static final BaseColor color = new BaseColor(19, 63, 120);
	private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLD, color);
	private static final Font bold = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD);
	private static final Font textoTabla = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
	private SimpleDateFormat formatAfecha = new SimpleDateFormat("MMMM/yyyy");
	private String[] requeridos= {"Ficha de Inscripcion","Copia de Cédula", "Copia certificado de votación","Certificado de matricula"};

	public String sendEmailHtml(Matricula matricula, String requisitos) {
		String to = matricula.getEstudiante().getCorreo().getCorreo();
		String nombre = matricula.getEstudiante().getId_persona().getNombre().toUpperCase();
		String[] saludo= nombre.split(" ");
		nombre= saludo[0];
		listEntregados = requisitos.split("-");

		content = "<!doctype html>\r\n" + "<html ⚡4email data-css-strict>\r\n" + "\r\n" + "<head>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n" + "    <style amp4email-boilerplate>\r\n" + "        body {\r\n"
				+ "            visibility: hidden\r\n" + "        }\r\n" + "    </style>\r\n"
				+ "    <script async src=\"https://cdn.ampproject.org/v0.js\"></script>\r\n"
				+ "    <style amp-custom>\r\n" + "        .es-desk-hidden {\r\n" + "            display: none;\r\n"
				+ "            float: left;\r\n" + "            overflow: hidden;\r\n" + "            width: 0;\r\n"
				+ "            max-height: 0;\r\n" + "            line-height: 0;\r\n" + "        }\r\n" + "\r\n"
				+ "        s {\r\n" + "            text-decoration: line-through;\r\n" + "        }\r\n" + "\r\n"
				+ "        body {\r\n" + "            width: 100%;\r\n"
				+ "            font-family: \"open sans\", \"helvetica neue\", helvetica, arial, sans-serif;\r\n"
				+ "        }\r\n" + "\r\n" + "        table {\r\n" + "            border-collapse: collapse;\r\n"
				+ "            border-spacing: 0px;\r\n" + "        }\r\n" + "\r\n" + "        table td,\r\n"
				+ "        html,\r\n" + "        body,\r\n" + "        .es-wrapper {\r\n"
				+ "            padding: 0;\r\n" + "            Margin: 0;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-content,\r\n" + "        .es-header,\r\n" + "        .es-footer {\r\n"
				+ "            table-layout: fixed;\r\n" + "            width: 100%;\r\n" + "        }\r\n" + "\r\n"
				+ "        p,\r\n" + "        hr {\r\n" + "            Margin: 0;\r\n" + "        }\r\n" + "\r\n"
				+ "        h1,\r\n" + "        h2,\r\n" + "        h3,\r\n" + "        h4,\r\n" + "        h5 {\r\n"
				+ "            Margin: 0;\r\n" + "            line-height: 120%;\r\n"
				+ "            font-family: \"open sans\", \"helvetica neue\", helvetica, arial, sans-serif;\r\n"
				+ "        }\r\n" + "\r\n" + "        .es-left {\r\n" + "            float: left;\r\n" + "        }\r\n"
				+ "\r\n" + "        .es-right {\r\n" + "            float: right;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p5 {\r\n" + "            padding: 5px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p5t {\r\n" + "            padding-top: 5px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p5b {\r\n" + "            padding-bottom: 5px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p5l {\r\n" + "            padding-left: 5px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p5r {\r\n" + "            padding-right: 5px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p10 {\r\n" + "            padding: 10px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p10t {\r\n" + "            padding-top: 10px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p10b {\r\n" + "            padding-bottom: 10px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p10l {\r\n" + "            padding-left: 10px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p10r {\r\n" + "            padding-right: 10px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p15 {\r\n" + "            padding: 15px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p15t {\r\n" + "            padding-top: 15px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p15b {\r\n" + "            padding-bottom: 15px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p15l {\r\n" + "            padding-left: 15px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p15r {\r\n" + "            padding-right: 15px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p20 {\r\n" + "            padding: 20px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p20t {\r\n" + "            padding-top: 20px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p20b {\r\n" + "            padding-bottom: 20px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p20l {\r\n" + "            padding-left: 20px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p20r {\r\n" + "            padding-right: 20px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p25 {\r\n" + "            padding: 25px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p25t {\r\n" + "            padding-top: 25px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p25b {\r\n" + "            padding-bottom: 25px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p25l {\r\n" + "            padding-left: 25px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p25r {\r\n" + "            padding-right: 25px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p30 {\r\n" + "            padding: 30px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p30t {\r\n" + "            padding-top: 30px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p30b {\r\n" + "            padding-bottom: 30px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p30l {\r\n" + "            padding-left: 30px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p30r {\r\n" + "            padding-right: 30px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p35 {\r\n" + "            padding: 35px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p35t {\r\n" + "            padding-top: 35px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p35b {\r\n" + "            padding-bottom: 35px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p35l {\r\n" + "            padding-left: 35px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p35r {\r\n" + "            padding-right: 35px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p40 {\r\n" + "            padding: 40px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p40t {\r\n" + "            padding-top: 40px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p40b {\r\n" + "            padding-bottom: 40px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p40l {\r\n" + "            padding-left: 40px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-p40r {\r\n" + "            padding-right: 40px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-menu td {\r\n" + "            border: 0;\r\n" + "        }\r\n" + "\r\n"
				+ "        a {\r\n" + "            text-decoration: none;\r\n" + "        }\r\n" + "\r\n"
				+ "        p,\r\n" + "        ul li,\r\n" + "        ol li {\r\n"
				+ "            font-family: \"open sans\", \"helvetica neue\", helvetica, arial, sans-serif;\r\n"
				+ "            line-height: 150%;\r\n" + "        }\r\n" + "\r\n" + "        ul li,\r\n"
				+ "        ol li {\r\n" + "            Margin-bottom: 15px;\r\n" + "            margin-left: 0;\r\n"
				+ "        }\r\n" + "\r\n" + "        .es-menu td a {\r\n" + "            text-decoration: none;\r\n"
				+ "            display: block;\r\n"
				+ "            font-family: \"open sans\", \"helvetica neue\", helvetica, arial, sans-serif;\r\n"
				+ "        }\r\n" + "\r\n" + "        .es-menu amp-img,\r\n" + "        .es-button amp-img {\r\n"
				+ "            vertical-align: middle;\r\n" + "        }\r\n" + "\r\n" + "        .es-wrapper {\r\n"
				+ "            width: 100%;\r\n" + "            height: 100%;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-wrapper-color {\r\n" + "            background-color: #EEEEEE;\r\n" + "        }\r\n"
				+ "\r\n" + "        .es-header {\r\n" + "            background-color: transparent;\r\n"
				+ "        }\r\n" + "\r\n" + "        .es-header-body {\r\n"
				+ "            background-color: #044767;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-header-body p,\r\n" + "        .es-header-body ul li,\r\n"
				+ "        .es-header-body ol li {\r\n" + "            color: #FFFFFF;\r\n"
				+ "            font-size: 14px;\r\n" + "        }\r\n" + "\r\n" + "        .es-header-body a {\r\n"
				+ "            color: #FFFFFF;\r\n" + "            font-size: 14px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-content-body {\r\n" + "            background-color: #FFFFFF;\r\n" + "        }\r\n"
				+ "\r\n" + "        .es-content-body p,\r\n" + "        .es-content-body ul li,\r\n"
				+ "        .es-content-body ol li {\r\n" + "            color: #333333;\r\n"
				+ "            font-size: 15px;\r\n" + "        }\r\n" + "\r\n" + "        .es-content-body a {\r\n"
				+ "            color: #ED8E20;\r\n" + "            font-size: 15px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-footer {\r\n" + "            background-color: transparent;\r\n" + "        }\r\n"
				+ "\r\n" + "        .es-footer-body {\r\n" + "            background-color: #FFFFFF;\r\n"
				+ "        }\r\n" + "\r\n" + "        .es-footer-body p,\r\n" + "        .es-footer-body ul li,\r\n"
				+ "        .es-footer-body ol li {\r\n" + "            color: #333333;\r\n"
				+ "            font-size: 14px;\r\n" + "        }\r\n" + "\r\n" + "        .es-footer-body a {\r\n"
				+ "            color: #333333;\r\n" + "            font-size: 14px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-infoblock,\r\n" + "        .es-infoblock p,\r\n" + "        .es-infoblock ul li,\r\n"
				+ "        .es-infoblock ol li {\r\n" + "            line-height: 120%;\r\n"
				+ "            font-size: 12px;\r\n" + "            color: #CCCCCC;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-infoblock a {\r\n" + "            font-size: 12px;\r\n"
				+ "            color: #CCCCCC;\r\n" + "        }\r\n" + "\r\n" + "        h1 {\r\n"
				+ "            font-size: 36px;\r\n" + "            font-style: normal;\r\n"
				+ "            font-weight: bold;\r\n" + "            color: #333333;\r\n" + "        }\r\n" + "\r\n"
				+ "        h2 {\r\n" + "            font-size: 24px;\r\n" + "            font-style: normal;\r\n"
				+ "            font-weight: bold;\r\n" + "            color: #333333;\r\n" + "        }\r\n" + "\r\n"
				+ "        h3 {\r\n" + "            font-size: 18px;\r\n" + "            font-style: normal;\r\n"
				+ "            font-weight: bold;\r\n" + "            color: #333333;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-header-body h1 a,\r\n" + "        .es-content-body h1 a,\r\n"
				+ "        .es-footer-body h1 a {\r\n" + "            font-size: 36px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-header-body h2 a,\r\n" + "        .es-content-body h2 a,\r\n"
				+ "        .es-footer-body h2 a {\r\n" + "            font-size: 24px;\r\n" + "        }\r\n" + "\r\n"
				+ "        .es-header-body h3 a,\r\n" + "        .es-content-body h3 a,\r\n"
				+ "        .es-footer-body h3 a {\r\n" + "            font-size: 18px;\r\n" + "        }\r\n" + "\r\n"
				+ "        a.es-button,\r\n" + "        button.es-button {\r\n" + "            border-style: solid;\r\n"
				+ "            border-color: #ED8E20;\r\n" + "            border-width: 15px 30px 15px 30px;\r\n"
				+ "            display: inline-block;\r\n" + "            background: #ED8E20;\r\n"
				+ "            border-radius: 5px;\r\n" + "            font-size: 16px;\r\n"
				+ "            font-family: \"open sans\", \"helvetica neue\", helvetica, arial, sans-serif;\r\n"
				+ "            font-weight: bold;\r\n" + "            font-style: normal;\r\n"
				+ "            line-height: 120%;\r\n" + "            color: #FFFFFF;\r\n"
				+ "            text-decoration: none;\r\n" + "            width: auto;\r\n"
				+ "            text-align: center;\r\n" + "        }\r\n" + "\r\n" + "        .es-button-border {\r\n"
				+ "            border-style: solid solid solid solid;\r\n"
				+ "            border-color: transparent transparent transparent transparent;\r\n"
				+ "            background: #ED8E20;\r\n" + "            border-width: 0px 0px 0px 0px;\r\n"
				+ "            display: inline-block;\r\n" + "            border-radius: 5px;\r\n"
				+ "            width: auto;\r\n" + "        }\r\n" + "\r\n" + "        .es-p-default {\r\n"
				+ "            padding-top: 20px;\r\n" + "            padding-right: 35px;\r\n"
				+ "            padding-bottom: 0px;\r\n" + "            padding-left: 35px;\r\n" + "        }\r\n"
				+ "\r\n" + "        .es-p-all-default {\r\n" + "            padding: 0px;\r\n" + "        }\r\n"
				+ "\r\n" + "        @media only screen and (max-width:600px) {\r\n" + "\r\n" + "            p,\r\n"
				+ "            ul li,\r\n" + "            ol li,\r\n" + "            a {\r\n"
				+ "                line-height: 150%\r\n" + "            }\r\n" + "\r\n" + "            h1,\r\n"
				+ "            h2,\r\n" + "            h3,\r\n" + "            h1 a,\r\n" + "            h2 a,\r\n"
				+ "            h3 a {\r\n" + "                line-height: 120%\r\n" + "            }\r\n" + "\r\n"
				+ "            h1 {\r\n" + "                font-size: 32px;\r\n"
				+ "                text-align: center\r\n" + "            }\r\n" + "\r\n" + "            h2 {\r\n"
				+ "                font-size: 26px;\r\n" + "                text-align: center\r\n"
				+ "            }\r\n" + "\r\n" + "            h3 {\r\n" + "                font-size: 20px;\r\n"
				+ "                text-align: center\r\n" + "            }\r\n" + "\r\n"
				+ "            .es-header-body h1 a,\r\n" + "            .es-content-body h1 a,\r\n"
				+ "            .es-footer-body h1 a {\r\n" + "                font-size: 32px\r\n" + "            }\r\n"
				+ "\r\n" + "            .es-header-body h2 a,\r\n" + "            .es-content-body h2 a,\r\n"
				+ "            .es-footer-body h2 a {\r\n" + "                font-size: 26px\r\n" + "            }\r\n"
				+ "\r\n" + "            .es-header-body h3 a,\r\n" + "            .es-content-body h3 a,\r\n"
				+ "            .es-footer-body h3 a {\r\n" + "                font-size: 20px\r\n" + "            }\r\n"
				+ "\r\n" + "            .es-menu td a {\r\n" + "                font-size: 16px\r\n"
				+ "            }\r\n" + "\r\n" + "            .es-header-body p,\r\n"
				+ "            .es-header-body ul li,\r\n" + "            .es-header-body ol li,\r\n"
				+ "            .es-header-body a {\r\n" + "                font-size: 16px\r\n" + "            }\r\n"
				+ "\r\n" + "            .es-content-body p,\r\n" + "            .es-content-body ul li,\r\n"
				+ "            .es-content-body ol li,\r\n" + "            .es-content-body a {\r\n"
				+ "                font-size: 16px\r\n" + "            }\r\n" + "\r\n"
				+ "            .es-footer-body p,\r\n" + "            .es-footer-body ul li,\r\n"
				+ "            .es-footer-body ol li,\r\n" + "            .es-footer-body a {\r\n"
				+ "                font-size: 16px\r\n" + "            }\r\n" + "\r\n"
				+ "            .es-infoblock p,\r\n" + "            .es-infoblock ul li,\r\n"
				+ "            .es-infoblock ol li,\r\n" + "            .es-infoblock a {\r\n"
				+ "                font-size: 12px\r\n" + "            }\r\n" + "\r\n"
				+ "            *[class=\"gmail-fix\"] {\r\n" + "                display: none\r\n" + "            }\r\n"
				+ "\r\n" + "            .es-m-txt-c,\r\n" + "            .es-m-txt-c h1,\r\n"
				+ "            .es-m-txt-c h2,\r\n" + "            .es-m-txt-c h3 {\r\n"
				+ "                text-align: center\r\n" + "            }\r\n" + "\r\n"
				+ "            .es-m-txt-r,\r\n" + "            .es-m-txt-r h1,\r\n" + "            .es-m-txt-r h2,\r\n"
				+ "            .es-m-txt-r h3 {\r\n" + "                text-align: right\r\n" + "            }\r\n"
				+ "\r\n" + "            .es-m-txt-l,\r\n" + "            .es-m-txt-l h1,\r\n"
				+ "            .es-m-txt-l h2,\r\n" + "            .es-m-txt-l h3 {\r\n"
				+ "                text-align: left\r\n" + "            }\r\n" + "\r\n"
				+ "            .es-m-txt-r amp-img {\r\n" + "                float: right\r\n" + "            }\r\n"
				+ "\r\n" + "            .es-m-txt-c amp-img {\r\n" + "                margin: 0 auto\r\n"
				+ "            }\r\n" + "\r\n" + "            .es-m-txt-l amp-img {\r\n"
				+ "                float: left\r\n" + "            }\r\n" + "\r\n"
				+ "            .es-button-border {\r\n" + "                display: inline-block\r\n"
				+ "            }\r\n" + "\r\n" + "            a.es-button,\r\n" + "            button.es-button {\r\n"
				+ "                font-size: 16px;\r\n" + "                display: inline-block;\r\n"
				+ "                border-width: 15px 30px 15px 30px\r\n" + "            }\r\n" + "\r\n"
				+ "            .es-btn-fw {\r\n" + "                border-width: 10px 0px;\r\n"
				+ "                text-align: center\r\n" + "            }\r\n" + "\r\n"
				+ "            .es-adaptive table,\r\n" + "            .es-btn-fw,\r\n"
				+ "            .es-btn-fw-brdr,\r\n" + "            .es-left,\r\n" + "            .es-right {\r\n"
				+ "                width: 100%\r\n" + "            }\r\n" + "\r\n"
				+ "            .es-content table,\r\n" + "            .es-header table,\r\n"
				+ "            .es-footer table,\r\n" + "            .es-content,\r\n" + "            .es-footer,\r\n"
				+ "            .es-header {\r\n" + "                width: 100%;\r\n"
				+ "                max-width: 600px\r\n" + "            }\r\n" + "\r\n"
				+ "            .es-adapt-td {\r\n" + "                display: block;\r\n"
				+ "                width: 100%\r\n" + "            }\r\n" + "\r\n" + "            .adapt-img {\r\n"
				+ "                width: 100%;\r\n" + "                height: auto\r\n" + "            }\r\n" + "\r\n"
				+ "            td.es-m-p0 {\r\n" + "                padding: 0px\r\n" + "            }\r\n" + "\r\n"
				+ "            td.es-m-p0r {\r\n" + "                padding-right: 0px\r\n" + "            }\r\n"
				+ "\r\n" + "            td.es-m-p0l {\r\n" + "                padding-left: 0px\r\n"
				+ "            }\r\n" + "\r\n" + "            td.es-m-p0t {\r\n"
				+ "                padding-top: 0px\r\n" + "            }\r\n" + "\r\n"
				+ "            td.es-m-p0b {\r\n" + "                padding-bottom: 0\r\n" + "            }\r\n"
				+ "\r\n" + "            td.es-m-p20b {\r\n" + "                padding-bottom: 20px\r\n"
				+ "            }\r\n" + "\r\n" + "            .es-mobile-hidden,\r\n" + "            .es-hidden {\r\n"
				+ "                display: none\r\n" + "            }\r\n" + "\r\n"
				+ "            tr.es-desk-hidden,\r\n" + "            td.es-desk-hidden,\r\n"
				+ "            table.es-desk-hidden {\r\n" + "                width: auto;\r\n"
				+ "                overflow: visible;\r\n" + "                float: none;\r\n"
				+ "                max-height: inherit;\r\n" + "                line-height: inherit\r\n"
				+ "            }\r\n" + "\r\n" + "            tr.es-desk-hidden {\r\n"
				+ "                display: table-row\r\n" + "            }\r\n" + "\r\n"
				+ "            table.es-desk-hidden {\r\n" + "                display: table\r\n" + "            }\r\n"
				+ "\r\n" + "            td.es-desk-menu-hidden {\r\n" + "                display: table-cell\r\n"
				+ "            }\r\n" + "\r\n" + "            .es-menu td {\r\n" + "                width: 1%\r\n"
				+ "            }\r\n" + "\r\n" + "            table.es-table-not-adapt,\r\n"
				+ "            .esd-block-html table {\r\n" + "                width: auto\r\n" + "            }\r\n"
				+ "\r\n" + "            table.es-social {\r\n" + "                display: inline-block\r\n"
				+ "            }\r\n" + "\r\n" + "            table.es-social td {\r\n"
				+ "                display: inline-block\r\n" + "            }\r\n" + "        }\r\n"
				+ "    </style>\r\n" + "</head>\r\n" + "\r\n" + "<body>\r\n"
				+ "    <div class=\"es-wrapper-color\">\r\n"
				+ "        <!--[if gte mso 9]><v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\"> <v:fill type=\"tile\" color=\"#eeeeee\"></v:fill> </v:background><![endif]-->\r\n"
				+ "        <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
				+ "            <tr>\r\n" + "                <td valign=\"top\">\r\n"
				+ "                    <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n"
				+ "                        <tr></tr>\r\n" + "                        <tr>\r\n"
				+ "                            <td align=\"center\">\r\n"
				+ "                                <table class=\"es-header-body\" style=\"background-color: #044767\" width=\"600\"\r\n"
				+ "                                    cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#044767\" align=\"center\">\r\n"
				+ "                                    <tr>\r\n"
				+ "                                        <td class=\"es-p35t es-p35b es-p35r es-p35l\" align=\"left\">\r\n"
				+ "                                            <!--[if mso]><table width=\"530\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"340\" valign=\"top\"><![endif]-->\r\n"
				+ "                                            <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\r\n"
				+ "                                                <tr>\r\n"
				+ "                                                    <td class=\"es-m-p0r es-m-p20b\" width=\"340\" valign=\"top\"\r\n"
				+ "                                                        align=\"center\">\r\n"
				+ "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\r\n"
				+ "                                                            role=\"presentation\">\r\n"
				+ "                                                            <tr>\r\n"
				+ "                                                                <td class=\"es-m-txt-c\" align=\"left\">\r\n"
				+ "                                                                    <h1\r\n"
				+ "                                                                        style=\"color: #ffffff;line-height: 100%;font-family: 'open sans', 'helvetica neue', helvetica, arial, sans-serif\">\r\n"
				+ "                                                                        IRFEYAL</h1>\r\n"
				+ "                                                                </td>\r\n"
				+ "                                                            </tr>\r\n"
				+ "                                                        </table>\r\n"
				+ "                                                    </td>\r\n"
				+ "                                                </tr>\r\n"
				+ "                                            </table>\r\n"
				+ "                                            <!--[if mso]></td><td width=\"20\"></td><td width=\"170\" valign=\"top\"><![endif]-->\r\n"
				+ "                                            <table cellspacing=\"0\" cellpadding=\"0\" align=\"right\">\r\n"
				+ "                                                <tr class=\"es-hidden\">\r\n"
				+ "                                                    <td class=\"es-m-p20b\" width=\"170\" align=\"left\">\r\n"
				+ "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\r\n"
				+ "                                                            role=\"presentation\">\r\n"
				+ "                                                            <tr>\r\n"
				+ "                                                                <td class=\"es-p5b\" align=\"center\" style=\"font-size:0\">\r\n"
				+ "                                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\r\n"
				+ "                                                                        border=\"0\" role=\"presentation\">\r\n"
				+ "                                                                        <tr>\r\n"
				+ "                                                                            <td\r\n"
				+ "                                                                                style=\"border-bottom: 1px solid #044767;background: rgba(0, 0, 0, 0) none repeat scroll 0% 0%;height: 1px;width: 100%;margin: 0px\">\r\n"
				+ "                                                                            </td>\r\n"
				+ "                                                                        </tr>\r\n"
				+ "                                                                    </table>\r\n"
				+ "                                                                </td>\r\n"
				+ "                                                            </tr>\r\n"
				+ "                                                            <tr>\r\n"
				+ "                                                                <td>\r\n"
				+ "                                                                    <table cellspacing=\"0\" cellpadding=\"0\" align=\"right\"\r\n"
				+ "                                                                        role=\"presentation\">\r\n"
				+ "                                                                        <tr>\r\n"
				+ "                                                                            <td align=\"left\">\r\n"
				+ "                                                                                <table width=\"100%\" cellspacing=\"0\"\r\n"
				+ "                                                                                    cellpadding=\"0\" role=\"presentation\">\r\n"
				+ "                                                                                    <tr>\r\n"
				+ "                                                                                        <td align=\"right\">\r\n"
				+ "                                                                                            <p><br></p>\r\n"
				+ "                                                                                        </td>\r\n"
				+ "                                                                                    </tr>\r\n"
				+ "                                                                                </table>\r\n"
				+ "                                                                            </td>\r\n"
				+ "                                                                            <td class=\"es-p10l\" valign=\"top\"\r\n"
				+ "                                                                                align=\"left\" style=\"font-size:0\"><a\r\n"
				+ "                                                                                    href=\"https://viewstripo.email\"\r\n"
				+ "                                                                                    target=\"_blank\">\r\n"
				+ "                                                                                    <!-- <amp-img\r\n"
				+ "                                                                                        src=\"https://vitbqe.stripocdn.email/content/guids/CABINET_75694a6fc3c4633b3ee8e3c750851c02/images/77981522050090360.png\"\r\n"
				+ "                                                                                        alt style=\"display: block\"\r\n"
				+ "                                                                                        width=\"27\" height=\"23\">\r\n"
				+ "                                                                                    </amp-img> -->\r\n"
				+ "                                                                                </a></td>\r\n"
				+ "                                                                        </tr>\r\n"
				+ "                                                                    </table>\r\n"
				+ "                                                                </td>\r\n"
				+ "                                                            </tr>\r\n"
				+ "                                                        </table>\r\n"
				+ "                                                    </td>\r\n"
				+ "                                                </tr>\r\n"
				+ "                                            </table>\r\n"
				+ "                                            <!--[if mso]></td></tr></table><![endif]-->\r\n"
				+ "                                        </td>\r\n" + "                                    </tr>\r\n"
				+ "                                </table>\r\n" + "                            </td>\r\n"
				+ "                        </tr>\r\n" + "                    </table>\r\n"
				+ "                    <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n"
				+ "                        <tr>\r\n" + "                            <td align=\"center\">\r\n"
				+ "                                <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\"\r\n"
				+ "                                    bgcolor=\"#ffffff\" align=\"center\">\r\n"
				+ "                                    <tr>\r\n"
				+ "                                        <td class=\"es-p40t es-p35r es-p35l\" align=\"left\">\r\n"
				+ "                                            <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
				+ "                                                <tr>\r\n"
				+ "                                                    <td width=\"530\" valign=\"top\" align=\"center\">\r\n"
				+ "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\r\n"
				+ "                                                            role=\"presentation\">\r\n"
				+ "                                                            <tr>\r\n"
				+ "                                                                <td class=\"es-m-txt-l es-p15t\" align=\"left\">\r\n"
				+ "                                                                    <h3>Hola " + nombre
				+ ",</h3>\r\n" + "                                                                </td>\r\n"
				+ "                                                            </tr>\r\n"
				+ "                                                            <tr>\r\n"
				+ "                                                                <td class=\"es-p15t es-p10b\" align=\"left\">\r\n"
				+ "                                                                    <p\r\n"
				+ "                                                                        style=\"font-size: 16px;color: #777777;font-family: 'open sans', 'helvetica neue', helvetica, arial, sans-serif\">\r\n"
				+ "                                                                        Te damos la bienvenida y te informamos que tu\r\n"
				+ "                                                                        matricula ha sido registrada con exito.</p>\r\n"
				+ "                                                                </td>\r\n"
				+ "                                                            </tr>\r\n"
				+ "                                                            <tr>\r\n"
				+ "                                                                <td class=\"es-p20t es-p15b\" align=\"center\"\r\n"
				+ "                                                                    style=\"font-size:0\">\r\n"
				+ "                                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\r\n"
				+ "                                                                        border=\"0\" role=\"presentation\">\r\n"
				+ "                                                                        <tr>\r\n"
				+ "                                                                            <td\r\n"
				+ "                                                                                style=\"border-bottom: 3px solid #eeeeee;background: rgba(0, 0, 0, 0) none repeat scroll 0% 0%;height: 1px;width: 100%;margin: 0px\">\r\n"
				+ "                                                                            </td>\r\n"
				+ "                                                                        </tr>\r\n"
				+ "                                                                    </table>\r\n"
				+ "                                                                </td>\r\n"
				+ "                                                            </tr>\r\n"
				+ "                                                        </table>\r\n"
				+ "                                                    </td>\r\n"
				+ "                                                </tr>\r\n"
				+ "                                            </table>\r\n"
				+ "                                        </td>\r\n" + "                                    </tr>\r\n"
				+ "                                </table>\r\n" + "                            </td>\r\n"
				+ "                        </tr>\r\n" + "                    </table>\r\n"
				+ "                    <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\">\r\n"
				+ "                        <tr>\r\n" + "                            <td align=\"center\">\r\n"
				+ "                                <table class=\"es-footer-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\"\r\n"
				+ "                                    align=\"center\">\r\n"
				+ "                                    <tr>\r\n"
				+ "                                        <td class=\"es-p35t es-p40b es-p35r es-p35l\" align=\"left\">\r\n"
				+ "                                            <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
				+ "                                                <tr>\r\n"
				+ "                                                    <td width=\"530\" valign=\"top\" align=\"center\">\r\n"
				+ "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\r\n"
				+ "                                                            role=\"presentation\">\r\n"
				+ "                                                            <tr>\r\n"
				+ "                                                                <td align=\"left\" class=\"es-m-txt-c es-p5b\">\r\n"
				+ "                                                                    <p style=\"color: #777777\">Nota: Este correo ha sido\r\n"
				+ "                                                                        generado de forma automática, no responder al\r\n"
				+ "                                                                        mismo.</p>\r\n"
				+ "                                                                </td>\r\n"
				+ "                                                            </tr>\r\n"
				+ "                                                        </table>\r\n"
				+ "                                                    </td>\r\n"
				+ "                                                </tr>\r\n"
				+ "                                            </table>\r\n"
				+ "                                        </td>\r\n" + "                                    </tr>\r\n"
				+ "                                </table>\r\n" + "                            </td>\r\n"
				+ "                        </tr>\r\n" + "                    </table>\r\n"
				+ "                    <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n"
				+ "                        <tr>\r\n" + "                            <td align=\"center\">\r\n"
				+ "                                <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\"\r\n"
				+ "                                    bgcolor=\"#ffffff\" align=\"center\">\r\n"
				+ "                                    <tr>\r\n"
				+ "                                        <td class=\"es-p15t es-p35r es-p35l\" align=\"left\">\r\n"
				+ "                                            <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
				+ "                                                <tr>\r\n"
				+ "                                                    <td width=\"530\" valign=\"top\" align=\"center\">\r\n"
				+ "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\r\n"
				+ "                                                            role=\"presentation\">\r\n"
				+ "                                                            <tr>\r\n"
				+ "                                                                <td align=\"center\" style=\"font-size:0\">\r\n"
				+ "                                                                    <amp-img\r\n"
				+ "                                                                        src=\"https://vitbqe.stripocdn.email/content/guids/CABINET_75694a6fc3c4633b3ee8e3c750851c02/images/18501522065897895.png\"\r\n"
				+ "                                                                        alt style=\"display: block\" width=\"46\"\r\n"
				+ "                                                                        height=\"22\"></amp-img>\r\n"
				+ "                                                                </td>\r\n"
				+ "                                                            </tr>\r\n"
				+ "                                                        </table>\r\n"
				+ "                                                    </td>\r\n"
				+ "                                                </tr>\r\n"
				+ "                                            </table>\r\n"
				+ "                                        </td>\r\n" + "                                    </tr>\r\n"
				+ "                                </table>\r\n" + "                            </td>\r\n"
				+ "                        </tr>\r\n" + "                    </table>\r\n" + "                </td>\r\n"
				+ "            </tr>\r\n" + "        </table>\r\n" + "    </div>\r\n" + "</body>\r\n" + "\r\n"
				+ "</html>";

		MimeMessage mailMessage = this.mailSender.createMimeMessage();
		String enviado = "";
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
			final ByteArrayOutputStream stream = createInMemoryDocument(matricula);
//			    final InputStreamSource attachment = new ByteArrayResource(stream.toByteArray());
			final InputStream inputStream = new ByteArrayInputStream(stream.toByteArray());
			final ByteArrayDataSource attachment = new ByteArrayDataSource(inputStream, "application/pdf");
			messageHelper.setTo(to);
			messageHelper.setSubject(subject);
			messageHelper.setText(content, true);

			messageHelper.addAttachment("MatriculaReporte.pdf", attachment);
			mailSender.send(mailMessage);

			enviado = "Correo Enviado";
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
		return enviado;
	}

	private ByteArrayOutputStream createInMemoryDocument(Matricula datosMatricula) {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {

			Document document = new Document(PageSize.A4);
			String localDir = this.getClass().getClassLoader().getResource("logo.png").toString();

			Image logo = Image.getInstance(localDir);

			logo.scalePercent(17f);
			logo.setAlignment(Element.ALIGN_LEFT);

			Paragraph titulo = new Paragraph("IRFEYAL", chapterFont);

			titulo.add(logo);
			PdfPTable tabla = new PdfPTable(2);

			PdfPCell celda0 = new PdfPCell(new Phrase("Datos de Matricula", textoTabla));
			celda0.setColspan(4);
			celda0.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda0.setBackgroundColor(color);
			PdfPCell textMalla = new PdfPCell(new Phrase("Malla Curricular: ", textoTabla));
			textMalla.setBackgroundColor(color);
			PdfPCell celdaMalla = new PdfPCell(new Phrase(datosMatricula.getId_periodo().getMalla().getDescripcion()));
			PdfPCell textCurso = new PdfPCell(new Phrase("Curso: ", textoTabla));
			textCurso.setBackgroundColor(color);
			PdfPCell celda1 = new PdfPCell(new Phrase(datosMatricula.getCurso().getDescripcion()));
			PdfPCell textModalidad = new PdfPCell(new Phrase("Modalida de Estudio: ", textoTabla));
			textModalidad.setBackgroundColor(color);
			PdfPCell celda2 = new PdfPCell(new Phrase(datosMatricula.getModalidad().getDescripcion()));
			PdfPCell textParalelo = new PdfPCell(new Phrase("Paralelo: ", textoTabla));
			textParalelo.setBackgroundColor(color);
			PdfPCell celda3 = new PdfPCell(new Phrase(datosMatricula.getId_paralelo().getDescripcion()));
			PdfPCell textPeriodo = new PdfPCell(new Phrase("Periodo: ", textoTabla));
			textPeriodo.setBackgroundColor(color);
			PdfPCell celda4 = new PdfPCell(new Phrase(formatAfecha.format(datosMatricula.getId_periodo().getFecha_inicio()) +"-"+ formatAfecha.format(datosMatricula.getId_periodo().getFecha_fin()) ));

			tabla.addCell(celda0);
			tabla.addCell(textMalla);
			tabla.addCell(celdaMalla);
			tabla.addCell(textCurso);
			tabla.addCell(celda1);
			tabla.addCell(textModalidad);
			tabla.addCell(celda2);
			tabla.addCell(textParalelo);
			tabla.addCell(celda3);
			tabla.addCell(textPeriodo);
			tabla.addCell(celda4);
			tabla.setWidthPercentage(60);

			PdfWriter.getInstance(document, bos);
			document.open();
			titulo.setAlignment(1);
//			   document.add(logo);
			document.add(titulo);
			
			
			Paragraph cedula= new Paragraph();
			Chunk cedPart1 = new Chunk("Cédula: ", bold);
			Chunk cedPart2 = new Chunk(datosMatricula.getEstudiante().getId_persona().getCedula());
			
			cedula.add(cedPart1);
			cedula.add(cedPart2);
						
			Paragraph names= new Paragraph();
			Chunk namPart1 = new Chunk("Apellidos/Nombres: ", bold);
			Chunk namPart2 = new Chunk((datosMatricula.getEstudiante().getId_persona().getApellido()
					+ " " + datosMatricula.getEstudiante().getId_persona().getNombre()).toUpperCase());
			names.add(namPart1);
			names.add(namPart2);
			
			Paragraph matricula= new Paragraph();
			Chunk matPart1 = new Chunk("Fecha y Hora de Matricula: ", bold);
			Chunk matPart2 = new Chunk(formatter.format(datosMatricula.getFechaMatricula()));
			matricula.add(matPart1);
			matricula.add(matPart2);
			
			document.add(cedula);
			document.add(names);
			document.add(matricula);
			
//			document.add(new Paragraph("CÉDULA: " + datosMatricula.getEstudiante().getId_persona().getCedula()));
//			document.add(
//					new Paragraph("APELLIDOS/NOMBRES: " + (datosMatricula.getEstudiante().getId_persona().getApellido()
//							+ " " + datosMatricula.getEstudiante().getId_persona().getNombre()).toUpperCase()));
//			document.add(new Paragraph(
//					"FECHA Y HORA DE MATRICULA: " + formatter.format(datosMatricula.getFechaMatricula())));
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);

			Paragraph texto = new Paragraph();
			Chunk textPart1 = new Chunk("IRFEYAL", bold);
			Chunk textPart2 = new Chunk(
					" le da la bienvenida a una nueva meta en su vida; acontinuación se detalla la información de su matricula.");
			texto.add(textPart1);
			texto.add(textPart2);
			texto.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(texto);

			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(tabla);

			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);

			Paragraph requerimientos = new Paragraph();
			Chunk requridos = new Chunk("Documentos Requeridos:", bold);
			requerimientos.add(requridos);
			document.add(requerimientos);
			for (int i = 0; i < requeridos.length; i++) {
				document.add(new Paragraph(requeridos[i].toString()));
			}
			
			document.add(Chunk.NEWLINE);
			Paragraph entregados = new Paragraph();
			Chunk listentregados = new Chunk("Documentos no Entregados:", bold);
			entregados.add(listentregados);
			document.add(entregados);
			int cont=0;
				for (int p = 0; p < requeridos.length; p++) {
					cont=0;
						for (int i = 0; i < listEntregados.length; i++) {
							if (requeridos[p].equals(listEntregados[i])) {
								cont++;
							}
							if(cont == 0 && i== listEntregados.length-1){
								document.add(new Paragraph(requeridos[p].toString()));
							}
						}	
				}
			
			document.close();
			return bos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
